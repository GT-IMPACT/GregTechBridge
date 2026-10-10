package space.impact.gregtechbridge.mixins.late.nee;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import com.github.vfyjxf.nee.processor.GregTech5RecipeProcessor;

@Mixin(value = GregTech5RecipeProcessor.class, remap = false)
public abstract class GregTechRecipeProcessorMixin {

    /**
     * Подменяет имя класса GT-обработчика в статическом инициализаторе GregTech5RecipeProcessor.
     * До Class.forName меняет GTNEIDefaultHandler на GT_NEI_DefaultHandler Impact, иначе NEE
     * запоминает null и не распознаёт машинные рецепты через isInstance.
     * require=1 требует нахождения константы; прочие имена и алгоритм процессора не меняются.
     *
     * @param original найденная строковая константа GTNH; значение задано условием ModifyConstant
     * @return полное имя существующего обработчика Impact
     */
    @ModifyConstant(method = "<clinit>", constant = @Constant(stringValue = "gregtech.nei.GTNEIDefaultHandler"), require = 1)
    private static String gregtechbridge$impactRecipeHandler(String original) {
        return "gregtech.nei.GT_NEI_DefaultHandler";
    }
}
