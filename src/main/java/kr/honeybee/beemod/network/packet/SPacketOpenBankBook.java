package kr.honeybee.beemod.network.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import kr.honeybee.beemod.BeeMod;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class SPacketOpenBankBook implements IMessage, IMessageHandler<SPacketOpenBankBook, IMessage>  {
    private List<String> log;

    public SPacketOpenBankBook() {}

    @Override
    public void fromBytes(ByteBuf buf) {
        byte[] bytes = ByteBufUtil.getBytes(buf);

        String log = new String(bytes, StandardCharsets.UTF_8).substring(1);
        this.log = Arrays.asList(log.split(";;"));
    }

    @Override
    public void toBytes(ByteBuf buf) {

    }

    @Override
    public IMessage onMessage(SPacketOpenBankBook message, MessageContext ctx) {
        if(ctx.side == Side.CLIENT) {
            BeeMod.proxy.openBankBook(log);
        }

        return null;
    }
}
