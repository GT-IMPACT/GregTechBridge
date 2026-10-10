package space.impact.gregtechbridge.mixins.late.ae2;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import space.impact.gregtechbridge.compat.Ae2GregTechCompat;
import appeng.integration.modules.GT;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;

@Mixin(value = GT.class, remap = false)
public abstract class GregTechIntegrationMixin {

    /**
     * Заменяет вычисление состояния GT-машины в appeng.integration.modules.GT.
     * Upstream вызывает отсутствующий в интерфейсе Impact canAccessData; адаптер проверяет
     * готовность через существующие методы и сохраняет значения 1/2 для инвалидирования кеша Storage Bus.
     * Вызывающий код AE2 сначала проверяет isGTMachine, поэтому ожидается IGregTechTileEntity.
     *
     * @param tile базовая GT-машина, для которой AE2 пересоздаёт обработчик хранения
     * @return 2 для готовой машины, 1 для недоступной
     * @throws ClassCastException если upstream нарушил контракт и передал не GT-машину
     * @author GregTechBridge
     * @reason В интерфейсе Impact нет публичного canAccessData; проверка собирается из доступных методов.
     */
    @Overwrite
    public int getGTMachineHash(TileEntity tile) {
        return Ae2GregTechCompat.machineHash((IGregTechTileEntity) tile);
    }

    /**
     * Заменяет снятие цвета в GT-интеграции AE2 и передаёт операцию адаптеру Impact.
     * Адаптер обрабатывает обычные окрашенные блоки, кабели AE2 и поддерживаемые tile-интерфейсы.
     * Условия выбора и изменения мира описаны в Ae2GregTechCompat.removeColor.
     *
     * @param player игрок, выполняющий снятие цвета
     * @param x координата блока по X
     * @param y координата блока по Y
     * @param z координата блока по Z
     * @param side сторона взаимодействия
     * @return true при успешном изменении, false для неподдерживаемого либо неокрашенного GT-блока
     * @author GregTechBridge
     * @reason В Impact отсутствует GTNH ColoredBlockContainer, на который ссылается исходная реализация.
     */
    @Overwrite
    public boolean removeColor(EntityPlayer player, int x, int y, int z, ForgeDirection side) {
        return Ae2GregTechCompat.removeColor(player, x, y, z, side);
    }
}
