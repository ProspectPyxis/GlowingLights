package prospectpyxis.glowinglights.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockBlazePowder extends BlockBurning {

    public BlockBlazePowder() {
        super(Material.SAND, "blaze_powder_block", 3f, 0.75f, MapColor.SAND);
        this.lightValue = 3;
        this.blockSoundType = SoundType.SAND;
    }

    @Override
    public BlockBlazePowder setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Items.BLAZE_POWDER;
    }

    public int quantityDropped(Random random) {
        return 4;
    }
}
