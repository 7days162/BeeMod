package kr.honeybee.beemod.handler;

import kr.honeybee.beemod.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ClientEvents {
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent e) {
        if(e.phase != TickEvent.Phase.START) {
            return;
        }

        if(!CommonProxy.sprintAllow) {
            KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode(), false);
        }
    }
}
