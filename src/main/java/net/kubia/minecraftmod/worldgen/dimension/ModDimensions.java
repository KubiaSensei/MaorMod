package net.kubia.minecraftmod.worldgen.dimension;

import com.ibm.icu.impl.Pair;
import net.kubia.minecraftmod.MinecraftMod;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import java.util.List;
import java.util.OptionalLong;

public class ModDimensions {
        public static final ResourceKey<LevelStem> JOHNNYSINSDIM_KEY = ResourceKey.create(Registries.LEVEL_STEM,
                new ResourceLocation(MinecraftMod.MOD_ID, "johnnysinsdim"));
        public static final ResourceKey<Level> JOHNNYSINSDIM_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
                new ResourceLocation(MinecraftMod.MOD_ID, "johnnysinsdim"));
        public static final ResourceKey<DimensionType> JOHNNYSINSDIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
                new ResourceLocation(MinecraftMod.MOD_ID, "johnnysinsdim_type"));

    }
