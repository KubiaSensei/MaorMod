package net.kubia.minecraftmod.worldgen.biome;

import net.kubia.minecraftmod.MinecraftMod;
import net.kubia.minecraftmod.worldgen.ModPlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomes {
    public static final ResourceKey<Biome> JOHNNY_SINS_BIOME = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(MinecraftMod.MOD_ID, "johnny_sins_biome"));


    }