package net.kubia.minecraftmod.datagen;

import net.kubia.minecraftmod.MinecraftMod;
import net.kubia.minecraftmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MinecraftMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.JOHNNY_SINS_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.JOHNNY_SINS_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.JOHNNY_SINS_WALL.get());


        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.JOHNNY_SINS_BLOCK.get(),
                        ModBlocks.JOHNNY_SINS_ORE.get(),
                        ModBlocks.JOHNNY_SINS_TRAPDOOR.get(),
                        ModBlocks.JOHNNY_SINS_DOOR.get(),
                        ModBlocks.JOHNNY_SINS_SLAB.get(),
                        ModBlocks.JOHNNY_SINS_BUTTON.get(),
                        ModBlocks.JOHNNY_SINS_STAIRS.get(),
                        ModBlocks.JOHNNY_SINS_WALL.get(),
                        ModBlocks.JOHNNY_SINS_GATE.get(),
                        ModBlocks.JOHNNY_SINS_PRESSURE_PLATE.get(),
                        ModBlocks.JOHNNY_SINS_FENCE.get());

    }
}
