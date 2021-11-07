package kr.honeybee.beemod.handler;

import kr.honeybee.beemod.gui.GUIBankBook;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class EventTrigger {

    @SideOnly(Side.CLIENT)
    public static void openBankBook(List<String> log) {
        Minecraft.getMinecraft().displayGuiScreen(new GUIBankBook(log));
    }
}
