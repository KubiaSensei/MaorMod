package net.kubia.minecraftmod.item;

import net.kubia.minecraftmod.MinecraftMod;
import net.kubia.minecraftmod.block.ModBlocks;
import net.kubia.minecraftmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier JOHNNY_SINS = TierSortingRegistry.registerTier(
            new ForgeTier(5, 9999, 50f, 15f, 25,
                    ModTags.Blocks.NEEDS_JOHNNY_SINS_TOOLS, () -> Ingredient.of(ModBlocks.JOHNNY_SINS_BLOCK.get())),

            new ResourceLocation(MinecraftMod.MOD_ID, "johnny_sins"), List.of(Tiers.NETHERITE), List.of());
}
