package kr.honeybee.beemod;

import kr.honeybee.beemod.handler.PlayerEvents;
import kr.honeybee.beemod.init.BeeBlockTab;
import kr.honeybee.beemod.init.BeeItemTab;
import kr.honeybee.beemod.init.RegistrationHandler;
import kr.honeybee.beemod.network.PacketHandler;
import kr.honeybee.beemod.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class BeeMod {
    public static Logger LOGGER;

    public static CreativeTabs beeItemTab = new BeeItemTab();
    public static CreativeTabs beeBlockTab = new BeeBlockTab();

    @SidedProxy(clientSide = "kr.honeybee.beemod.proxy.ClientProxy", serverSide = "kr.honeybee.beemod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance(Reference.MOD_ID)
    public static BeeMod INSTANCE;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        LOGGER = event.getModLog();

        MinecraftForge.EVENT_BUS.register(new PlayerEvents());

        RegistrationHandler.init();
        PacketHandler.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    public static boolean isBeeServer(World world) {
        if(world.isRemote) {
            return false;
        }

        if(!(world.getMinecraftServer() instanceof DedicatedServer)) {
            return false;
        }

        DedicatedServer server = (DedicatedServer) world.getMinecraftServer();
        return server.getStringProperty("server-name", "Server").equals("BeeOnline_IDEN_1031");
    }
}
