package space.impact.gregtechbridge.asm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.Launch;

import org.apache.logging.log4j.LogManager;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.commons.RemappingClassAdapter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;

/** Точечные исправления байткода AE2 для старого API Impact, включая instanceof и дескрипторы. */
public final class Ae2ImpactTransformer implements IClassTransformer {

    private static final Set<String> TARGETS = new HashSet<>(Arrays.asList(
        "appeng.block.storage.BlockDrive",
        "appeng.block.storage.BlockChest",
        "appeng.items.misc.ItemEncodedPattern",
        "appeng.parts.p2p.PartP2PGT5Power",
        "appeng.items.tools.ToolNetworkVisualiser"));
    private static final Map<String, String> IMPACT_NAMES = new HashMap<>();

    static {
        IMPACT_NAMES.put("gregtech/api/GregTechAPI", "gregtech/api/GregTech_API");
        IMPACT_NAMES.put("gregtech/api/util/GTUtility", "gregtech/api/util/GT_Utility");
        IMPACT_NAMES.put("gregtech/api/enums/GTValues", "gregtech/api/enums/GT_Values");
        IMPACT_NAMES.put("gregtech/api/objects/GTHashSet", "gregtech/api/objects/GT_HashSet");
        IMPACT_NAMES.put("gregtech/common/items/ItemIntegratedCircuit", "gregtech/common/items/GT_IntegratedCircuit_Item");
    }

    private Boolean impact;

    /**
     * Применяет адаптацию только к пяти классам AE2 из {@code TARGETS} и только при наличии старого GT API.
     * Проверка окружения выполняется при первом подходящем классе и кешируется в экземпляре трансформера.
     * Посторонние классы, отсутствующий байткод и окружение с новым GregTech возвращаются без изменения.
     *
     * @param name исходное имя класса, переданное LaunchWrapper; при выборе цели не используется
     * @param transformedName имя после преобразований LaunchWrapper, по которому выбирается цель
     * @param bytes исходный байткод либо null, если класс не найден
     * @return адаптированный байткод или исходная ссылка, если применение не требуется
     */
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (bytes == null || !TARGETS.contains(transformedName)) return bytes;
        if (impact == null) {
            // Поиск ресурса не инициализирует GregTech при обнаружении coremod.
            impact = isImpactPresent();
        }
        if (!impact) return bytes;

