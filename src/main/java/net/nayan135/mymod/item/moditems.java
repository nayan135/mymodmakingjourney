package net.nayan135.mymod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.nayan135.mymod.MyMod;
import net.minecraftforge.registries.RegistryObject;

public class moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MyMod.MOD_ID);

    public static final RegistryObject<Item> NAYAN = ITEMS.register("nayan",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_NAYAN = ITEMS.register("raw_nayan",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
