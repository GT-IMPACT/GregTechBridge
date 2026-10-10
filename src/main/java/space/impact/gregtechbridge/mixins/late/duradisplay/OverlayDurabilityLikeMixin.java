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

    /**
     * Меняет строковый аргумент addHandler(String,Function) в HEAD до загрузки класса предмета.
     * argsOnly=true ограничивает изменение аргументами метода, ordinal=0 выбирает первый аргумент
     * типа String. Адаптер переводит известные имена GTNH в классы Impact, остальные сохраняет.
     * require=1 делает отсутствие совпадения ошибкой применения миксина.
     *
     * @param className имя предметного класса, переданное при регистрации overlay
     * @return имя Impact или неизменённая строка для другого мода
     */
    @ModifyVariable(
        method = "addHandler(Ljava/lang/String;Ljava/util/function/Function;)V",
        at = @At("HEAD"),
        argsOnly = true,
        ordinal = 0,
        require = 1)
    private String gregtechbridge$replaceItemClass(String className) {
        return DuraDisplayGregTechCompat.itemClassName(className);
    }

    /**
     * Меняет первый Function-аргумент addHandler(String,Function) в HEAD до регистрации callback.
     * Для радиоактивной ячейки подставляется реализация с типом Impact и его методами износа.
     * className может быть исходным либо уже заменённым другой инъекцией: адаптер принимает оба.
     * argsOnly=true и ordinal=0 выбирают аргумент нужного типа; require=1 требует точки применения.
     *
     * @param handler текущее значение Function-аргумента, которое изменяет ModifyVariable
     * @param className захваченный строковый аргумент исходного addHandler
     * @param originalHandler захваченный Function-аргумент addHandler; отдельно не используется
     * @return совместимый callback ячейки либо исходный handler
     */
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
