package space.impact.gregtechbridge.compat

import codechicken.nei.recipe.StackInfo
import gregtech.api.util.GT_Utility

object NeiGregTechCompat {
    @JvmStatic
    fun shouldPlayToolSound(playSound: Boolean): Boolean =
        playSound && !StackInfo.isPausedItemDamageSound()

    @JvmStatic
    fun playBreakingSound(sound: String?, time: Int, volume: Float): Boolean =
        shouldPlayToolSound(true) && GT_Utility.doSoundAtClient(sound, time, volume)
}
