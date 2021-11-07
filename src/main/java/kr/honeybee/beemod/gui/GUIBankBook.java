package kr.honeybee.beemod.gui;

import net.minecraft.client.gui.GuiScreen;

import java.util.List;

public class GUIBankBook extends GuiScreen {
    private final List<String> log;

    public GUIBankBook(List<String> log) {
        this.log = log;
    }
}
