package space.impact.gregtechbridge.compat

import com.caedis.duradisplay.utils.DurabilityLikeInfo
import gregtech.GT_Mod
import gregtech.api.items.GT_RadioactiveCell_Item
import net.minecraft.item.ItemStack
import java.util.function.Function

object DuraDisplayGregTechCompat {
    private var originalDurabilityBar: Boolean? = null
    private var originalChargeBar: Boolean? = null

    @JvmStatic
    fun changeDurabilityBar(enabled: Boolean) {
        val proxy = GT_Mod.gregtechproxy
        if (originalDurabilityBar == null) originalDurabilityBar = proxy.mRenderItemDurabilityBar
        proxy.mRenderItemDurabilityBar = enabled
    }

    @JvmStatic
    fun changeChargeBar(enabled: Boolean) {
        val proxy = GT_Mod.gregtechproxy
        if (originalChargeBar == null) originalChargeBar = proxy.mRenderItemChargeBar
        proxy.mRenderItemChargeBar = enabled
    }

    @JvmStatic
    fun restoreDurabilityBar() {
        originalDurabilityBar?.let { GT_Mod.gregtechproxy.mRenderItemDurabilityBar = it }
    }

    @JvmStatic
    fun restoreChargeBar() {
        originalChargeBar?.let { GT_Mod.gregtechproxy.mRenderItemChargeBar = it }
    }

    @JvmStatic
    fun itemClassName(className: String): String = when (className) {
        "gregtech.common.items.MetaGeneratedItem01" -> "gregtech.common.items.GT_MetaGenerated_Item_01"
        "gregtech.api.items.MetaBaseItem" -> "gregtech.api.items.GT_MetaBase_Item"
        "gregtech.api.items.ItemRadioactiveCell" -> "gregtech.api.items.GT_RadioactiveCell_Item"
        else -> className
    }

    @JvmStatic
    fun itemHandler(
        className: String,
        handler: Function<ItemStack, DurabilityLikeInfo?>
    ): Function<ItemStack, DurabilityLikeInfo?> = when (className) {
        // Accept both names because the class-name injection also runs at HEAD.
        "gregtech.api.items.ItemRadioactiveCell", "gregtech.api.items.GT_RadioactiveCell_Item" ->
            Function { stack ->
                val item = stack.item as GT_RadioactiveCell_Item
                val max = item.maxDamageEx.toDouble()
                DurabilityLikeInfo.of(max - item.getDamageOfStack(stack), max)
            }
        else -> handler
    }
}
