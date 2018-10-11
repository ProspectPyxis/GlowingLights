package prospectpyxis.glowinglights.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
import prospectpyxis.glowinglights.core.ModItems;
import prospectpyxis.glowinglights.items.ItemGlowstoneBowl;

import java.util.Random;

public class BlockGlowstoneBowl extends BlockBase {

    protected static final AxisAlignedBB GLOWSTONE_BOWL_AABB = new AxisAlignedBB(0.125d, 0.0d, 0.125d, 0.875d, 0.3125d, 0.875d);

    @GameRegistry.ObjectHolder("glowinglights:glowstone_bowl_item")
    public static final Item glowstoneBowlOH = null;

    public BlockGlowstoneBowl() {
        super(Material.GROUND, "glowstone_bowl", 0.4f, 15f, MapColor.SAND);
        this.lightValue = 15;
        this.lightOpacity = 255;
        this.fullBlock = false;
        this.blockSoundType = SoundType.WOOD;
    }

    @Override
    @SuppressWarnings("deprecation")
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return GLOWSTONE_BOWL_AABB;
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        BlockPos blockPos = pos.offset(EnumFacing.DOWN);
        IBlockState state = worldIn.getBlockState(blockPos);

        if (state.isSideSolid(worldIn, blockPos, EnumFacing.UP) || state.getBlockFaceShape(worldIn, blockPos, EnumFacing.UP) == BlockFaceShape.SOLID) {
            return state.getBlock() != Blocks.END_GATEWAY;
        }
        else {
            return state.getBlock() instanceof BlockFence || state.getBlock() == Blocks.GLASS || state.getBlock() == Blocks.COBBLESTONE_WALL || state.getBlock() == Blocks.STAINED_GLASS;
        }
    }

    @Override
    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName("glowstone_bowl");
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return glowstoneBowlOH;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {

        BlockPos blockPos = pos.offset(EnumFacing.DOWN);

        if (worldIn.getBlockState(blockPos).getBlockFaceShape(worldIn, blockPos, EnumFacing.UP) != BlockFaceShape.SOLID
                || !(worldIn.getBlockState(blockPos).getBlock() instanceof BlockFence)
                || worldIn.getBlockState(blockPos).getBlock() != Blocks.GLASS
                || worldIn.getBlockState(blockPos).getBlock() != Blocks.COBBLESTONE_WALL
                || worldIn.getBlockState(blockPos).getBlock() != Blocks.STAINED_GLASS) {
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
        return new ItemStack(glowstoneBowlOH);
    }
}
