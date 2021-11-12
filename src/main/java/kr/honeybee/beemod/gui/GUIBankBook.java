package kr.honeybee.beemod.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GUIBankBook extends GuiScreen {
    private static final int width = 256;
    private static final int height = 256;
    private static final int TITLE_COLOR = Color.black.getRGB();
    private static final int CONTENT_COLOR = Color.darkGray.getRGB();

    private final List<String> log;
    int currentLine = 0;

    private ScaledResolution resolution;

    public GUIBankBook(List<String> log) {
        super.mc = Minecraft.getMinecraft();
        this.log = log;

        // TODO
        log.add("211112|입금|7days162|+18,000|384,290,000");
        log.add("211113|출금|7days162|-100,000|384,190,000");
        log.add("211113|이체▲|Principia_|-190,000|384,100,000");
        log.add("211113|이체▼|Yahoo231|+10,000|384,110,000");
    }

    @Override
    public void initGui() {
        resolution = new ScaledResolution(mc);

        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        // Initialize
        if(mc == null) mc = Minecraft.getMinecraft();
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
        fontRenderer.drawString("거래일", (float) ((getCenterX() - 105) - (fontRenderer.getStringWidth("거래일") / 2)), getCurrentLineY(), TITLE_COLOR, false);
        fontRenderer.drawString("거래종류", (float) ((getCenterX() - 66) - (fontRenderer.getStringWidth("거래종류") / 2)), getCurrentLineY(), TITLE_COLOR, false);
        fontRenderer.drawString("거래인", (float) ((getCenterX() - 18) - (fontRenderer.getStringWidth("거래인") / 2)), getCurrentLineY(), TITLE_COLOR, false);
        fontRenderer.drawString("변경 금액(원)", (float) ((getCenterX() + 39) - (fontRenderer.getStringWidth("변경 금액(원)") / 2)), getCurrentLineY(), TITLE_COLOR, false);
        fontRenderer.drawString("남은 금액(원)", (float) ((getCenterX() + 96) - (fontRenderer.getStringWidth("남은 금액(원)") / 2)), getCurrentLineY(), TITLE_COLOR, false);
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

    public int getCenterX() {
        return resolution.getScaledWidth() / 2;
    }

    public int getCenterY() {
        return resolution.getScaledHeight() / 2;
    }
}
