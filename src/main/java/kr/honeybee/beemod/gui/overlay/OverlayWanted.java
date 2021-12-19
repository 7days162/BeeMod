package kr.honeybee.beemod.gui.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OverlayWanted extends Gui {
    private static final ResourceLocation texture = new ResourceLocation("beemod", "textures/gui/wanted.png");

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onRenderOverlay(RenderGameOverlayEvent.Post e) {
        if(e.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE) {
            return;
        }

        Minecraft mc = Minecraft.getMinecraft();

        if(mc.player == null || !mc.player.getEntityData().getBoolean("wanted")) {
            return;
        }

        // Init -- Start
        GlStateManager.pushAttrib();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.disableLighting();
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();

        ScaledResolution res = new ScaledResolution(mc);
        mc.getTextureManager().bindTexture(texture);

        Gui.drawModalRectWithCustomSizedTexture(res.getScaledWidth()-100, (mc.player.getActivePotionEffects().size() > 0 ? 25 : 5), 0, 0, 100, 100, 100, 100);

        // Disband - End
        GlStateManager.popAttrib();
    }
}
