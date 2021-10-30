package kr.honeybee.beemod.network.packet;

import com.google.common.primitives.Longs;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SPacketBalanceInfo implements IMessage, IMessageHandler<SPacketBalanceInfo, IMessage> {
    private long balance;

    public SPacketBalanceInfo() {}

    @Override
    public void fromBytes(ByteBuf buf) {
        byte[] bytes = ByteBufUtil.getBytes(buf);
        this.balance = Longs.fromByteArray(bytes);
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    @Override
    public IMessage onMessage(SPacketBalanceInfo message, MessageContext ctx) {
        return null;
    }
}
