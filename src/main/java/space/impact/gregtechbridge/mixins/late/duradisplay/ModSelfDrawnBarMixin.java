package space.impact.gregtechbridge.mixins.late.duradisplay;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.caedis.duradisplay.utils.ModSelfDrawnBar;

import space.impact.gregtechbridge.compat.DuraDisplayGregTechCompat;

@Mixin(value = ModSelfDrawnBar.class, remap = false)
public abstract class ModSelfDrawnBarMixin {

    /**
     * Перехватывает changeGTDurabilitybar(Z)V в HEAD и изменяет настройку через proxy Impact.
     * Сохраняет первоначальное состояние в адаптере и отменяет исходный метод, который использует API GTNH.
     * require=1 требует наличия точки инъекции и обнаруживает изменение целевой сигнатуры при загрузке.
     *
     * @param enabled состояние полоски прочности, запрошенное DuraDisplay
     * @param ci управление исходным вызовом; после адаптации он отменяется
     */
    @Inject(method = "changeGTDurabilitybar(Z)V", at = @At("HEAD"), cancellable = true, require = 1)
    private static void gregtechbridge$changeDurabilityBar(boolean enabled, CallbackInfo ci) {
        DuraDisplayGregTechCompat.changeDurabilityBar(enabled);
        ci.cancel();
    }

    /**
     * Перехватывает changeGTChargebar(Z)V в HEAD и меняет полоску заряда через proxy Impact.
     * Адаптер сохраняет исходное значение отдельно от прочности; cancel исключает последующий вызов API GTNH.
     * require=1 не позволяет незаметно пропустить патч при изменении целевого метода.
     *
     * @param enabled желаемое состояние штатной полоски заряда
     * @param ci управление исходным вызовом, отменяемым после изменения настройки
     */
    @Inject(method = "changeGTChargebar(Z)V", at = @At("HEAD"), cancellable = true, require = 1)
    private static void gregtechbridge$changeChargeBar(boolean enabled, CallbackInfo ci) {
        DuraDisplayGregTechCompat.changeChargeBar(enabled);
        ci.cancel();
    }

    /**
     * Перехватывает restoreGTDurabilitybar()V в HEAD и восстанавливает снимок настройки Impact.
     * При отсутствии снимка адаптер ничего не меняет, но исходный несовместимый метод всё равно отменяется.
     * require=1 требует совпадения точки инъекции.
     *
     * @param ci управление вызовом DuraDisplay, отменяемым после восстановления
     */
    @Inject(method = "restoreGTDurabilitybar()V", at = @At("HEAD"), cancellable = true, require = 1)
    private static void gregtechbridge$restoreDurabilityBar(CallbackInfo ci) {
        DuraDisplayGregTechCompat.restoreDurabilityBar();
        ci.cancel();
    }

    /**
     * Перехватывает restoreGTChargebar()V в HEAD и возвращает сохранённую настройку заряда Impact.
     * Исходная реализация DuraDisplay отменяется даже до первого изменения, когда снимок ещё отсутствует.
     * require=1 требует совпадения целевого метода.
     *
     * @param ci управление исходным вызовом, который не должен обращаться к новому API GTNH
     */
    @Inject(method = "restoreGTChargebar()V", at = @At("HEAD"), cancellable = true, require = 1)
    private static void gregtechbridge$restoreChargeBar(CallbackInfo ci) {
        DuraDisplayGregTechCompat.restoreChargeBar();
        ci.cancel();
    }
}
