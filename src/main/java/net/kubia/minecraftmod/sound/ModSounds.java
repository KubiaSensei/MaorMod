package net.kubia.minecraftmod.sound;

import net.kubia.minecraftmod.MinecraftMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MinecraftMod.MOD_ID);

    public static final RegistryObject<SoundEvent> JOHNNY_SINS_BLOCK_PLACE = registerSoundEvents("johnny_sins_block_place");
    public static final RegistryObject<SoundEvent> JOHNNY_SINS_BLOCK_BREAK = registerSoundEvents("johnny_sins_block_break");
    public static final RegistryObject<SoundEvent> JOHNNY_SINS_BLOCK_HIT = registerSoundEvents("johnny_sins_block_hit");
    public static final RegistryObject<SoundEvent> JOHNNY_SINS_BLOCK_FALL = registerSoundEvents("johnny_sins_block_fall");
    public static final RegistryObject<SoundEvent> JOHNNY_SINS_BLOCK_STEP = registerSoundEvents("johnny_sins_block_step");
    public static final RegistryObject<SoundEvent> JOHNNY_SINS_DIMENSION_BACKGROUND_MUSIC = registerSoundEvents("johnny_sins_dimension_background_music");

    public static final ForgeSoundType JOHNNY_SINS_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.JOHNNY_SINS_BLOCK_BREAK, ModSounds.JOHNNY_SINS_BLOCK_PLACE, ModSounds.JOHNNY_SINS_BLOCK_HIT,
            ModSounds.JOHNNY_SINS_BLOCK_STEP, ModSounds.JOHNNY_SINS_BLOCK_FALL);

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MinecraftMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
