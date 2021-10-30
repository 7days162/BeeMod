package kr.honeybee.beemod.network.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CPacketRequestBalanceInfo implements IMessage, IMessageHandler<CPacketRequestBalanceInfo, IMessage> {
    public CPacketRequestBalanceInfo() {}

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    @Override
    public IMessage onMessage(CPacketRequestBalanceInfo message, MessageContext ctx) {
        return null;
    }
}
