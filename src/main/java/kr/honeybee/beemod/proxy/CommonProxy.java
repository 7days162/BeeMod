package kr.honeybee.beemod.proxy;

import kr.honeybee.beemod.handler.PlayerEvents;
import kr.honeybee.beemod.init.RegistrationHandler;
import kr.honeybee.beemod.network.PacketHandler;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import java.util.List;

public class CommonProxy {
    public void preInit() {
        MinecraftForge.EVENT_BUS.register(new PlayerEvents());

        RegistrationHandler.init();
        PacketHandler.init();
    }

    public void registerModel(Item item) {}

    public void openBankBook(List<String> log) {}

    public void openATM() {}
}
