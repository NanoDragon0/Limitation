package me.nanodragon.Limitation.GUI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryItemStorage implements IInventory {

    public static ItemStack[] inventory;//Массив слотов инвентаря в виде ItemStack

    public InventoryItemStorage() {
        //load();
    }

    @Override
    public int getSizeInventory() { //
        return inventory.length;
    }

    /**
     * Returns the stack in slot i
     *
     * @param p_70301_1_
     */
    @Override
    public ItemStack getStackInSlot(int p_70301_1_) {
        return null;
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
        return null;
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     *
     * @param p_70304_1_
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        return null;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     *
     * @param p_70299_1_
     * @param p_70299_2_
     */
    @Override
    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {

    }

    /**
     * Returns the name of the inventory
     */
    @Override
    public String getInventoryName() {
        return "NanoDragon | Чекер чанков";
    }

    /**
     * Returns if the inventory is named
     */
    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    @Override
    public int getInventoryStackLimit() {
        return 256;
    }

    /**
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    @Override
    public void markDirty() {

    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     *
     * @param p_70300_1_
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return false;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return false;
    }
}
