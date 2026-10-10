package space.impact.gregtechbridge.asm;

import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

/** Восстанавливает точку API NEE, используемую уже скомпилированными процессорами Impact-Core. */
public final class NeeImpactTransformer implements IClassTransformer {
    private static final String TARGET = "com.github.vfyjxf.nee.processor.GregTech5RecipeProcessor";
    static final String FLUID_METHOD = "getFluidFromDisplayStack";
    static final String FLUID_DESCRIPTOR = "(Lnet/minecraft/item/ItemStack;)Lnet/minecraftforge/fluids/FluidStack;";

    /**
     * Восстанавливает старую точку API NEE только в GregTech5RecipeProcessor и при старом GT API.
     * Это сохраняет совместимость уже скомпилированного Impact-Core после переноса функции в ItemUtils.
     * В остальных случаях, включая отсутствие байткода, возвращает исходную ссылку.
     *
     * @param name исходное имя класса; выбор цели производится по transformedName
     * @param transformedName полное имя преобразуемого класса
     * @param bytes байткод либо null
     * @return байткод с совместимым методом или исходные байты, если патч не применим
     */
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (bytes == null || !TARGET.equals(transformedName) || !Ae2ImpactTransformer.isImpactPresent()) return bytes;
        return restoreLegacyApi(bytes);
    }

    /**
     * Добавляет public static getFluidFromDisplayStack(ItemStack):FluidStack с прежним дескриптором.
     * Метод передаёт аргумент в одноимённую функцию ItemUtils и возвращает её результат без обработки.
     * Если такая сигнатура уже объявлена, исходный класс возвращается без изменений независимо
     * от модификаторов найденного метода: существующая реализация не заменяется.
     *
     * <p>Добавляемый метод линейный, без переходов; ему нужны один локальный слот и один элемент стека.
     * Остальные методы класса сохраняются. Повторное применение не добавляет дубликатов.</p>
     *
     * @param bytes ненулевой байткод GregTech5RecipeProcessor, выбранного вызывающей стороной
     * @return байткод с добавленным мостом либо исходная ссылка при наличии прежней сигнатуры
     */
    static byte[] restoreLegacyApi(byte[] bytes) {
        ClassNode node = new ClassNode();
        new ClassReader(bytes).accept(node, 0);
        for (MethodNode method : node.methods) {
            if (method.name.equals(FLUID_METHOD) && method.desc.equals(FLUID_DESCRIPTOR)) return bytes;
        }
        MethodNode method = new MethodNode(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
            FLUID_METHOD, FLUID_DESCRIPTOR, null, null);
        method.visitCode();
        method.visitVarInsn(Opcodes.ALOAD, 0);
        method.visitMethodInsn(Opcodes.INVOKESTATIC, "com/github/vfyjxf/nee/utils/ItemUtils",
            FLUID_METHOD, FLUID_DESCRIPTOR, false);
        method.visitInsn(Opcodes.ARETURN);
        method.visitMaxs(1, 1);
        method.visitEnd();
        node.methods.add(method);
        ClassWriter writer = new ClassWriter(0);
        node.accept(writer);
        return writer.toByteArray();
    }
}
