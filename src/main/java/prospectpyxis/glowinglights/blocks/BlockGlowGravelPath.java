package prospectpyxis.glowinglights.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class BlockGlowGravelPath extends BlockBase {

    protected static final AxisAlignedBB GLOW_GRAVEL_PATH_AABB = new AxisAlignedBB(0.0625d, 0.0d, 0.0625d, 0.9375d, 0.0625d, 0.9735d);

    @GameRegistry.ObjectHolder("glowinglights:glowing_gravel_path_item")
    public static final Item glowGravelPathOH = null;

    public BlockGlowGravelPath() {
        super(Material.GROUND, "glowing_gravel_path", 0.1f, 0.0f, MapColor.SAND);
        this.lightValue = 5;
        this.lightOpacity = 255;
        this.fullBlock = false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return GLOW_GRAVEL_PATH_AABB;
    }

    @Override
    @SuppressWarnings("deprecation")
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        BlockPos blockPos = pos.offset(EnumFacing.DOWN);
        IBlockState state = worldIn.getBlockState(blockPos);

        if (state.isSideSolid(worldIn, blockPos, EnumFacing.UP) || state.getBlockFaceShape(worldIn, blockPos, EnumFacing.UP) == BlockFaceShape.SOLID) {
            return state.getBlock() != Blocks.END_GATEWAY;
        }
        else {
            return false;
        }
    }

    @Override
    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName("glowing_gravel_path");
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return glowGravelPathOH;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {

        BlockPos blockPos = pos.offset(EnumFacing.DOWN);

        if (worldIn.getBlockState(blockPos).getBlockFaceShape(worldIn, blockPos, EnumFacing.UP) != BlockFaceShape.SOLID) {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }

    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.BOWL;
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(glowGravelPathOH);
    }
}
