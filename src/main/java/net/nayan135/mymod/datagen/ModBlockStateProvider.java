package net.nayan135.mymod.datagen;

import net.nayan135.mymod.MyMod;
import net.nayan135.mymod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MyMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Register blocks with item models
        blockWithItem(ModBlocks.NAYAN);
        blockWithItem(ModBlocks.NAYAN1);
        blockWithItem(ModBlocks.NAYAN2);
        blockWithItem(ModBlocks.OCCURANCE);
        blockWithItem(ModBlocks.TEST_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        // Register the block with a simple cube model
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
