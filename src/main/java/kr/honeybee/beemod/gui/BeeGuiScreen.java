package kr.honeybee.beemod.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public class BeeGuiScreen extends GuiScreen {
    protected ScaledResolution resolution;
    protected int width;
    protected int height;

    public BeeGuiScreen(int width, int height) {
        mc = Minecraft.getMinecraft();
        resolution = new ScaledResolution(mc);

        this.width = width;
        this.height = height;
    }

    @Override
    public void initGui() {
        resolution = new ScaledResolution(mc);

        super.initGui();
    }

    public int getCenterX() {
        return resolution.getScaledWidth() / 2;
    }

    public int getCenterY() {
        return resolution.getScaledHeight() / 2;
    }
}
