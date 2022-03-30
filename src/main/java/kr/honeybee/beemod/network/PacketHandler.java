package kr.honeybee.beemod.network;

import kr.honeybee.beemod.network.packet.*;
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
        registerMessage(SPacketOpenBankBook.class, SPacketOpenBankBook.class, 3, Side.CLIENT);
        registerMessage(CPacketAtmInteract.class, CPacketAtmInteract.class, 4, Side.SERVER);
        registerMessage(SPacketPlayerWanted.class, SPacketPlayerWanted.class, 5, Side.CLIENT);
        registerMessage(SPacketAllowSprint.class, SPacketAllowSprint.class, 6, Side.CLIENT);
        registerMessage(SPacketOpenAtm.class, SPacketOpenAtm.class, 7, Side.CLIENT);
    }

    private static <REQ extends IMessage, REPLY extends IMessage> void registerMessage(Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType, int id, Side side)
    {
        network.registerMessage(messageHandler, requestMessageType, id, side);
    }
}
