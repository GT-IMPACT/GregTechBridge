package space.impact.gregtechbridge.compat;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Proxy;

import org.junit.Test;
import net.minecraftforge.common.util.ForgeDirection;
import gregtech.api.interfaces.tileentity.IEnergyConnected;

import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;

public class Ae2GregTechCompatTest {
    @Test
    public void euInjectionPreservesDirectionVoltageAmperageAndReturnValue() {
        for (ForgeDirection side : ForgeDirection.values()) {
            IEnergyConnected tile = (IEnergyConnected) Proxy.newProxyInstance(
                getClass().getClassLoader(), new Class<?>[] {IEnergyConnected.class}, (proxy, method, args) -> {
                    assertEquals("injectEnergyUnits", method.getName());
                    assertEquals((byte) side.ordinal(), args[0]);
                    assertEquals(8192L, args[1]);
                    assertEquals(4L, args[2]);
                    return 3L;
                });
            assertEquals(3L, Ae2GregTechCompat.injectEnergyUnits(tile, side, 8192L, 4L));
        }
    }

    @Test
    public void machineHashTracksReadinessWithoutCallingMissingInterfaceMethod() {
        boolean[] dead = {false};
        IMetaTileEntity[] meta = {null};
        IGregTechTileEntity[] base = {null};
        IGregTechTileEntity tile = (IGregTechTileEntity) Proxy.newProxyInstance(
            getClass().getClassLoader(), new Class<?>[] {IGregTechTileEntity.class}, (proxy, method, args) -> {
                if (method.getName().equals("isDead")) return dead[0];
                if (method.getName().equals("getMetaTileEntity")) return meta[0];
                throw new AssertionError("Unexpected tile call: " + method);
            });
        IMetaTileEntity attached = (IMetaTileEntity) Proxy.newProxyInstance(
            getClass().getClassLoader(), new Class<?>[] {IMetaTileEntity.class}, (proxy, method, args) -> {
                if (method.getName().equals("getBaseMetaTileEntity")) return base[0];
                throw new AssertionError("Unexpected meta call: " + method);
            });

        // AE2 reserves zero for 'no hash'; both unavailable and available states must be nonzero.
        assertEquals(1, Ae2GregTechCompat.machineHash(tile));
        meta[0] = attached;
        assertEquals(1, Ae2GregTechCompat.machineHash(tile));
        base[0] = tile;
        assertEquals(2, Ae2GregTechCompat.machineHash(tile));
        dead[0] = true;
        assertEquals(1, Ae2GregTechCompat.machineHash(tile));
        dead[0] = false;
        assertEquals(2, Ae2GregTechCompat.machineHash(tile));
        meta[0] = null;
        assertEquals(1, Ae2GregTechCompat.machineHash(tile));
    }
}
