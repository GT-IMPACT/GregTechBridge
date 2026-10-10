package space.impact.gregtechbridge.asm;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.analysis.Analyzer;
import org.objectweb.asm.tree.analysis.BasicVerifier;

public class NeeImpactTransformerTest {
    private byte[] read(InputStream input) throws Exception {
        try (InputStream stream = input) {
            assertNotNull(stream);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[8192];
            int count;
            while ((count = stream.read(buffer)) != -1) output.write(buffer, 0, count);
            return output.toByteArray();
        }
    }

    @Test
    public void compiledImpactCoreCallLinksToRestoredNeeApi() throws Exception {
        String processor = "com/github/vfyjxf/nee/processor/GregTech5RecipeProcessor";
        byte[] upstream = read(getClass().getClassLoader().getResourceAsStream(processor + ".class"));
        byte[] patched = NeeImpactTransformer.restoreLegacyApi(upstream);
        ClassNode nee = new ClassNode();
        new ClassReader(patched).accept(nee, 0);
        MethodNode bridge = nee.methods.stream()
            .filter(m -> m.name.equals(NeeImpactTransformer.FLUID_METHOD)
                && m.desc.equals(NeeImpactTransformer.FLUID_DESCRIPTOR)).findFirst().get();
        assertEquals(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
            bridge.access & (Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC));
        new Analyzer<>(new BasicVerifier()).analyze(nee.name, bridge);
        assertArrayEquals(patched, NeeImpactTransformer.restoreLegacyApi(patched));

        ClassNode itemUtils = new ClassNode();
        new ClassReader(read(getClass().getClassLoader().getResourceAsStream(
            "com/github/vfyjxf/nee/utils/ItemUtils.class"))).accept(itemUtils, 0);
        assertTrue(itemUtils.methods.stream().anyMatch(m -> m.name.equals(bridge.name) && m.desc.equals(bridge.desc)
            && (m.access & Opcodes.ACC_STATIC) != 0));

        // Inspect the shipped Impact-Core and its Kotlin lambdas, rather than a synthetic caller.
        String impact = "com/impact/addon/nei/impactplugin/RecipeProcessorBase";
        URL resource = getClass().getClassLoader().getResource(impact + ".class");
        assertNotNull("Impact-Core binary must be available", resource);
        boolean foundLegacyCall = false;
        try (JarFile jar = ((JarURLConnection) resource.openConnection()).getJarFile()) {
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (!entry.getName().startsWith(impact) || !entry.getName().endsWith(".class")) continue;
                ClassNode caller = new ClassNode();
                new ClassReader(read(jar.getInputStream(entry))).accept(caller, 0);
                for (MethodNode method : caller.methods) {
                    for (AbstractInsnNode instruction : method.instructions.toArray()) {
                        if (!(instruction instanceof MethodInsnNode)) continue;
                        MethodInsnNode call = (MethodInsnNode) instruction;
                        if (call.owner.equals(processor) && call.name.equals(bridge.name)) {
                            assertEquals(bridge.desc, call.desc);
                            assertEquals(Opcodes.INVOKESTATIC, call.getOpcode());
                            foundLegacyCall = true;
                        }
                    }
                }
            }
        }
        assertTrue("Expected the old NEE fluid API call in compiled Impact-Core", foundLegacyCall);
    }
}
