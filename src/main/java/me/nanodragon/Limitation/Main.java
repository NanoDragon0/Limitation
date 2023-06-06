package me.nanodragon.Limitation;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.nanodragon.Limitation.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = Main.MODID, name= Main.MODNAME, version = Main.MODVER)
public class Main {

    public static Main instance;
    public static final String MODID = "limitation";
    public static final String MODNAME = "Limitation finder";
    public static final String MODVER = "1.0.0";

    public static CreativeTabs tabTrainingMod = new CreativeTabs("TrainingMod") {
        public Item getTabIconItem() {
            return Item.getItemById(1);
        }
    };

    @SidedProxy(
            clientSide = "me.nanodragon.Limitation.proxy.ClientProxy",
            serverSide = "me.nanodragon.Limitation.proxy.CommonProxy"
    )
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        instance = this;
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}