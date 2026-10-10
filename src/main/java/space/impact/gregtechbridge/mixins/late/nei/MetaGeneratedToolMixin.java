package space.impact.gregtechbridge.mixins.late.nei;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

import gregtech.api.items.GT_MetaGenerated_Tool;

import space.impact.gregtechbridge.compat.NeiGregTechCompat;

@Mixin(value = GT_MetaGenerated_Tool.class, remap = false)
public abstract class MetaGeneratedToolMixin {

    @ModifyVariable(
        method = "getContainerItem(Lnet/minecraft/item/ItemStack;Z)Lnet/minecraft/item/ItemStack;",
        at = @At("HEAD"),
        argsOnly = true,
        ordinal = 0,
        require = 1)
    private boolean gregtechbridge$pauseNeiToolSounds(boolean playSound) {
        return NeiGregTechCompat.shouldPlayToolSound(playSound);
    }

    @Redirect(
        method = "doDamage(Lnet/minecraft/item/ItemStack;J)Z",
        at = @At(
            value = "INVOKE",
            target = "Lgregtech/api/util/GT_Utility;doSoundAtClient(Ljava/lang/String;IF)Z"),
        require = 2)
    private boolean gregtechbridge$pauseNeiBreakingSounds(String sound, int time, float volume) {
        return NeiGregTechCompat.playBreakingSound(sound, time, volume);
    }
}