        return transformImpactClass(transformedName, bytes);
    }

    /**
     * Определяет окружение старого GregTech по ресурсам его API, без загрузки и инициализации классов.
     * Наличие {@code GregTech_API} при отсутствии {@code GregTechAPI} позволяет безопасно проверять
     * условие во время ранней загрузки coremod и отбора поздних миксинов.
     * Проверка различает поколения API, а не конкретный номер или дистрибутив GregTech.
     *
     * @return true, если classloader видит старый API и не видит новый
     */
    public static boolean isImpactPresent() {
        return Launch.classLoader.getResource("gregtech/api/GregTech_API.class") != null
            && Launch.classLoader.getResource("gregtech/api/GregTechAPI.class") == null;
    }

    /**
     * Переписывает выбранный класс AE2 под API Impact. Вызывающая сторона должна предварительно
     * проверить имя цели и окружение: этот метод сам не ограничивает список допустимых классов.
     *
     * <p>Переименовывает типы GT и дескрипторы полей, заменяет enum звука строковым адаптером,
     * направляет звук с double-координатами и передачу EU через совместимые функции.
     * У визуализатора удаляет ветку отсутствующих GTNH proxy-hatches.
     * Развёрнутые stack map frames передаются ремапперу; COMPUTE_MAXS пересчитывает размеры стека,
     * не загружая иерархию классов GregTech. При отсутствии признаков ремонта сохраняет исходные байты,
     * поэтому повторное применение к уже исправленному целевому классу ничего не меняет.</p>
     *
     * @param transformedName полное имя выбранного класса; используется для специальной ветки визуализатора
     * @param bytes ненулевой байткод класса до адаптации
     * @return байткод после исправлений либо исходная ссылка, если ремонт не требуется
     * @throws IllegalStateException если структура удаляемой ветки визуализатора не соответствует ожидаемой
     */
    static byte[] transformImpactClass(String transformedName, byte[] bytes) {

        ClassNode node = new ClassNode();
        new ClassReader(bytes).accept(node, ClassReader.EXPAND_FRAMES);
        if (!needsRepair(node)) return bytes;
        for (MethodNode method : node.methods) {
            if (transformedName.equals("appeng.items.tools.ToolNetworkVisualiser")) {
                removeGtnhProxyHatchBranch(method);
            }
            for (AbstractInsnNode insn : method.instructions.toArray()) {
                if (insn instanceof FieldInsnNode) {
                    FieldInsnNode field = (FieldInsnNode) insn;
                    if (field.owner.equals("gregtech/api/enums/SoundResource")
                        && field.name.equals("IC2_MACHINES_MACHINE_OVERLOAD")) {
                        method.instructions.set(field, new MethodInsnNode(Opcodes.INVOKESTATIC,
                            "space/impact/gregtechbridge/compat/Ae2GregTechCompat", "overloadSound",
                            "()Ljava/lang/String;", false));
                    }
                } else if (insn instanceof MethodInsnNode) {
                    MethodInsnNode call = (MethodInsnNode) insn;
                    if (call.owner.equals("gregtech/api/util/GTUtility") && call.name.equals("sendSoundToPlayers")) {
                        call.desc = call.desc.replace("Lgregtech/api/enums/SoundResource;", "Ljava/lang/String;");
                        // GTNH принимает double-координаты; Impact предоставляет только int-перегрузку.
                        call.owner = "space/impact/gregtechbridge/compat/Ae2GregTechCompat";
                    } else if (call.owner.equals("gregtech/api/interfaces/tileentity/IEnergyConnected")
                        && call.name.equals("injectEnergyUnits")
                        && call.desc.equals("(Lnet/minecraftforge/common/util/ForgeDirection;JJ)J")) {
                        method.instructions.set(call, new MethodInsnNode(Opcodes.INVOKESTATIC,
                            "space/impact/gregtechbridge/compat/Ae2GregTechCompat", "injectEnergyUnits",
                            "(Lgregtech/api/interfaces/tileentity/IEnergyConnected;Lnet/minecraftforge/common/util/ForgeDirection;JJ)J", false));
                    }
                }
            }
        }
        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        node.accept(new RemappingClassAdapter(writer, new Remapper() {
            /**
             * Подставляет старое внутреннее имя JVM для известных переименованных типов GregTech.
             * RemappingClassAdapter использует результат также в дескрипторах и кадрах стека:
             * например, замена владельца sWireCutterList должна сопровождаться заменой GTHashSet.
             *
             * @param typeName внутреннее имя JVM с разделителем '/', а не имя Java с точками
             * @return имя типа Impact или неизменённое имя, если оно не входит в таблицу замен
             */
            @Override
            public String map(String typeName) {
                return IMPACT_NAMES.getOrDefault(typeName, typeName);
            }
        }));
        LogManager.getLogger("GregTechBridge").info("Adapted AE2 class {} for GregTech Impact", transformedName);
        return writer.toByteArray();
    }

    /**
     * Ищет признаки ещё не адаптированного целевого класса: владельцев полей/вызовов из таблицы
     * переименований и инструкции с переименованными типами либо MTEHatchCraftingInputME.
     * Это быстрый ограниченный критерий для поддерживаемых классов, а не общий аудит их зависимостей.
     * После ремонта эти признаки исчезают, что обеспечивает идемпотентность повторного прохода.
     *
     * @param node разобранный ASM-класс, инструкции которого проверяются без изменения
     * @return true, если найден хотя бы один поддерживаемый признак несовместимости
     */
    private static boolean needsRepair(ClassNode node) {
        for (MethodNode method : node.methods) {
            for (AbstractInsnNode insn : method.instructions.toArray()) {
                if (insn instanceof FieldInsnNode && IMPACT_NAMES.containsKey(((FieldInsnNode) insn).owner)) return true;
                if (insn instanceof MethodInsnNode && IMPACT_NAMES.containsKey(((MethodInsnNode) insn).owner)) return true;
                if (insn instanceof TypeInsnNode) {
                    String type = ((TypeInsnNode) insn).desc;
                    if (IMPACT_NAMES.containsKey(type)
                        || type.equals("gregtech/common/tileentities/machines/MTEHatchCraftingInputME")) return true;
                }
            }
        }
        return false;
    }

    /**
     * Удаляет первую ветку визуализатора, которая проверяет MTEHatchCraftingInputME и его proxy-hatches.
     * Эти типы отсутствуют в Impact. Находит предыдущую проверку Platform.isGTLoaded и её IFEQ,
     * затем удаляет инструкции до целевой метки, сохраняя саму метку и остальную отправку графа ME-сети.
     * Из таблицы локальных переменных удаляются записи, границы которых попали в удалённый участок.
     *
     * <p>При отсутствии проверяемого instanceof метод ничего не меняет. Если instanceof найден,
     * но охранная проверка или граница ветки изменились, выполнение прерывается с диагностикой:
     * продолжать удаление по неподтверждённой структуре байткода нельзя.</p>
     *
     * @param method метод визуализатора, изменяемый на месте
     * @throws IllegalStateException если не найдены ожидаемые guard, IFEQ или метка конца ветки
     */
    private static void removeGtnhProxyHatchBranch(MethodNode method) {
        for (AbstractInsnNode insn : method.instructions.toArray()) {
            if (!(insn instanceof TypeInsnNode) || insn.getOpcode() != Opcodes.INSTANCEOF
                || !((TypeInsnNode) insn).desc.equals("gregtech/common/tileentities/machines/MTEHatchCraftingInputME")) {
                continue;
            }
            AbstractInsnNode start = insn.getPrevious();
            while (start != null && !(start instanceof FieldInsnNode
                && ((FieldInsnNode) start).owner.equals("appeng/util/Platform")
                && ((FieldInsnNode) start).name.equals("isGTLoaded"))) {
                start = start.getPrevious();
            }
            if (start == null) throw new IllegalStateException("AE2 proxy hatch guard changed: " + method.name);
            AbstractInsnNode jump = start.getNext();
            while (jump != null && jump.getOpcode() < 0) jump = jump.getNext();
            if (!(jump instanceof JumpInsnNode) || jump.getOpcode() != Opcodes.IFEQ) {
                throw new IllegalStateException("AE2 proxy hatch branch changed: " + method.name);
            }
            LabelNode end = ((JumpInsnNode) jump).label;
            Set<LabelNode> removedLabels = new HashSet<>();
            // В Impact нет GTNH proxy-hatches; остальной граф сети сохраняется.
            while (start != end) {
                if (start == null) throw new IllegalStateException("Missing AE2 proxy hatch branch end");
                AbstractInsnNode next = start.getNext();
                if (start instanceof LabelNode) removedLabels.add((LabelNode) start);
                method.instructions.remove(start);
                start = next;
            }
            if (method.localVariables != null) {
                method.localVariables.removeIf(v -> removedLabels.contains(v.start) || removedLabels.contains(v.end));
            }
            return;
        }
    }
}
