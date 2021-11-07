package kr.honeybee.beemod.network.packet;

import io.netty.buffer.ByteBuf;
import kr.honeybee.beemod.handler.EventTrigger;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import java.util.List;

public class SPacketOpenBankBook implements IMessage, IMessageHandler<SPacketOpenBankBook, IMessage>  {
    private List<String> log;

    public SPacketOpenBankBook() {}

    @Override
    public void fromBytes(ByteBuf buf) {
        for(int i=1 ; i<=10 ; i++) {
            log.add(ByteBufUtils.readUTF8String(buf));
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {

    }

    @Override
    public IMessage onMessage(SPacketOpenBankBook message, MessageContext ctx) {
        if(ctx.side == Side.CLIENT) {
            EventTrigger.openBankBook(log);
        }

        return null;
    }
}
