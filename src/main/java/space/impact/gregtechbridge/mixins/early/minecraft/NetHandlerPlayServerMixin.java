package space.impact.gregtechbridge.mixins.early.minecraft;

import net.minecraft.inventory.Slot;
import net.minecraft.network.NetHandlerPlayServer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.llamalad7.mixinextras.sugar.Local;

@Mixin(NetHandlerPlayServer.class)
public abstract class NetHandlerPlayServerMixin {

    // Backhand 1.8.16: using an item can open a container without the held-item slot.
    @Inject(
        method = "processPlayerBlockPlacement",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/item/ItemStack;areItemStacksEqual(Lnet/minecraft/item/ItemStack;"
                + "Lnet/minecraft/item/ItemStack;)Z"
        ),
        cancellable = true
    )
    private void skipMissingHeldItemSlotSync(CallbackInfo ci, @Local(name = "slot") Slot slot) {
        if (slot == null) {
            ci.cancel();
        }
    }
}
