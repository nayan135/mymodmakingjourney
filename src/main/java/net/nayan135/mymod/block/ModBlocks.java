package net.nayan135.mymod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.nayan135.mymod.MyMod;
import net.nayan135.mymod.item.moditems;
import net.minecraftforge.registries.RegistryObject;
import net.nayan135.mymod.sound.ModSounds;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MyMod.MOD_ID);


    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER) ));


    // Nayan blocks
    public static final RegistryObject<Block> NAYAN = registerBlock("nayan",
            () -> new Block(BlockBehaviour.Properties.of().strength(3.0f).requiresCorrectToolForDrops().sound(ModSounds.BLOCKSS_Sound)));
 

    public static final RegistryObject<Block> NAYAN1 = registerBlock("nayan1",
            () -> new Block(BlockBehaviour.Properties.of().strength(3.0f).requiresCorrectToolForDrops().sound(ModSounds.BLOCKSS_Sound)));

    public static final RegistryObject<Block> NAYAN2 = registerBlock("nayan2",
            () -> new Block(BlockBehaviour.Properties.of().strength(3.0f).requiresCorrectToolForDrops().sound(ModSounds.BLOCKSS_Sound)));

    //just being boredd

    

    public static final RegistryObject<Block> RANDOM_BLOCK = registerBlock("random_block",
            () -> new Block(BlockBehaviour.Properties
                    .of()
                    .strength(3.0f)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> 12)
                    .sound(ModSounds.BLOCKSS_Sound)));

    public static final RegistryObject<Block> LOOKS_COOL = registerBlock("looks_cool",
            () -> new Block(BlockBehaviour.Properties
                    .of()
                    .strength(3.0f)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> 12)
                    .sound(ModSounds.BLOCKSS_Sound)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        moditems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
