package net.nayan135.mymod.datagen;

import net.nayan135.mymod.block.ModBlocks;
import net.nayan135.mymod.item.moditems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        // Drop self blocks
        dropSelf(ModBlocks.NAYAN.get());
        dropSelf(ModBlocks.NAYAN1.get());
        dropSelf(ModBlocks.NAYAN2.get());
        dropSelf(ModBlocks.TEST_BLOCK.get());
        dropSelf(ModBlocks.OCCURANCE.get()); // Make sure this matches what's in ModBlocks

        // Custom loot
        this.add(ModBlocks.NAYAN.get(),
                block -> createOreDrop(ModBlocks.NAYAN.get(), moditems.TIME_FREEZE_ORB.get()));

        this.add(ModBlocks.NAYAN2.get(),
                block -> createMultipleOreDrops(ModBlocks.NAYAN2.get(), moditems.TIME_FREEZE_ORB.get(), 2, 6));

        this.add(ModBlocks.OCCURANCE.get(),
                block -> createMultipleOreDrops(ModBlocks.OCCURANCE.get(), moditems.TIME_FREEZE_ORB.get(), 2, 5));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
