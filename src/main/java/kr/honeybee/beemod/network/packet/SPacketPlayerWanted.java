package kr.honeybee.beemod.network.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class SPacketPlayerWanted implements IMessage, IMessageHandler<SPacketPlayerWanted, IMessage> {
    public SPacketPlayerWanted() {}

    private boolean wanted;

    @Override
    public void fromBytes(ByteBuf buf) {
        byte[] bytes = ByteBufUtil.getBytes(buf);
        wanted = bytes[0] == 1;
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    @Override
    public IMessage onMessage(SPacketPlayerWanted message, MessageContext ctx) {
        if(ctx.side == Side.CLIENT) {
            Minecraft.getMinecraft().addScheduledTask(() -> Minecraft.getMinecraft().player.getEntityData().setBoolean("wanted", message.wanted));
        }

        return null;
    }
}
