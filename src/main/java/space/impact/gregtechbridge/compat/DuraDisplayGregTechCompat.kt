package space.impact.gregtechbridge.compat

import com.caedis.duradisplay.utils.DurabilityLikeInfo
import gregtech.GT_Mod
import gregtech.api.items.GT_RadioactiveCell_Item
import net.minecraft.item.ItemStack
import java.util.function.Function

object DuraDisplayGregTechCompat {
    private var originalDurabilityBar: Boolean? = null
    private var originalChargeBar: Boolean? = null

    /**
     * Меняет отрисовку штатной полоски прочности GT через gregtechproxy Impact.
     * При первом вызове сохраняет прежнее mRenderItemDurabilityBar; последующие изменения
     * не перезаписывают снимок. Настройка глобальная для клиента и не относится к одному предмету.
     *
     * @param enabled новое состояние отрисовки, запрошенное DuraDisplay
     */
    @JvmStatic
    fun changeDurabilityBar(enabled: Boolean) {
        val proxy = GT_Mod.gregtechproxy
        if (originalDurabilityBar == null) originalDurabilityBar = proxy.mRenderItemDurabilityBar
        proxy.mRenderItemDurabilityBar = enabled
    }

    /**
     * Меняет отрисовку штатной полоски заряда GT через gregtechproxy Impact.
     * Первое значение mRenderItemChargeBar сохраняется для восстановления и затем не обновляется.
     * Снимок заряда независим от снимка прочности; вызов меняет глобальную настройку клиента.
     *
     * @param enabled новое состояние отрисовки полоски заряда
     */
    @JvmStatic
    fun changeChargeBar(enabled: Boolean) {
        val proxy = GT_Mod.gregtechproxy
        if (originalChargeBar == null) originalChargeBar = proxy.mRenderItemChargeBar
        proxy.mRenderItemChargeBar = enabled
    }

    /**
     * Восстанавливает значение полоски прочности, сохранённое первым changeDurabilityBar.
     * Если изменение ещё не вызывалось, ничего не делает. Снимок не очищается:
     * повторные восстановления используют то же исходное значение, а не промежуточное состояние.
     */
    @JvmStatic
    fun restoreDurabilityBar() {
        originalDurabilityBar?.let { GT_Mod.gregtechproxy.mRenderItemDurabilityBar = it }
    }

    /**
     * Восстанавливает значение полоски заряда, сохранённое первым changeChargeBar.
     * До первого изменения операция пустая. Снимок сохраняется после восстановления,
     * поэтому дальнейшие циклы DuraDisplay возвращают первоначальную настройку клиента.
     */
    @JvmStatic
    fun restoreChargeBar() {
        originalChargeBar?.let { GT_Mod.gregtechproxy.mRenderItemChargeBar = it }
    }

    /**
     * Переводит три имени предметных классов нового GTNH в имена старого API Impact.
     * Используется перед поиском класса при регистрации DuraDisplay: metaitem01, базовый metaitem
     * и радиоактивная ячейка. Посторонние и уже исправленные имена возвращаются без изменения.
     *
     * @param className полное имя Java, которое DuraDisplay передал в addHandler
     * @return имя соответствующего класса Impact либо исходное имя
     */
    @JvmStatic
    fun itemClassName(className: String): String = when (className) {
        "gregtech.common.items.MetaGeneratedItem01" -> "gregtech.common.items.GT_MetaGenerated_Item_01"
        "gregtech.api.items.MetaBaseItem" -> "gregtech.api.items.GT_MetaBase_Item"
        "gregtech.api.items.ItemRadioactiveCell" -> "gregtech.api.items.GT_RadioactiveCell_Item"
        else -> className
    }

    /**
     * Заменяет callback радиоактивных ячеек, поскольку смены имени класса недостаточно:
     * исходный callback приводил Item к отсутствующему типу GTNH.
     * Новый callback приводит предмет к GT_RadioactiveCell_Item и получает остаток как
     * maxDamageEx минус getDamageOfStack. Предел и остаток передаются в DurabilityLikeInfo без нормализации.
     *
     * Принимаются оба имени ячейки, так как подмена имени и callback выполняются в HEAD одного addHandler.
     * Регистрация по классу должна обеспечить правильный тип предмета; неверный тип даст ClassCastException.
     *
     * @param className исходное или уже заменённое имя класса регистрируемого предмета
     * @param handler callback DuraDisplay, сохраняемый для всех остальных классов
     * @return новый callback ячейки или исходная ссылка handler для неподдерживаемого имени
     */
    @JvmStatic
    fun itemHandler(
        className: String,
        handler: Function<ItemStack, DurabilityLikeInfo?>
    ): Function<ItemStack, DurabilityLikeInfo?> = when (className) {
        // Принимаем оба имени: подмена имени класса тоже выполняется в HEAD.
        "gregtech.api.items.ItemRadioactiveCell", "gregtech.api.items.GT_RadioactiveCell_Item" ->
            Function { stack ->
                val item = stack.item as GT_RadioactiveCell_Item
                val max = item.maxDamageEx.toDouble()
                DurabilityLikeInfo.of(max - item.getDamageOfStack(stack), max)
            }
        else -> handler
    }
}
