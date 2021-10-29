package kr.honeybee.beemod.network.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSimpleText implements IMessage, IMessageHandler<PacketSimpleText, IMessage> {
    private String text;

    public PacketSimpleText() {}

    public PacketSimpleText(String text) {
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
    public IMessage onMessage(PacketSimpleText message, MessageContext ctx) {
        System.out.println("Packet " + message + " from " + ctx.getServerHandler().player.getName());



        return null;
    }
}
