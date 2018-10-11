package prospectpyxis.glowinglights.core;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import prospectpyxis.glowinglights.blocks.BlockBlazePowder;
import prospectpyxis.glowinglights.blocks.BlockGlowGravel;
import prospectpyxis.glowinglights.blocks.BlockGlowGravelPath;
import prospectpyxis.glowinglights.blocks.BlockGlowstoneBowl;

public class ModBlocks {

    public static BlockBlazePowder blockBlazePowder = new BlockBlazePowder().setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    public static BlockGlowstoneBowl blockGlowstoneBowl = new BlockGlowstoneBowl();
    public static BlockGlowGravel blockGlowGravel = new BlockGlowGravel().setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    public static BlockGlowGravelPath blockGlowGravelPath = new BlockGlowGravelPath();

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                blockBlazePowder,
                blockGlowstoneBowl,
                blockGlowGravel,
                blockGlowGravelPath
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                blockBlazePowder.createItemBlock(),
                blockGlowstoneBowl.createItemBlock(),
                blockGlowGravel.createItemBlock(),
                blockGlowGravelPath.createItemBlock()
        );
    }

    public static void registerModels() {
        blockBlazePowder.registerItemModel(Item.getItemFromBlock(blockBlazePowder));
        blockGlowstoneBowl.registerItemModel(Item.getItemFromBlock(blockGlowstoneBowl));
        blockGlowGravel.registerItemModel(Item.getItemFromBlock(blockGlowGravel));
        blockGlowGravelPath.registerItemModel(Item.getItemFromBlock(blockGlowGravelPath));
    }
}
