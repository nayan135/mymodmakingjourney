package net.nayan135.mymod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.nayan135.mymod.MyMod;
import net.minecraftforge.registries.RegistryObject;
import net.nayan135.mymod.item.TeleportationWandItem;
import net.nayan135.mymod.item.AutoSmeltPickaxeItem;
import net.nayan135.mymod.item.TimeFreezeOrbItem;

public class moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MyMod.MOD_ID);

    // Nayan items moved to ModBlocks.java as blocks

    // Custom special items
    public static final RegistryObject<Item> AUTO_SMELT_PICKAXE = ITEMS.register("auto_smelt_pickaxe",
            () -> new AutoSmeltPickaxeItem(new Item.Properties().stacksTo(1).durability(500)));

    public static final RegistryObject<Item> TELEPORTATION_WAND = ITEMS.register("teleportation_wand",
            () -> new TeleportationWandItem(new Item.Properties().stacksTo(1).durability(100)));

    public static final RegistryObject<Item> TIME_FREEZE_ORB = ITEMS.register("time_freeze_orb",
            () -> new TimeFreezeOrbItem(new Item.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
