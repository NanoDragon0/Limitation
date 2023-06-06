package me.nanodragon.Limitation.Utils;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class StorageSlot extends Slot {

    public StorageSlot(IInventory inv, int id, int x, int y) {
        super(inv, id, x, y);
    }

    //Нельзя поставить в этот слот предмет с экземпляром ItemBackpack.
    //В дальнейшем я тут буду добавлять, чтобы нельзя из других модов вставлять предметы с хранением вещей.
    @Override
    public boolean isItemValid(ItemStack is) {
        return false; //Проверка на то, правильный ли мы предмет положили. Изначально, в GUI нельзя будет класть предметы
    }

}
