package net.kubia.minecraftmod.datagen;

import net.kubia.minecraftmod.MinecraftMod;
import net.kubia.minecraftmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MinecraftMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        stairsBlock(((StairBlock) ModBlocks.JOHNNY_SINS_STAIRS.get()), blockTexture(ModBlocks.JOHNNY_SINS_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.JOHNNY_SINS_SLAB.get()), blockTexture(ModBlocks.JOHNNY_SINS_BLOCK.get()), blockTexture(ModBlocks.JOHNNY_SINS_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.JOHNNY_SINS_BUTTON.get()), blockTexture(ModBlocks.JOHNNY_SINS_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.JOHNNY_SINS_PRESSURE_PLATE.get()), blockTexture(ModBlocks.JOHNNY_SINS_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.JOHNNY_SINS_FENCE.get()), blockTexture(ModBlocks.JOHNNY_SINS_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.JOHNNY_SINS_GATE.get()), blockTexture(ModBlocks.JOHNNY_SINS_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.JOHNNY_SINS_WALL.get()), blockTexture(ModBlocks.JOHNNY_SINS_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.JOHNNY_SINS_DOOR.get()), modLoc("block/johnny_sins_door_bottom"), modLoc("block/johnny_sins_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.JOHNNY_SINS_TRAPDOOR.get()), modLoc("block/johnny_sins_trapdoor"), true, "cutout");

        blockWithItem(ModBlocks.JOHNNY_SINS_ORE);
        blockWithItem(ModBlocks.JOHNNY_SINS_GRASS);
        blockWithItem(ModBlocks.SHATTERED_JOHNNY_SINS_BLOCK);

        logBlock((RotatedPillarBlock) ModBlocks.JOHNNY_SINS_LOG.get());

        blockWithItem(ModBlocks.JOHNNY_SINS_PLANKS);
        leavesBlock(ModBlocks.JOHNNY_SINS_LEAVES);
        saplingBlock(ModBlocks.JOHNNY_SINS_SAPLING);

    }
    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}