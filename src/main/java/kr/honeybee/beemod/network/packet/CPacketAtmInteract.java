package kr.honeybee.beemod.network.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CPacketAtmInteract implements IMessage, IMessageHandler<CPacketAtmInteract, IMessage>  {
    private ItemStack item;
    private String message;

    public CPacketAtmInteract() {}

    public CPacketAtmInteract(ItemStack item, String message) {
        this.item = item;
        this.message = message;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
        assert item.getTagCompound() != null;
        String message = item.getTagCompound().getCompoundTag("display").getTagList("Lore", 8) + "|" + this.message;
        ByteBufUtils.writeUTF8String(buf, message);
    }

    @Override
    public IMessage onMessage(CPacketAtmInteract message, MessageContext ctx) {
        return null;
    }
}
