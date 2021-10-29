package kr.honeybee.beemod.items;

import kr.honeybee.beemod.network.PacketHandler;
import kr.honeybee.beemod.network.packet.PacketSimpleText;
import kr.honeybee.beemod.network.packet.PacketUseCard;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

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
                PacketSimpleText packet = new PacketSimpleText("Hello Bukkit Sibal");
                PacketHandler.network.sendToServer(packet);

                return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(hand));
            }

            PacketUseCard packet = new PacketUseCard();
            PacketHandler.network.sendToServer(packet);
        }

        return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(hand));
    }
}
