package space.impact.gregtechbridge.asm;

import static org.junit.Assert.*;

import java.io.*;
import java.net.JarURLConnection;
import java.util.*;
import java.util.jar.*;

import org.junit.Test;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

/** Checks symbolic API references without initializing Minecraft or GregTech. */
public class Ae2LinkageAuditTest {
    private final Map<String, ClassNode> classes = new HashMap<>();
    private final Set<String> missing = new TreeSet<>();
    private int checked;

    private byte[] read(InputStream stream) throws IOException {
        try (InputStream input = stream; ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[8192];
            int count;
            while ((count = input.read(buffer)) != -1) out.write(buffer, 0, count);
            return out.toByteArray();
        }
    }

    private ClassNode parse(byte[] bytes) {
        ClassNode node = new ClassNode();
        new ClassReader(bytes).accept(node, 0);
        return node;
    }

    private ClassNode resolve(String name) throws IOException {
        if (classes.containsKey(name)) return classes.get(name);
        InputStream input = getClass().getClassLoader().getResourceAsStream(name + ".class");
        ClassNode node = input == null ? null : parse(read(input));
        classes.put(name, node);
        return node;
    }

    private boolean member(String owner, String name, String desc, boolean field, Set<String> seen)
        throws IOException {
        if (!seen.add(owner)) return false;
        ClassNode node = resolve(owner);
        if (node == null) return false;
        if (field) {
            for (FieldNode value : node.fields) if (value.name.equals(name) && value.desc.equals(desc)) return true;
        } else {
            for (MethodNode value : node.methods) if (value.name.equals(name) && value.desc.equals(desc)) return true;
            if (name.equals("<init>")) return false;
        }
        if (node.superName != null && member(node.superName, name, desc, field, seen)) return true;
        for (String iface : node.interfaces) if (member(iface, name, desc, field, seen)) return true;
        return false;
    }

    private boolean boundary(String name, boolean reverse) {
        return reverse ? name.startsWith("appeng/") || name.startsWith("com/github/vfyjxf/nee/")
            || name.startsWith("com/glodblock/") : name.startsWith("gregtech/") || name.startsWith("appeng/");
    }

    private void interfaces(String name, Set<String> result, Set<String> seen) throws IOException {
        if (!seen.add(name)) return;
        ClassNode node = resolve(name);
        if (node == null) return;
        if ((node.access & Opcodes.ACC_INTERFACE) != 0) result.add(name);
        if (node.superName != null) interfaces(node.superName, result, seen);
        for (String iface : node.interfaces) interfaces(iface, result, seen);
    }

    private boolean implementation(String name, String method, String desc, Set<String> seen) throws IOException {
        if (!seen.add(name)) return false;
        ClassNode node = resolve(name);
        if (node == null) return false;
        for (MethodNode value : node.methods) {
            if (value.name.equals(method) && value.desc.equals(desc)) return (value.access & Opcodes.ACC_ABSTRACT) == 0;
        }
        if (node.superName != null && implementation(node.superName, method, desc, seen)) return true;
        for (String iface : node.interfaces) if (implementation(iface, method, desc, seen)) return true;
        return false;
    }

    private void callbacks(List<ClassNode> nodes) throws IOException {
        for (ClassNode node : nodes) {
            if ((node.access & (Opcodes.ACC_ABSTRACT | Opcodes.ACC_INTERFACE)) != 0) continue;
            Set<String> interfaces = new HashSet<>();
            interfaces(node.name, interfaces, new HashSet<>());
            for (String iface : interfaces) {
                if (!iface.startsWith("appeng/") && !iface.startsWith("com/github/vfyjxf/nee/")) continue;
                for (MethodNode method : resolve(iface).methods) {
                    if ((method.access & Opcodes.ACC_ABSTRACT) == 0) continue;
                    checked++;
                    if (!implementation(node.name, method.name, method.desc, new HashSet<>())) {
                        missing.add(node.name + " -> unimplemented " + iface + "." + method.name + method.desc);
                    }
                }
            }
        }
    }

    private void type(String desc, String caller, boolean reverse) throws IOException {
        Type value = Type.getType(desc);
        if (value.getSort() == Type.METHOD) {
            type(value.getReturnType().getDescriptor(), caller, reverse);
            for (Type arg : value.getArgumentTypes()) type(arg.getDescriptor(), caller, reverse);
        } else if (value.getSort() == Type.ARRAY) type(value.getElementType().getDescriptor(), caller, reverse);
        else if (value.getSort() == Type.OBJECT && boundary(value.getInternalName(), reverse)
            && !(caller.startsWith("appeng/") && value.getInternalName().startsWith("appeng/"))) {
            checked++;
            if (resolve(value.getInternalName()) == null) missing.add(caller + " -> class " + value.getInternalName());
        }
    }

