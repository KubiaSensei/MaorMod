package net.kubia.minecraftmod.worldgen.biome;

import net.kubia.minecraftmod.MinecraftMod;
import net.kubia.minecraftmod.sound.ModSounds;
import net.kubia.minecraftmod.worldgen.ModPlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomes {
    public static final ResourceKey<Biome> JOHNNY_SINS_BIOME = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(MinecraftMod.MOD_ID, "johnny_sins_biome"));

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(JOHNNY_SINS_BIOME, johnnysinsBiome(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static Biome johnnysinsBiome(BootstapContext<Biome> context) {

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.JOHNNY_SINS_PLACED_KEY);

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.TURTLE, 50, 40, 40));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(16777215)
                        .waterFogColor(16777215)
                        .skyColor(16777215)
                        .grassColorOverride(16777215)
                        .foliageColorOverride(16777215)
                        .fogColor(16777215)
                        .backgroundMusic(Musics.createGameMusic(ModSounds.JOHNNY_SINS_DIMENSION_BACKGROUND_MUSIC.getHolder().get())).build())
                .build();
    }
}