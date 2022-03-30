package kr.honeybee.beemod;

import kr.honeybee.beemod.init.BeeBlockTab;
import kr.honeybee.beemod.init.BeeItemTab;
import kr.honeybee.beemod.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class BeeMod {
    public static CreativeTabs beeItemTab = new BeeItemTab();
    public static CreativeTabs beeBlockTab = new BeeBlockTab();

    @SidedProxy(clientSide = "kr.honeybee.beemod.proxy.ClientProxy", serverSide = "kr.honeybee.beemod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance(Reference.MOD_ID)
    public static BeeMod INSTANCE;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
