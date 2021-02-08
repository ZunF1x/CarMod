package fr.zunf1x.carmod;

import fr.zunf1x.carmod.init.ModItems;
import fr.zunf1x.carmod.proxy.CommonProxy;
import fr.zunf1x.carmod.utils.References;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class CarMod {

    @Instance(References.MODID)
    public static CarMod instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit();

        ModItems.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit();
    }

    @SidedProxy(clientSide = "fr.zunf1x.carmod.proxy.ClientProxy", serverSide = "fr.zunf1x.carmod.proxy.ServerProxy")
    public static CommonProxy proxy;
}
