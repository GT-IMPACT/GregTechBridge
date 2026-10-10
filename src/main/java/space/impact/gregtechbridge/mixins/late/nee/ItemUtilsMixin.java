package space.impact.gregtechbridge.mixins.late.nee;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import com.github.vfyjxf.nee.utils.ItemUtils;

@Mixin(value = ItemUtils.class, remap = false)
public abstract class ItemUtilsMixin {

    /**
     * Меняет строку MetaGeneratedTool в статическом инициализаторе ItemUtils на тип Impact.
     * Подмена происходит до Class.forName, чтобы последующая проверка класса инструмента работала
     * с GT_MetaGenerated_Tool. Остальная обработка предметов и жидкостей NEE сохраняется.
     * require=1 не допускает молчаливого пропуска патча при изменении константы upstream.
     *
     * @param original строка, совпавшая с константой в ModifyConstant
     * @return полное имя класса инструментов старого GregTech
     */
    @ModifyConstant(method = "<clinit>", constant = @Constant(stringValue = "gregtech.api.items.MetaGeneratedTool"), require = 1)
    private static String gregtechbridge$impactTool(String original) {
        return "gregtech.api.items.GT_MetaGenerated_Tool";
    }
}
