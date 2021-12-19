package kr.honeybee.beemod.proxy;

import kr.honeybee.beemod.gui.GUIATM;
import kr.honeybee.beemod.gui.GUIBankBook;
import kr.honeybee.beemod.gui.overlay.OverlayWanted;
import kr.honeybee.beemod.handler.ClientEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;

import java.util.List;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        super.preInit();

        MinecraftForge.EVENT_BUS.register(new ClientEvents());
        MinecraftForge.EVENT_BUS.register(new OverlayWanted());
    }

    @Override
    public void registerModel(Item item) {
        assert item.getRegistryName() != null;
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    @Override
    public void openBankBook(List<String> log) {
        Minecraft.getMinecraft().displayGuiScreen(new GUIBankBook(log));
    }

    @Override
    public void openATM() {
        Minecraft.getMinecraft().displayGuiScreen(new GUIATM());
    }
}
