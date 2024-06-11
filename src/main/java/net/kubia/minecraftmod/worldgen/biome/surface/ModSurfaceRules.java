package net.kubia.minecraftmod.worldgen.biome.surface;

import net.kubia.minecraftmod.block.ModBlocks;
import net.kubia.minecraftmod.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {

    private static final SurfaceRules.RuleSource DIRT = makeStateRule(ModBlocks.JOHNNY_SINS_GRASS.get());
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(ModBlocks.JOHNNY_SINS_GRASS.get());
    private static final SurfaceRules.RuleSource JOHNNY_SINS_BLOCK = makeStateRule(ModBlocks.JOHNNY_SINS_BLOCK.get());

    public static SurfaceRules.RuleSource makeRules()
    {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.JOHNNY_SINS_BIOME),
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, JOHNNY_SINS_BLOCK)),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, JOHNNY_SINS_BLOCK)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
