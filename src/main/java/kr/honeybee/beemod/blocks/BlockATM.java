package kr.honeybee.beemod.blocks;

import kr.honeybee.beemod.BeeMod;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class BlockATM extends BlockBreakable {
    public static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0D, -1D, 0D, 1D, 1.25D, 1D);
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public BlockATM() {
        super(Material.IRON, false);

        setRegistryName("atm");
        setTranslationKey("atm");
        setCreativeTab(BeeMod.beeBlockTab);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));

        setSoundType(SoundType.STONE);
        setHardness(1.8F);
    }

    @Override
    public boolean isOpaqueCube(@Nonnull IBlockState p_149662_1_) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(@Nonnull IBlockState p_149686_1_) {
        return false;
    }

    @Override
    @SuppressWarnings("all")
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        IBlockState state = super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer);
        return state.withProperty(FACING, placer.getHorizontalFacing());
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex();
    }

    @Override
    @SuppressWarnings("all")
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.byHorizontalIndex(meta));
    }

    @Override
    @SuppressWarnings("all")
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }


    @Override
    @SuppressWarnings("all")
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    @SuppressWarnings("all")
    public AxisAlignedBB getBoundingBox(IBlockState p_185496_1_, IBlockAccess p_185496_2_, BlockPos p_185496_3_) {
        return BOUNDING_BOX;
    }

    @Override
    @SuppressWarnings("all")
    public AxisAlignedBB getCollisionBoundingBox(IBlockState p_180646_1_, IBlockAccess p_180646_2_, BlockPos p_180646_3_) {
        return BOUNDING_BOX;
    }
}
