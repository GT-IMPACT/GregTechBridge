package space.impact.gregtechbridge.mixinplugin

enum class TargetedMod(
    val modName: String,
    val coreModClass: String?,
    val modId: String? = null
) {
    VANILLA("Minecraft", null),
    DURADISPLAY("DuraDisplay", null, "duradisplay"),
    GREGTECH("GregTech", null, "gregtech"),
}
