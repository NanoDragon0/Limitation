package me.nanodragon.Limitation.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.nanodragon.Limitation.EventHandler;
import me.nanodragon.Limitation.GUI.GuiHandler;
import me.nanodragon.Limitation.Main;
import me.nanodragon.Limitation.Utils.KeyHandler;
import net.minecraftforge.common.MinecraftForge;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy{

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        EventHandler events = new EventHandler();
        MinecraftForge.EVENT_BUS.register(events);
        FMLCommonHandler.instance().bus().register(events);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
        KeyHandler keyHandler = new KeyHandler();
        keyHandler.register();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
    }
}
