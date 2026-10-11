package space.impact.gregtechbridge.mixinplugin;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.TransformerExclusions("space.impact.gregtechbridge.asm")
public class VWEarlyMixins implements IFMLLoadingPlugin, IEarlyMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.gregtechbridge.early.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedCoreMods) {
        return Arrays.stream(Mixins.values())
                .filter(mixin -> mixin.getPhase() == Phase.EARLY)
                .map(Mixins::getMixinClasses)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[] {
            "space.impact.gregtechbridge.asm.Ae2ImpactTransformer"
        };
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
