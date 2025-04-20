package net.nayan135.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nayan135.mymod.MyMod;
import net.minecraftforge.registries.ForgeRegistries;


public class ModSounds {
//randomness credit: NAYAN135
public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
        DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MyMod.MOD_ID);
//custom sounf defineeee //just checking how you doing?
public static final RegistryObject<SoundEvent> NEW_ONE = registerSoundEvent("new_one");
public static final RegistryObject<SoundEvent> NEW_ONE2 = registerSoundEvent("new_one2");
public static final RegistryObject<SoundEvent> NEW_ONE3 = registerSoundEvent("new_one3");
public static final RegistryObject<SoundEvent> NEW_ONE4 = registerSoundEvent("new_one4");
public static final RegistryObject<SoundEvent> NEW_ONE5 = registerSoundEvent("new_one5");

public static final ForgeSoundType BLOCKSS_Sound = new ForgeSoundType(4f,1f,
        ModSounds.NEW_ONE, ModSounds.NEW_ONE2, ModSounds.NEW_ONE3, ModSounds.NEW_ONE4, ModSounds.NEW_ONE5);


private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
    return SOUND_EVENTS.register(name, ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MyMod.MOD_ID, name)));
}
public static void register(IEventBus eventBus) {
    SOUND_EVENTS.register(eventBus);
}

}