package kr.honeybee.beemod;

import kr.honeybee.beemod.init.BeeTab;
import kr.honeybee.beemod.init.RegistrationHandler;
import kr.honeybee.beemod.network.PacketHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class BeeMod {
    public static Logger LOGGER;

    public static CreativeTabs beeTab = new BeeTab();

    @Mod.Instance(Reference.MOD_ID)
    public static BeeMod INSTANCE;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        LOGGER = event.getModLog();

        RegistrationHandler.init();
        PacketHandler.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
