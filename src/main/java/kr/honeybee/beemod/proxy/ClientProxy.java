package kr.honeybee.beemod.proxy;

import kr.honeybee.beemod.gui.GUIATM;
import kr.honeybee.beemod.gui.GUIBankBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

import java.util.List;

public class ClientProxy extends CommonProxy {
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
