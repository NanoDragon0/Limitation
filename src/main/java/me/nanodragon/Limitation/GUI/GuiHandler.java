package me.nanodragon.Limitation.GUI;

import cpw.mods.fml.common.network.IGuiHandler;
import me.nanodragon.Limitation.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;


public class GuiHandler implements IGuiHandler {

    public static void openGui(GuiID ID, EntityPlayer player) {
        player.openGui(Main.instance, ID.ordinal(), player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GuiID.LIMITATION_BLOCKS.ordinal()) {
            return new ContainerItemStorage(player, new InventoryItemStorage());
        } else return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GuiID.LIMITATION_BLOCKS.ordinal()) {
            return new ContainerItemStorage(player, new InventoryItemStorage());
        } else return null;
    }

    public enum GuiID {
        LIMITATION_BLOCKS
    }

}
