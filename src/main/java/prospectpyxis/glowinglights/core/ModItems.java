package prospectpyxis.glowinglights.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import prospectpyxis.glowinglights.items.ItemGlowGravelPath;
import prospectpyxis.glowinglights.items.ItemGlowstoneBowl;

public class ModItems {

    public static ItemGlowstoneBowl itemGlowstoneBowl = new ItemGlowstoneBowl().setCreativeTab(CreativeTabs.DECORATIONS);
    public static ItemGlowGravelPath itemGlowGravelPath = new ItemGlowGravelPath().setCreativeTab(CreativeTabs.DECORATIONS);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                itemGlowstoneBowl,
                itemGlowGravelPath
        );
    }

    public static void registerModels() {
        itemGlowstoneBowl.registerItemModel();
        itemGlowGravelPath.registerItemModel();
    }
}
