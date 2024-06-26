package net.kubia.minecraftmod.datagen.loot;

import net.kubia.minecraftmod.block.ModBlocks;
import net.kubia.minecraftmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.JOHNNY_SINS_BLOCK.get());
        this.dropSelf(ModBlocks.JOHNNY_SINS_GRASS.get());
        this.dropSelf(ModBlocks.JOHNNY_SINS_SAPLING.get());
        this.dropSelf(ModBlocks.JOHNNY_SINS_LOG.get());
        this.dropSelf(ModBlocks.JOHNNY_SINS_PLANKS.get());
        this.dropSelf(ModBlocks.JOHNNY_SINS_STAIRS.get());
        this.dropSelf(ModBlocks.JOHNNY_SINS_BUTTON.get());
        this.dropSelf(ModBlocks.JOHNNY_SINS_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.JOHNNY_SINS_FENCE.get());
        this.dropSelf(ModBlocks.JOHNNY_SINS_GATE.get());
        this.dropSelf(ModBlocks.JOHNNY_SINS_WALL.get());
        this.dropSelf(ModBlocks.JOHNNY_SINS_TRAPDOOR.get());

        this.add(ModBlocks.JOHNNY_SINS_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.JOHNNY_SINS_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.JOHNNY_SINS_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.JOHNNY_SINS_ORE.get(), ModItems.JOHNNY_SINS_INGOT.get()));
        this.add(ModBlocks.JOHNNY_SINS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.JOHNNY_SINS_SLAB.get()));
        this.add(ModBlocks.JOHNNY_SINS_DOOR.get(),
                block -> createDoorTable(ModBlocks.JOHNNY_SINS_DOOR.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
}
