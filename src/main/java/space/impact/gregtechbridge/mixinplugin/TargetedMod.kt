package space.impact.gregtechbridge.mixinplugin

enum class TargetedMod(
    val modName: String,
    val coreModClass: String?,
    val modId: String? = null
) {
    VANILLA("Minecraft", null),
    DURADISPLAY("DuraDisplay", null, "duradisplay"),
    GREGTECH("GregTech", null, "gregtech"),
    NOT_ENOUGH_ITEMS("NotEnoughItems", null, "NotEnoughItems"),
    APPLIED_ENERGISTICS("Applied Energistics 2", null, "appliedenergistics2"),
    NOT_ENOUGH_ENERGISTICS("NotEnoughEnergistics", null, "neenergistics"),
}
