package kr.honeybee.beemod.handler;

import kr.honeybee.beemod.proxy.CommonProxy;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class CommonEvents {
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if(e.phase != TickEvent.Phase.START) {
            return;
        }

        if(!CommonProxy.sprintAllow) {
            e.player.setSprinting(false);
        }
    }
}
