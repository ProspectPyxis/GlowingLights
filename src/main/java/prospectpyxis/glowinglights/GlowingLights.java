package prospectpyxis.glowinglights;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import prospectpyxis.glowinglights.core.ModBlocks;
import prospectpyxis.glowinglights.core.ModItems;
import prospectpyxis.glowinglights.proxy.CommonProxy;

@Mod(modid = GlowingLights.modId, name = GlowingLights.name, version = GlowingLights.version)
public class GlowingLights {

    public static final String modId = "glowinglights";
    public static final String name = "Glowing Lights";
    public static final String version = "0.1";

    @Mod.Instance(modId)
    public static GlowingLights instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("Loading " + name);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @SidedProxy(serverSide = "prospectpyxis.glowinglights.proxy.CommonProxy", clientSide = "prospectpyxis.glowinglights.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ModItems.registerModels();
            ModBlocks.registerModels();
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
        }
    }
}
