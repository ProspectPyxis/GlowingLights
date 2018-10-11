package prospectpyxis.glowinglights.blocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBurning extends BlockBase {

    public BlockBurning(Material material, String name, float hardness, float resistance, MapColor mapColor) {
        super(material, name, hardness, resistance, mapColor);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (!(entityIn instanceof EntityPlayer) || !entityIn.isSneaking()) {
            entityIn.setFire(1);
        }
    }

    @Override
    public BlockBurning setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
