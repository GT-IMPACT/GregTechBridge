package space.impact.gregtechbridge.mixins.late.duradisplay;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.caedis.duradisplay.utils.ModSelfDrawnBar;

import space.impact.gregtechbridge.compat.DuraDisplayGregTechCompat;

@Mixin(value = ModSelfDrawnBar.class, remap = false)
public abstract class ModSelfDrawnBarMixin {

    @Inject(method = "changeGTDurabilitybar(Z)V", at = @At("HEAD"), cancellable = true, require = 1)
    private static void gregtechbridge$changeDurabilityBar(boolean enabled, CallbackInfo ci) {
        DuraDisplayGregTechCompat.changeDurabilityBar(enabled);
        ci.cancel();
    }

    @Inject(method = "changeGTChargebar(Z)V", at = @At("HEAD"), cancellable = true, require = 1)
    private static void gregtechbridge$changeChargeBar(boolean enabled, CallbackInfo ci) {
        DuraDisplayGregTechCompat.changeChargeBar(enabled);
        ci.cancel();
    }

    @Inject(method = "restoreGTDurabilitybar()V", at = @At("HEAD"), cancellable = true, require = 1)
    private static void gregtechbridge$restoreDurabilityBar(CallbackInfo ci) {
        DuraDisplayGregTechCompat.restoreDurabilityBar();
        ci.cancel();
    }

    @Inject(method = "restoreGTChargebar()V", at = @At("HEAD"), cancellable = true, require = 1)
    private static void gregtechbridge$restoreChargeBar(CallbackInfo ci) {
        DuraDisplayGregTechCompat.restoreChargeBar();
        ci.cancel();
    }
}
