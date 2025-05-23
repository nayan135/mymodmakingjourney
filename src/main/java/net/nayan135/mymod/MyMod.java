package net.nayan135.mymod;


// adding random comments to understand for future use
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.nayan135.mymod.block.ModBlocks;
import net.nayan135.mymod.item.ModCreativeModeTabs;
import net.nayan135.mymod.item.moditems;
import net.nayan135.mymod.sound.ModSounds;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file natraaaa gayooooo sabai mehanat pani maa
//btw mod is workingggg
//helllloo
@Mod(MyMod.MOD_ID)
public class MyMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "mymodnayan135";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();






    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public MyMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
// k vanam raa khaiii

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        moditems.register(modEventBus);
        ModBlocks.register(modEventBus);
        //
        ModCreativeModeTabs.register(modEventBus);
        ModSounds.register(modEventBus);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
    event.accept(ModBlocks.TEST_BLOCK.get());
    // Add nayan blocks to building blocks tab
    event.accept(ModBlocks.NAYAN.get());
    event.accept(ModBlocks.NAYAN1.get());
    event.accept(ModBlocks.NAYAN2.get());
}
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}

