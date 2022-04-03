package kr.honeybee.beemod.network.packet;

import io.netty.buffer.ByteBuf;
import kr.honeybee.beemod.BeeMod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class SPacketOpenAtm implements IMessage, IMessageHandler<SPacketOpenAtm, IMessage>  {
    public SPacketOpenAtm() {}

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    @Override
    public IMessage onMessage(SPacketOpenAtm message, MessageContext ctx) {
        if(ctx.side == Side.CLIENT) {
            Minecraft.getMinecraft().addScheduledTask(() -> BeeMod.proxy.openATM());
        }

        return null;
    }
}
