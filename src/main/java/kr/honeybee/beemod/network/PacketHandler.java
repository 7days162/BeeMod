package kr.honeybee.beemod.network;

import kr.honeybee.beemod.network.packet.PacketSimpleText;
import kr.honeybee.beemod.network.packet.PacketUseCard;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
    public static final SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel("HoneyBee");

    private static int packetId = 0;

    public static void init() {
        registerMessage(PacketUseCard.class, PacketUseCard.class, Side.SERVER);
        registerMessage(PacketSimpleText.class, PacketSimpleText.class, Side.SERVER);
    }

    private static <REQ extends IMessage, REPLY extends IMessage> void registerMessage(Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType, Side side)
    {
        network.registerMessage(messageHandler, requestMessageType, packetId++, side);
    }
}
