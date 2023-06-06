package me.nanodragon.Limitation.Utils;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import me.nanodragon.Limitation.GUI.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import org.lwjgl.input.Keyboard;

import static me.nanodragon.Limitation.GUI.InventoryItemStorage.inventory;

public class KeyHandler {

    // Клавиши мода
    private final KeyBinding check = new KeyBinding("Limitation.key.check", Keyboard.KEY_N, "limitation.key.category");
    private final KeyBinding openGUI = new KeyBinding("Limitation.key.openGUI", Keyboard.KEY_B, "limitation.key.category");

    public void register() {
        // Регистрируем клавиши в игре
        ClientRegistry.registerKeyBinding(check);
        ClientRegistry.registerKeyBinding(openGUI);

        // Регистрируем обработчик события
        FMLCommonHandler.instance().bus().register(this);
    }

    /**
     * Обработчик события нажатия клавиши в игре
     */
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (check.isPressed()) {
            // Выводит сообщение в чат с названием нажатой клавиши
            EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
            player.addChatMessage(new ChatComponentText("Была нажата кнопка: " + Keyboard.getKeyName(check.getKeyCode())));
            int j = 0;

            Chunk current_chunk = player.getEntityWorld().getChunkFromChunkCoords(player.chunkCoordX, player.chunkCoordZ);
            ExtendedBlockStorage[] block_in_chunk = current_chunk.getBlockStorageArray();
            byte[] l = block_in_chunk[0].getBlockLSBArray();
            if (l.length == 0) return;
            for (int i = 0; i < l.length; i++) {
                if (l[i] != 0 && l[i] != 1 && l[i] != 2 && l[i] != 7) {
                    inventory[j] = new ItemStack(Block.getBlockById(l[i])); //Краш
                    j++;
                }
            }
            System.out.print("Тест");
        }

        if (openGUI.isPressed()) {
            EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
            GuiHandler.openGui(GuiHandler.GuiID.LIMITATION_BLOCKS, player);
        }
    }

}