    private void call(String caller, String owner, String name, String desc, boolean field, boolean reverse)
        throws IOException {
        if (!boundary(owner, reverse)) return;
        if (caller.startsWith("appeng/") && owner.startsWith("appeng/")) return;
        checked++;
        if (!member(owner, name, desc, field, new HashSet<>())) {
            missing.add(caller + " -> " + owner + "." + name + desc);
        }
        type(desc, caller, reverse);
    }

    private List<ClassNode> jar(String anchor) throws Exception {
        List<ClassNode> result = new ArrayList<>();
        try (JarFile jar = ((JarURLConnection) getClass().getClassLoader().getResource(anchor + ".class")
            .openConnection()).getJarFile()) {
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (!entry.getName().endsWith(".class")) continue;
                byte[] original = read(jar.getInputStream(entry));
                String name = entry.getName().replace('/', '.').replace(".class", "");
                // Apply the same narrowly selected transformer classes as production.
                if (Arrays.asList("appeng.block.storage.BlockDrive", "appeng.block.storage.BlockChest",
                    "appeng.items.misc.ItemEncodedPattern", "appeng.parts.p2p.PartP2PGT5Power",
                    "appeng.items.tools.ToolNetworkVisualiser").contains(name)) {
                    original = Ae2ImpactTransformer.transformImpactClass(name, original);
                }
                ClassNode node = parse(original);
                if (node.name.equals("appeng/integration/modules/GT")) {
                    ClassNode mixin = resolve("space/impact/gregtechbridge/mixins/late/ae2/GregTechIntegrationMixin");
                    for (MethodNode replacement : mixin.methods) {
                        if (!replacement.name.equals("getGTMachineHash") && !replacement.name.equals("removeColor")) continue;
                        assertTrue(node.methods.removeIf(m -> m.name.equals(replacement.name) && m.desc.equals(replacement.desc)));
                        node.methods.add(replacement);
                    }
                }
                classes.put(node.name, node);
                result.add(node);
            }
        }
        return result;
    }

    private void scan(List<ClassNode> nodes, boolean reverse) throws Exception {
        for (ClassNode node : nodes) {
            // Development-only GTNH test fixtures are not mod integration paths.
            if (node.name.startsWith("appeng/gametests/")) continue;
            if (node.superName != null) type("L" + node.superName + ";", node.name, reverse);
            for (String iface : node.interfaces) type("L" + iface + ";", node.name, reverse);
            for (FieldNode field : node.fields) type(field.desc, node.name, reverse);
            for (MethodNode method : node.methods) {
                // These two lambdas are only invoked from the isNH=true RecipeCategory branch.
                if (node.name.equals("com/github/vfyjxf/nee/processor/GregTech5RecipeProcessor")
                    && method.name.startsWith("lambda$getAllOverlayIdentifier$")
                    && method.desc.contains("Lgregtech/api/recipe/RecipeCategory;")) continue;
                String caller = node.name + "." + method.name;
                type(method.desc, caller, reverse);
                for (AbstractInsnNode instruction : method.instructions.toArray()) {
                    if (instruction instanceof MethodInsnNode) {
                        MethodInsnNode call = (MethodInsnNode) instruction;
                        // RecipeCategory is used only in the explicitly selected GTNH branch (isNH=true).
                        if (node.name.startsWith("com/github/vfyjxf/nee/processor/GregTech5RecipeProcessor")
                            && call.owner.startsWith("gregtech/api/recipe/")) continue;
                        call(caller, call.owner, call.name, call.desc, false, reverse);
                    } else if (instruction instanceof FieldInsnNode) {
                        FieldInsnNode field = (FieldInsnNode) instruction;
                        if (node.name.startsWith("com/github/vfyjxf/nee/processor/GregTech5RecipeProcessor")
                            && field.owner.startsWith("gregtech/api/recipe/")) continue;
                        call(caller, field.owner, field.name, field.desc, true, reverse);
                    } else if (instruction instanceof TypeInsnNode) {
                        String value = ((TypeInsnNode) instruction).desc;
                        type(value.startsWith("[") ? value : "L" + value + ";", caller, reverse);
                    } else if (instruction instanceof LdcInsnNode) {
                        Object value = ((LdcInsnNode) instruction).cst;
                        if (value instanceof Type) type(((Type) value).getDescriptor(), caller, reverse);
                    } else if (instruction instanceof InvokeDynamicInsnNode) {
                        for (Object value : ((InvokeDynamicInsnNode) instruction).bsmArgs) {
                            if (value instanceof Handle) {
                                Handle handle = (Handle) value;
                                call(caller, handle.getOwner(), handle.getName(), handle.getDesc(),
                                    handle.getTag() <= Opcodes.H_PUTSTATIC, reverse);
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    public void allPublishedIntegrationSymbolsLinkInBothDirections() throws Exception {
        List<ClassNode> ae2 = jar("appeng/core/AppEng");
        List<ClassNode> nee = jar("com/github/vfyjxf/nee/NotEnoughEnergistics");
        List<ClassNode> fluid = jar("com/glodblock/github/FluidCraft");
        List<ClassNode> wireless = jar("net/p455w0rd/wirelesscraftingterminal/common/WirelessCraftingTerminal");
        List<ClassNode> gregtech = jar("gregtech/api/GregTech_API");
        scan(ae2, false);
        scan(nee, false);
        scan(fluid, false);
        scan(wireless, false);
        scan(gregtech, true);
        scan(Collections.singletonList(resolve("space/impact/gregtechbridge/compat/Ae2GregTechCompat")), false);
        callbacks(gregtech);
        callbacks(nee);
        callbacks(fluid);
        callbacks(wireless);
        System.out.println("AE2 integration linkage references checked: " + checked);
        assertTrue(String.join("\n", missing), missing.isEmpty());
        assertTrue("Audit must actually cover the integration", checked > 100);
    }

    private void reflectionReplacement(String target, String original, String mixin, String replacement)
        throws IOException {
        int constants = 0;
        for (MethodNode method : resolve(target).methods) {
            if (!method.name.equals("<clinit>")) continue;
            for (AbstractInsnNode instruction : method.instructions.toArray()) {
                if (instruction instanceof LdcInsnNode && original.equals(((LdcInsnNode) instruction).cst)) constants++;
            }
        }
        assertEquals("Mixin must match exactly one upstream constant", 1, constants);
        boolean found = false;
        for (MethodNode method : resolve(mixin).methods) {
            for (AbstractInsnNode instruction : method.instructions.toArray()) {
                if (instruction instanceof LdcInsnNode && replacement.equals(((LdcInsnNode) instruction).cst)) found = true;
            }
        }
        assertTrue("Compiled mixin must return the tested replacement", found);
        assertNotNull(resolve(replacement.replace('.', '/')));
    }

    @Test
    public void reflectionContractsUseTheActualImpactClassesAndFields() throws Exception {
        assertNull("NEE/FC must select the old GT5 branch", resolve("gregtech/api/recipe/RecipeMap"));
        reflectionReplacement("com/github/vfyjxf/nee/processor/GregTech5RecipeProcessor",
            "gregtech.nei.GTNEIDefaultHandler",
            "space/impact/gregtechbridge/mixins/late/nee/GregTechRecipeProcessorMixin",
            "gregtech.nei.GT_NEI_DefaultHandler");
        reflectionReplacement("com/github/vfyjxf/nee/utils/ItemUtils", "gregtech.api.items.MetaGeneratedTool",
            "space/impact/gregtechbridge/mixins/late/nee/ItemUtilsMixin", "gregtech.api.items.GT_MetaGenerated_Tool");
        ClassNode maps = resolve("gregtech/api/util/GT_Recipe$GT_Recipe_Map");
        for (String name : Arrays.asList("sMappings", "mNEIAllowed", "mNEIName")) {
            FieldNode field = maps.fields.stream().filter(f -> f.name.equals(name)).findFirst().get();
            assertTrue(name + " must be public for getDeclaredField().get()", (field.access & Opcodes.ACC_PUBLIC) != 0);
            if (name.equals("sMappings")) assertTrue((field.access & Opcodes.ACC_STATIC) != 0);
            if (name.equals("mNEIAllowed")) assertEquals("Z", field.desc);
            if (name.equals("mNEIName")) assertEquals("Ljava/lang/String;", field.desc);
        }
        // GregTech's own legacy EU P2P reflects this field by its declared name.
        assertTrue(resolve("appeng/parts/AEBasePart").fields.stream().anyMatch(f -> f.name.equals("side")
            && f.desc.equals("Lnet/minecraftforge/common/util/ForgeDirection;")));
        assertNotNull(resolve("gregtech/nei/GT_NEI_AssLineHandler"));
    }
}
