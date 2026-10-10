package space.impact.gregtechbridge.mixinplugin

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader
import com.gtnewhorizon.gtnhmixins.LateMixin

@LateMixin
class VWLateMixins : ILateMixinLoader {

    override fun getMixinConfig(): String {
        return "mixins.gregtechbridge.late.json"
    }

    override fun getMixins(loadedMods: MutableSet<String>): MutableList<String> {
        return Mixins.entries
            .filter { it.phase == Phase.LATE }
            .map { it.mixinClasses }
            .flatten()
            .toMutableList()
    }
}
