package prospectpyxis.glowinglights.blocks;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import prospectpyxis.glowinglights.GlowingLights;

public class BlockGlowGravel extends BlockFalling {

    public BlockGlowGravel() {
        super();
        this.lightValue = 15;

        setUnlocalizedName("glowing_gravel");
        setRegistryName("glowing_gravel");
    }

    public void registerItemModel(Item itemBlock) {
        GlowingLights.proxy.registerItemRenderer(itemBlock, 0, "glowing_gravel");
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public BlockGlowGravel setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    @SideOnly(Side.CLIENT)
    public int getDustColor(IBlockState state) {
        return -14941952;
    }
}
