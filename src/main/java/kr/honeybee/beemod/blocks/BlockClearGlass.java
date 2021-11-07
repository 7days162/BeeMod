package kr.honeybee.beemod.blocks;

import kr.honeybee.beemod.BeeMod;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

import javax.annotation.Nonnull;

public class BlockClearGlass extends BlockGlass {
    public BlockClearGlass() {
        super(Material.GLASS, false);

        setRegistryName("clearglass");
        setTranslationKey("clearglass");
        setCreativeTab(BeeMod.beeBlockTab);

        setSoundType(SoundType.GLASS);
        setHardness(0.3F);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isTranslucent(@Nonnull IBlockState state) {
        return true;
    }

    @Override
    @Nonnull
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isOpaqueCube(@Nonnull IBlockState state) {
        return false;
    }
}
