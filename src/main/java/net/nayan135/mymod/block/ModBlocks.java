package net.nayan135.mymod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nayan135.mymod.MyMod;
import net.nayan135.mymod.item.ModCreativeModeTab;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MyMod.MOD_ID);

    // Register Nayan blocks
    public static final RegistryObject<Block> NAYAN = registerBlock("nayan",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f)));

    public static final RegistryObject<Block> NAYAN1 = registerBlock("nayan1",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f)));

    public static final RegistryObject<Block> NAYAN2 = registerBlock("nayan2",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f)));

    public static final RegistryObject<Block> RANDOM_BLOCK = registerBlock("random_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).lightLevel(state -> 15)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return net.nayan135.mymod.item.moditems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
