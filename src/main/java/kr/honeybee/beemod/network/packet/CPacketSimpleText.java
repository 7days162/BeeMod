package kr.honeybee.beemod.network.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CPacketSimpleText implements IMessage, IMessageHandler<CPacketSimpleText, IMessage> {
    private String text;

    public CPacketSimpleText() {}

    public CPacketSimpleText(String text) {
        this.text = text;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        text = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, text);
    }

    @Override
    public IMessage onMessage(CPacketSimpleText message, MessageContext ctx) {
        return null;
    }
}
