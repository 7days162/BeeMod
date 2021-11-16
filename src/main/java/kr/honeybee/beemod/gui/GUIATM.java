package kr.honeybee.beemod.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

public class GUIATM extends BeeGuiScreen {
    public GUIATM() {
        super(256, 256);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        if(mc == null) mc = Minecraft.getMinecraft();
        if(fontRenderer == null) fontRenderer = Minecraft.getMinecraft().fontRenderer;
        resolution = new ScaledResolution(mc);

        // 흑백 배경 그리기
        GL11.glColor4f(1, 1, 1, 1);
        drawDefaultBackground();

        // 통장 배경 그리기
        String point = getCurrentPoint(mouseX, mouseY);

        if(point == null) {
            mc.renderEngine.bindTexture(new ResourceLocation("beemod", "textures/gui/atm.png"));
        }

        if(point != null) switch(point) {
            case "예금입금": mc.renderEngine.bindTexture(new ResourceLocation("beemod", "textures/gui/atmin/atm1.png")); break;
            case "예금인출": mc.renderEngine.bindTexture(new ResourceLocation("beemod", "textures/gui/atmin/atm2.png")); break;
            case "계좌이체": mc.renderEngine.bindTexture(new ResourceLocation("beemod", "textures/gui/atmin/atm3.png")); break;
            case "납부": mc.renderEngine.bindTexture(new ResourceLocation("beemod", "textures/gui/atmin/atm4.png")); break;
            case "내역조회": mc.renderEngine.bindTexture(new ResourceLocation("beemod", "textures/gui/atmin/atm5.png")); break;
            case "내역정리": mc.renderEngine.bindTexture(new ResourceLocation("beemod", "textures/gui/atmin/atm6.png")); break;
            case "내역삭제": mc.renderEngine.bindTexture(new ResourceLocation("beemod", "textures/gui/atmin/atm7.png")); break;
            case "다른업무": mc.renderEngine.bindTexture(new ResourceLocation("beemod", "textures/gui/atmin/atm8.png")); break;
        }

        drawTexturedModalRect((resolution.getScaledWidth() - width) / 2, (resolution.getScaledHeight() - height) / 2, 0, 0, width, height);

        // 마우스 포인트 그리기는 왜 안될까????????????????????
        // TODO

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if(typedChar == 'e') {
            mc.displayGuiScreen(null);
        }

        super.keyTyped(typedChar, keyCode);
    }

    private String getCurrentPoint(int x, int y) {
        if(getCenterX() - 119 <= x && x <= getCenterX() - 56) {
            if(getCenterY() - 85 <= y && y <= getCenterY() - 61) {
                return "예금입금";
            }
            if(getCenterY() - 40 <= y && y <= getCenterY() - 16) {
                return "예금인출";
            }
            if(getCenterY() + 4 <= y && y <= getCenterY() + 29) {
                return "계좌이체";
            }
            if(getCenterY() + 50 <= y && y <= getCenterY() + 74) {
                return "납부";
            }
        }

        if(getCenterX() + 54 <= x && x <= getCenterX() + 116) {
            if(getCenterY() - 85 <= y && y <= getCenterY() - 61) {
                return "내역조회";
            }
            if(getCenterY() - 40 <= y && y <= getCenterY() - 16) {
                return "내역정리";
            }
            if(getCenterY() + 4 <= y && y <= getCenterY() + 29) {
                return "내역삭제";
            }
            if(getCenterY() + 50 <= y && y <= getCenterY() + 74) {
                return "다른업무";
            }
        }

        return null;
    }
}
