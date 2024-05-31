package net.kubia.minecraftmod.datagen;

import net.kubia.minecraftmod.MinecraftMod;
import net.kubia.minecraftmod.block.ModBlocks;
import net.kubia.minecraftmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MinecraftMod.MOD_ID, existingFileHelper);
    }

        @Override
        protected void registerModels () {


            simpleBlockItem(ModBlocks.JOHNNY_SINS_DOOR);

            fenceItem(ModBlocks.JOHNNY_SINS_FENCE, ModBlocks.JOHNNY_SINS_BLOCK);
            buttonItem(ModBlocks.JOHNNY_SINS_BUTTON, ModBlocks.JOHNNY_SINS_BLOCK);
            wallItem(ModBlocks.JOHNNY_SINS_WALL, ModBlocks.JOHNNY_SINS_BLOCK);

            evenSimplerBlockItem(ModBlocks.JOHNNY_SINS_STAIRS);
            evenSimplerBlockItem(ModBlocks.JOHNNY_SINS_SLAB);
            evenSimplerBlockItem(ModBlocks.JOHNNY_SINS_PRESSURE_PLATE);
            evenSimplerBlockItem(ModBlocks.JOHNNY_SINS_GATE);

            trapdoorItem(ModBlocks.JOHNNY_SINS_TRAPDOOR);

            handheldItem(ModItems.JOHNNY_SINS_SWORD);
            handheldItem(ModItems.JOHNNY_SINS_PICKAXE);
            handheldItem(ModItems.JOHNNY_SINS_AXE);
            handheldItem(ModItems.JOHNNY_SINS_SHOVEL);
            handheldItem(ModItems.JOHNNY_SINS_HOE);

            simpleItem(ModItems.JOHNNY_SINS_HELMET);
            simpleItem(ModItems.JOHNNY_SINS_CHESTPLATE);
            simpleItem(ModItems.JOHNNY_SINS_LEGGINGS);
            simpleItem(ModItems.JOHNNY_SINS_BOOTS);
        }
        private ItemModelBuilder simpleItem (RegistryObject < Item > item) {
            return withExistingParent(item.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(MinecraftMod.MOD_ID, "item/" + item.getId().getPath()));
        }

        public void evenSimplerBlockItem (RegistryObject < Block > block) {
            this.withExistingParent(MinecraftMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                    modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
        }

        public void trapdoorItem (RegistryObject < Block > block) {
            this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                    modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
        }

        public void fenceItem (RegistryObject < Block > block, RegistryObject < Block > baseBlock){
            this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                    .texture("texture", new ResourceLocation(MinecraftMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
        }

        public void buttonItem (RegistryObject < Block > block, RegistryObject < Block > baseBlock){
            this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                    .texture("texture", new ResourceLocation(MinecraftMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
        }

        public void wallItem (RegistryObject < Block > block, RegistryObject < Block > baseBlock){
            this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                    .texture("wall", new ResourceLocation(MinecraftMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
        }

        private ItemModelBuilder handheldItem (RegistryObject < Item > item) {
            return withExistingParent(item.getId().getPath(),
                    new ResourceLocation("item/handheld")).texture("layer0",
                    new ResourceLocation(MinecraftMod.MOD_ID, "item/" + item.getId().getPath()));
        }

        private ItemModelBuilder simpleBlockItem (RegistryObject < Block > item) {
            return withExistingParent(item.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(MinecraftMod.MOD_ID, "item/" + item.getId().getPath()));
        }
    }
