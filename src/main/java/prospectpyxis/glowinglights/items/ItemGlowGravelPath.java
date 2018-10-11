package prospectpyxis.glowinglights.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlockSpecial;
import prospectpyxis.glowinglights.GlowingLights;
import prospectpyxis.glowinglights.core.ModBlocks;

public class ItemGlowGravelPath extends ItemBlockSpecial {

    public ItemGlowGravelPath() {
        super(ModBlocks.blockGlowGravelPath);
        setRegistryName("glowing_gravel_path_item");
        setUnlocalizedName("glowing_gravel_path_item");
    }

    public void registerItemModel() {
        GlowingLights.proxy.registerItemRenderer(this, 0, "glowing_gravel_path_item");
    }

    @Override
    public ItemGlowGravelPath setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
