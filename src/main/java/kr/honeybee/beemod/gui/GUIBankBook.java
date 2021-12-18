package kr.honeybee.beemod.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GUIBankBook extends BeeGuiScreen {
    private static final int TITLE_COLOR = Color.black.getRGB();
    private static final int CONTENT_COLOR = Color.darkGray.getRGB();

    private final List<String> log;
    private int currentLine = 0;

    public ScaledResolution resolution;

    public GUIBankBook(List<String> log) {
        super(256, 256);
        this.log = log;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        // Initialize
        if(mc == null) mc = Minecraft.getMinecraft();
        if(fontRenderer == null) fontRenderer = Minecraft.getMinecraft().fontRenderer;
        resolution = new ScaledResolution(mc);
        currentLine = 0;

        // 흑백 배경 그리기
        GL11.glColor4f(1, 1, 1, 1);
        drawDefaultBackground();

        // 통장 배경 그리기
        mc.renderEngine.bindTexture(new ResourceLocation("beemod", "textures/gui/bankbook.png"));
        drawTexturedModalRect((resolution.getScaledWidth() - width) / 2, (resolution.getScaledHeight() - height) / 2, 0, 0, width, height);

        // 첫 줄 그리기
        drawFirstLine();

        // 내역 그리기
        for(String data : log) {
            drawNextLine(data);
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void drawFirstLine() {
        fontRenderer.drawString("거래일", (float) ((getCenterX() - 105) - (fontRenderer.getStringWidth("거래일") / 2)), getCurrentLineY(), TITLE_COLOR, true);
        fontRenderer.drawString("거래종류", (float) ((getCenterX() - 66) - (fontRenderer.getStringWidth("거래종류") / 2)), getCurrentLineY(), TITLE_COLOR, true);
        fontRenderer.drawString("거래인", (float) ((getCenterX() - 18) - (fontRenderer.getStringWidth("거래인") / 2)), getCurrentLineY(), TITLE_COLOR, true);
        fontRenderer.drawString("변경 금액(원)", (float) ((getCenterX() + 39) - (fontRenderer.getStringWidth("변경 금액(원)") / 2)), getCurrentLineY(), TITLE_COLOR, true);
        fontRenderer.drawString("남은 금액(원)", (float) ((getCenterX() + 96) - (fontRenderer.getStringWidth("남은 금액(원)") / 2)), getCurrentLineY(), TITLE_COLOR, true);
    }

    public void drawNextLine(String data) {
        processLine();

        String[] texts = data.split("\\|");

        fontRenderer.drawString(texts[0], (float) ((getCenterX() - 105) - (fontRenderer.getStringWidth(texts[0]) / 2)), getCurrentLineY(), CONTENT_COLOR, false);
        fontRenderer.drawString(texts[1], (float) ((getCenterX() - 66) - (fontRenderer.getStringWidth(texts[1]) / 2)), getCurrentLineY(), CONTENT_COLOR, false);
        fontRenderer.drawString(texts[2], (float) ((getCenterX() - 18) - (fontRenderer.getStringWidth(texts[2]) / 2)), getCurrentLineY(), CONTENT_COLOR, false);
        fontRenderer.drawString(texts[3], (float) ((getCenterX() + 39) - (fontRenderer.getStringWidth(texts[3]) / 2)), getCurrentLineY(), CONTENT_COLOR, false);
        fontRenderer.drawString(texts[4], (float) ((getCenterX() + 96) - (fontRenderer.getStringWidth(texts[4]) / 2)), getCurrentLineY(), CONTENT_COLOR, false);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if(typedChar == 'e') {
            mc.displayGuiScreen(null);
        }

        super.keyTyped(typedChar, keyCode);
    }

    public void processLine() {
        currentLine++;
    }

    public int getCurrentLineY() {
        return getCenterY() - (-11 * currentLine + 74);
    }
}
