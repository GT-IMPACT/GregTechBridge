package space.impact.gregtechbridge.asm;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.analysis.Analyzer;
import org.objectweb.asm.tree.analysis.BasicVerifier;

public class Ae2ImpactTransformerTest {
    private static final String[] TARGETS = {
        "appeng.block.storage.BlockDrive", "appeng.block.storage.BlockChest",
        "appeng.items.misc.ItemEncodedPattern", "appeng.parts.p2p.PartP2PGT5Power",
        "appeng.items.tools.ToolNetworkVisualiser"
    };

    private byte[] upstream(String name) throws Exception {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(name.replace('.', '/') + ".class")) {
            assertNotNull("Missing pinned AE2 bytecode: " + name, input);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            byte[] buffer = new byte[8192];
            int length;
            while ((length = input.read(buffer)) != -1) bytes.write(buffer, 0, length);
            return bytes.toByteArray();
        }
    }

    @Test
    public void pinnedAe2ClassesKeepValidControlFlowAndStackTypes() throws Exception {
        for (String name : TARGETS) {
            byte[] original = upstream(name);
            byte[] patched = Ae2ImpactTransformer.transformImpactClass(name, original);
            ClassNode node = new ClassNode();
            new ClassReader(patched).accept(node, 0);
            assertEquals(name.replace('.', '/'), node.name);
            for (MethodNode method : node.methods) {
                if (method.instructions.size() != 0) {
                    new Analyzer<>(new BasicVerifier()).analyze(node.name, method);
                }
                for (AbstractInsnNode instruction : method.instructions.toArray()) {
                    String reference = "";
                    if (instruction instanceof TypeInsnNode) reference = ((TypeInsnNode) instruction).desc;
                    if (instruction instanceof MethodInsnNode) {
                        MethodInsnNode call = (MethodInsnNode) instruction;
                        reference = call.owner + call.desc;
                    }
                    if (instruction instanceof FieldInsnNode) reference = ((FieldInsnNode) instruction).owner;
                    assertFalse(reference, reference.contains("MTEHatchCraftingInput"));
                    assertFalse(reference, reference.contains("gregtech/api/GregTechAPI"));
                    assertFalse(reference, reference.contains("gregtech/api/util/GTUtility"));
                    assertFalse(reference, reference.contains("gregtech/api/enums/GTValues"));
                    assertFalse(reference, reference.contains("gregtech/api/enums/SoundResource"));
                    assertFalse(reference, reference.contains("gregtech/common/items/ItemIntegratedCircuit"));
                }
            }
            // A second transformer pass must be safe, including after the hatch branch was removed.
            assertArrayEquals(patched, Ae2ImpactTransformer.transformImpactClass(name, patched));
        }
    }

    @Test
    public void preservesGraphAndUsesImpactOverloadSound() throws Exception {
        ClassNode visualiser = new ClassNode();
        new ClassReader(Ae2ImpactTransformer.transformImpactClass(TARGETS[4], upstream(TARGETS[4])))
            .accept(visualiser, 0);
        assertTrue(hasCall(visualiser, "appeng/core/sync/network/NetworkHandler", "sendTo"));
        ClassNode p2p = new ClassNode();
        new ClassReader(Ae2ImpactTransformer.transformImpactClass(TARGETS[3], upstream(TARGETS[3]))).accept(p2p, 0);
        assertTrue(hasCall(p2p, "space/impact/gregtechbridge/compat/Ae2GregTechCompat", "overloadSound"));
        assertTrue(hasCall(p2p, "space/impact/gregtechbridge/compat/Ae2GregTechCompat", "sendSoundToPlayers"));
        assertTrue(hasCall(p2p, "space/impact/gregtechbridge/compat/Ae2GregTechCompat", "injectEnergyUnits"));
    }

    private boolean hasCall(ClassNode node, String owner, String name) {
        for (MethodNode method : node.methods) {
            for (AbstractInsnNode instruction : method.instructions.toArray()) {
                if (instruction instanceof MethodInsnNode) {
                    MethodInsnNode call = (MethodInsnNode) instruction;
                    if (call.owner.equals(owner) && call.name.equals(name)) return true;
                }
            }
        }
        return false;
    }

    @Test
    public void unrelatedClassesAndAbsentModsAreLeftAlone() throws Exception {
        Ae2ImpactTransformer transformer = new Ae2ImpactTransformer();
        byte[] unrelated = upstream("appeng.helpers.DualityInterface");
        assertSame(unrelated, transformer.transform("appeng.helpers.DualityInterface", "appeng.helpers.DualityInterface", unrelated));
        assertNull(transformer.transform(TARGETS[0], TARGETS[0], null));
    }
}
