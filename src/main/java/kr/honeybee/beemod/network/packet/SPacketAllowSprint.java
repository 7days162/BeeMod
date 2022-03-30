package kr.honeybee.beemod.network.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import kr.honeybee.beemod.proxy.CommonProxy;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class SPacketAllowSprint implements IMessage, IMessageHandler<SPacketAllowSprint, IMessage> {
    public SPacketAllowSprint() {}

    private boolean allow;

    @Override
    public void fromBytes(ByteBuf buf) {
        allow = ByteBufUtil.getBytes(buf)[0] == 1;
    }

    @Override
    public void toBytes(ByteBuf buf) {

    }

    @Override
    public IMessage onMessage(SPacketAllowSprint message, MessageContext ctx) {
        if(ctx.side == Side.CLIENT) {
            CommonProxy.sprintAllow = message.allow;
        }

        return null;
    }
}
