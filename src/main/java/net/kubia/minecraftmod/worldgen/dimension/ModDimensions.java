package net.kubia.minecraftmod.worldgen.dimension;

import com.ibm.icu.impl.Pair;
import net.kubia.minecraftmod.MinecraftMod;
import net.kubia.minecraftmod.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
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


    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(JOHNNYSINSDIM_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                false, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.BASE_STONE_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(ModBiomes.JOHNNY_SINS_BIOME)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.AMPLIFIED));
        LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDimensions.JOHNNYSINSDIM_TYPE), wrappedChunkGenerator);

        context.register(JOHNNYSINSDIM_KEY, stem);
    }
}
