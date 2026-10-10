package space.impact.gregtechbridge.mixins.late.nei;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

import gregtech.api.items.GT_MetaGenerated_Tool;

import space.impact.gregtechbridge.compat.NeiGregTechCompat;

@Mixin(value = GT_MetaGenerated_Tool.class, remap = false)
public abstract class MetaGeneratedToolMixin {

    /**
     * Меняет boolean-аргумент getContainerItem(ItemStack,boolean) в HEAD перед расчётом износа.
     * Исходное разрешение GT совмещается с запретом звуков NEI: симуляция рецептов не проигрывает
     * рабочие звуки инструментов, обычная игра сохраняет исходное поведение.
     * argsOnly=true выбирает аргумент, ordinal=0 — первый boolean; require=1 требует совпадения.
     *
     * @param playSound исходное разрешение звука для получения container item
     * @return разрешение с учётом текущей паузы NEI
     */
    @ModifyVariable(
        method = "getContainerItem(Lnet/minecraft/item/ItemStack;Z)Lnet/minecraft/item/ItemStack;",
        at = @At("HEAD"),
        argsOnly = true,
        ordinal = 0,
        require = 1)
    private boolean gregtechbridge$pauseNeiToolSounds(boolean playSound) {
        return NeiGregTechCompat.shouldPlayToolSound(playSound);
    }

    /**
     * Перенаправляет два вызова GT_Utility.doSoundAtClient внутри doDamage(ItemStack,long).
     * При расчётах NEI адаптер возвращает false без проигрывания звука; вне расчётов вызывает
     * исходную функцию с теми же аргументами. require=2 требует минимум два совпадения,
     * чтобы обе точки звука поломки получили патч.
     *
     * @param sound строковое имя звука из исходного вызова
     * @param time временной параметр звуковой функции GT
     * @param volume громкость звука
     * @return результат звуковой функции либо false, если NEI приостановил звуки
     */
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
