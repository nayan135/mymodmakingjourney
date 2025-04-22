package net.nayan135.mymod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nayan135.mymod.MyMod;
import net.nayan135.mymod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MyMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NAYAN_TAB = CREATIVE_MODE_TABS.register("nayan_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.NAYAN.get()))
                    .title(Component.translatable("creativetab.nayan_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // Items
                        pOutput.accept(moditems.AUTO_SMELT_PICKAXE.get());
                        pOutput.accept(moditems.TELEPORTATION_WAND.get());
                        pOutput.accept(moditems.TIME_FREEZE_ORB.get());
                        pOutput.accept(moditems.BREAD.get());
                        pOutput.accept(moditems.PIECE.get());

                        // Blocks
                        pOutput.accept(ModBlocks.TEST_BLOCK.get());
                        pOutput.accept(ModBlocks.NAYAN.get());
                        pOutput.accept(ModBlocks.NAYAN1.get());
                        pOutput.accept(ModBlocks.NAYAN2.get());
                        pOutput.accept(ModBlocks.RANDOM_BLOCK.get());
                        pOutput.accept(ModBlocks.LOOKS_COOL.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
