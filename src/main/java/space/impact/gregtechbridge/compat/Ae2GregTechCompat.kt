package space.impact.gregtechbridge.compat

import appeng.api.implementations.tiles.IColorableTile
import appeng.api.util.AEColor
import appeng.block.networking.BlockCableBus
import gregtech.api.GregTech_API
import gregtech.api.interfaces.tileentity.IColoredTileEntity
import gregtech.api.interfaces.tileentity.IGregTechTileEntity
import gregtech.api.interfaces.tileentity.IEnergyConnected
import gregtech.api.util.GT_Utility
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.world.World
import net.minecraftforge.common.util.ForgeDirection

object Ae2GregTechCompat {
    /**
     * Передаёт EU из современного AE2 в byte-перегрузку IEnergyConnected старого Impact.
     * Получатель становится первым аргументом статического адаптера; порядковый номер ForgeDirection
     * переводится в byte (0–5 для сторон, 6 для UNKNOWN). Напряжение и ампераж передаются без изменения.
     * Проверку допустимости входа выполняет сама машина. Исключения получателя здесь не перехватываются.
     *
     * @param tile получатель энергии с интерфейсом Impact
     * @param side сторона получателя, уже вычисленная вызывающим P2P
     * @param voltage напряжение одной порции энергии в EU
     * @param amperage предложенное количество ампер
     * @return количество принятых ампер, возвращённое получателем
     */
    @JvmStatic
    fun injectEnergyUnits(tile: IEnergyConnected, side: ForgeDirection, voltage: Long, amperage: Long): Long =
        tile.injectEnergyUnits(side.ordinal.toByte(), voltage, amperage)

    /**
     * Согласует вызов звука перегрузки AE2 с int-перегрузкой GT_Utility Impact.
     * В патчируемом P2P координаты происходят из целочисленной позиции блока, но upstream расширяет
     * их до Double. Обратное преобразование восстанавливает исходные координаты.
     * Для произвольных дробных координат toInt отбрасывает дробную часть к нулю; эта функция
     * предназначена для данного вызова P2P, а не для общего позиционирования звуков.
     *
     * @param world мир, в котором GT отправляет звук игрокам
     * @param sound строковый идентификатор звука вместо SoundResource
     * @param strength громкость, передаваемая без изменения
     * @param pitch высота тона, передаваемая без изменения
     * @param x координата блока по X, расширенная upstream до Double
     * @param y координата блока по Y, расширенная upstream до Double
     * @param z координата блока по Z, расширенная upstream до Double
     * @return результат отправки звука из GT_Utility
     */
    @JvmStatic
    fun sendSoundToPlayers(world: World, sound: String, strength: Float, pitch: Float, x: Double, y: Double, z: Double): Boolean =
        GT_Utility.sendSoundToPlayers(world, sound, strength, pitch, x.toInt(), y.toInt(), z.toInt())

    /**
     * Возвращает состояние GT-машины для кеша AE2 Storage Bus вместо отсутствующего публичного canAccessData.
     * Повторяет условие защищённого метода Impact: машина жива, meta существует и ссылается
     * на тот же базовый tile по идентичности. При изменении готовности hash меняется и AE2 обновляет IO.
     * Ноль зарезервирован upstream для отсутствия hash и здесь не возвращается.
     *
     * @param tile базовая GT-машина; наличие IGregTechTileEntity проверяется upstream до вызова
     * @return 2 для готовой машины, 1 для мёртвой, отсутствующей или отсоединённой meta
     */
    @JvmStatic
    fun machineHash(tile: IGregTechTileEntity): Int {
        // Условие защищённого canAccessData Impact: машина жива, meta принадлежит этому базовому tile.
        val meta = tile.metaTileEntity
        return if (!tile.isDead && meta != null && meta.baseMetaTileEntity === tile) 2 else 1
    }

    /**
     * Получает строковое имя звука перегрузки из старого реестра GregTech.
     * Запись 209 соответствует используемому AE2 звуку перегрузки IC2; при отсутствии записи
     * возвращается стандартный идентификатор, чтобы не передавать null в отправку звука.
     * Чтение происходит при фактическом вызове адаптера, а не при обнаружении coremod.
     *
     * @return значение sSoundList[209] либо ic2:machines.MachineOverload
     */
    @JvmStatic
    fun overloadSound(): String = GregTech_API.sSoundList[209] ?: "ic2:machines.MachineOverload"

    /**
     * Снимает окраску через API, доступные в Impact, вместо GTNH ColoredBlockContainer.
     * Сначала заменяет окрашенные стекло, панель и обожжённую глину обычными блоками с metadata 0
     * и флагами обновления 3. Затем пытается перекрасить BlockCableBus в AEColor.Transparent.
     * Для остальных блоков проверяет tile: IColorableTile получает Transparent, а IColoredTileEntity
     * с установленным цветом получает -1. При наличии обоих интерфейсов приоритет у IColorableTile.
     * Неподдерживаемый блок и уже неокрашенный GT-tile дают false.
     *
     * @param player игрок, из мира которого берётся блок; передаётся проверкам перекраски AE2
     * @param x координата целевого блока по X
     * @param y координата целевого блока по Y
     * @param z координата целевого блока по Z
     * @param side сторона взаимодействия для API перекраски AE2
     * @return результат операции блока/AE2 либо true после сброса цвета GT-tile
     */
    @JvmStatic
    fun removeColor(player: EntityPlayer, x: Int, y: Int, z: Int, side: ForgeDirection): Boolean {
        val world = player.entityWorld
        val block = world.getBlock(x, y, z)
        val uncolored = when (block) {
            Blocks.stained_glass -> Blocks.glass
            Blocks.stained_glass_pane -> Blocks.glass_pane
            Blocks.stained_hardened_clay -> Blocks.hardened_clay
            else -> null
        }
        if (uncolored != null) return world.setBlock(x, y, z, uncolored, 0, 3)
        if (block is BlockCableBus) {
            return block.recolourBlock(world, x, y, z, side, AEColor.Transparent.ordinal, player)
        }
        return when (val tile = world.getTileEntity(x, y, z)) {
            is IColorableTile -> tile.recolourBlock(side, AEColor.Transparent, player)
            is IColoredTileEntity -> if (tile.colorization >= 0) {
                tile.setColorization((-1).toByte())
                true
            } else false
            else -> false
        }
    }
}
