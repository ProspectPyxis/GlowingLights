package prospectpyxis.glowinglights.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import prospectpyxis.glowinglights.GlowingLights;

public class BlockBase extends Block {

    protected String name;

    public BlockBase(Material material, String name, float hardness, float resistance, MapColor mapColor) {
        super(material, mapColor);

        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);

        setHardness(hardness);
        setResistance(resistance);
    }

    public BlockBase(Material material, String name, float hardness, float resistance) {
        this(material, name, hardness, resistance, material.getMaterialMapColor());
    }

    public void registerItemModel(Item itemBlock) {
        GlowingLights.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public BlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
