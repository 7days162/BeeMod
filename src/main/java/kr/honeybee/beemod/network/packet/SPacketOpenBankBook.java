package kr.honeybee.beemod.network.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import kr.honeybee.beemod.BeeMod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SPacketOpenBankBook implements IMessage, IMessageHandler<SPacketOpenBankBook, IMessage> {
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
            if(message.log == null || message.log.size() == 0 || (message.log.size() == 1 && !message.log.get(0).contains("|"))) {
                Minecraft.getMinecraft().addScheduledTask(() -> BeeMod.proxy.openBankBook(Collections.emptyList()));
                return null;
            }

            Minecraft.getMinecraft().addScheduledTask(() -> BeeMod.proxy.openBankBook(message.log));
        }

        return null;
    }
}
