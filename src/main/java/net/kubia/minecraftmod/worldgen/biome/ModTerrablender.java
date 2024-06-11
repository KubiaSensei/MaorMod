package net.kubia.minecraftmod.worldgen.biome;

import net.kubia.minecraftmod.MinecraftMod;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(MinecraftMod.MOD_ID, "overworld"), 0));
    }
}
