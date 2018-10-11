package prospectpyxis.glowinglights.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlockSpecial;
import prospectpyxis.glowinglights.GlowingLights;
import prospectpyxis.glowinglights.core.ModBlocks;

public class ItemGlowstoneBowl extends ItemBlockSpecial {

    public ItemGlowstoneBowl() {
        super(ModBlocks.blockGlowstoneBowl);
        setRegistryName("glowstone_bowl_item");
        setUnlocalizedName("glowstone_bowl_item");
    }

    public void registerItemModel() {
        GlowingLights.proxy.registerItemRenderer(this, 0, "glowstone_bowl_item");
    }

    @Override
    public ItemGlowstoneBowl setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
