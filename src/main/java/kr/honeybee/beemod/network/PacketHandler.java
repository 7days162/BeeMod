package kr.honeybee.beemod.network;

import kr.honeybee.beemod.network.packet.CPacketRequestBalanceInfo;
import kr.honeybee.beemod.network.packet.CPacketSimpleText;
import kr.honeybee.beemod.network.packet.SPacketBalanceInfo;
import kr.honeybee.beemod.network.packet.SPacketOpenBankBook;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
    public static final SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel("HoneyBee");

    public static void init() {
        registerMessage(CPacketSimpleText.class, CPacketSimpleText.class, 0, Side.SERVER);
        registerMessage(CPacketRequestBalanceInfo.class, CPacketRequestBalanceInfo.class, 1, Side.SERVER);
        registerMessage(SPacketBalanceInfo.class, SPacketBalanceInfo.class, 2, Side.CLIENT);
        registerMessage(SPacketOpenBankBook.class, SPacketOpenBankBook.class, 3, Side.SERVER);
    }

    private static <REQ extends IMessage, REPLY extends IMessage> void registerMessage(Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType, int id, Side side)
    {
        network.registerMessage(messageHandler, requestMessageType, id, side);
    }
}
