package space.impact.gregtechbridge.mixins.late.duradisplay;

import java.util.function.Function;

import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import com.caedis.duradisplay.overlay.OverlayDurabilityLike;
import com.caedis.duradisplay.utils.DurabilityLikeInfo;

import space.impact.gregtechbridge.compat.DuraDisplayGregTechCompat;

@Mixin(value = OverlayDurabilityLike.class, remap = false)
public abstract class OverlayDurabilityLikeMixin {

    @ModifyVariable(
        method = "addHandler(Ljava/lang/String;Ljava/util/function/Function;)V",
        at = @At("HEAD"),
        argsOnly = true,
        ordinal = 0,
        require = 1)
    private String gregtechbridge$replaceItemClass(String className) {
        return DuraDisplayGregTechCompat.itemClassName(className);
    }

    @ModifyVariable(
        method = "addHandler(Ljava/lang/String;Ljava/util/function/Function;)V",
        at = @At("HEAD"),
        argsOnly = true,
        ordinal = 0,
        require = 1)
    private Function<ItemStack, DurabilityLikeInfo> gregtechbridge$replaceItemHandler(
        Function<ItemStack, DurabilityLikeInfo> handler,
        String className,
        Function<ItemStack, DurabilityLikeInfo> originalHandler) {
        return DuraDisplayGregTechCompat.itemHandler(className, handler);
    }
}
