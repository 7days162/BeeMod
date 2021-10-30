package kr.honeybee.beemod.items;

import kr.honeybee.beemod.network.PacketHandler;
import kr.honeybee.beemod.network.packet.CPacketRequestBalanceInfo;
import kr.honeybee.beemod.network.packet.CPacketSimpleText;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ItemCard extends BeeItem {
    public ItemCard() {
        super("card", "card");

        setMaxStackSize(1);
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World world, @Nonnull EntityPlayer player, @Nonnull EnumHand hand) {
        if(world.isRemote) {
            if(player.isSneaking()) {
                CPacketSimpleText packet = new CPacketSimpleText("PacketSimpleText 패킷 테스트");
                PacketHandler.network.sendToServer(packet);

                return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(hand));
            }

            CPacketRequestBalanceInfo packet = new CPacketRequestBalanceInfo();
            PacketHandler.network.sendToServer(packet);
        }

        return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(hand));
    }
}
