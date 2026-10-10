package space.impact.gregtechbridge.compat

import codechicken.nei.recipe.StackInfo
import gregtech.api.util.GT_Utility

object NeiGregTechCompat {
    /**
     * Объединяет исходное разрешение звука GT с текущим запретом NEI на звуки расчёта износа.
     * NEI подавляет звук, пока симулирует операции с инструментами; вне этого состояния
     * решение вызывающей стороны сохраняется. Явный false не превращается в true.
     *
     * @param playSound разрешение звука, переданное GregTech
     * @return true только при разрешении GT и отсутствии паузы звуков NEI
     */
    @JvmStatic
    fun shouldPlayToolSound(playSound: Boolean): Boolean =
        playSound && !StackInfo.isPausedItemDamageSound()

    /**
     * Отправляет клиентский звук поломки инструмента только вне расчётов NEI.
     * Проверка выполняется до doSoundAtClient благодаря короткому замыканию: при паузе
     * реальный звуковой вызов отсутствует, при обычной игре аргументы передаются без изменения.
     *
     * @param sound имя звука, включая возможный null из исходного GT-вызова
     * @param time временной параметр doSoundAtClient
     * @param volume громкость звука
     * @return false при паузе NEI, иначе результат GT_Utility.doSoundAtClient
     */
    @JvmStatic
    fun playBreakingSound(sound: String?, time: Int, volume: Float): Boolean =
        shouldPlayToolSound(true) && GT_Utility.doSoundAtClient(sound, time, volume)
}
