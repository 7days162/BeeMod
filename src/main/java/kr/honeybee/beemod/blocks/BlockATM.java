package kr.honeybee.beemod.blocks;

import kr.honeybee.beemod.BeeMod;
import kr.honeybee.beemod.init.BeeItems;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class BlockATM extends BlockBreakable {
    public BlockATM() {
        super(Material.IRON, false);

        setRegistryName("atm");
        setTranslationKey("atm");
        setCreativeTab(BeeMod.beeBlockTab);

        setSoundType(SoundType.STONE);
        setHardness(1.8F);
    }

    @Override
    public boolean onBlockActivated(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull IBlockState state, @Nonnull EntityPlayer player, @Nonnull EnumHand hand, @Nonnull EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(world.isRemote && hand == EnumHand.MAIN_HAND) {
            if(player.getHeldItem(hand).getItem() != BeeItems.BANKBOOK) {
                Minecraft.getMinecraft().player.sendMessage(new TextComponentString("§7§l[§6§l !§7§l ]§f 통장을 들고 ATM 을 우클릭하여 주십시요."));
                return true;
            }

            BeeMod.proxy.openATM();

            return true;
        }

        return false;
    }
}
