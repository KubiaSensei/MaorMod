package net.kubia.minecraftmod.item;

import net.kubia.minecraftmod.MinecraftMod;
import net.kubia.minecraftmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MinecraftMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAOR_MOD_TAB = CREATIVE_MODE_TABS.register("maor_mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.JOHNNY_SINS_BLOCK.get()))
                    .title(Component.translatable("creativetab.maor_mod_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        //BLOCKS
                        pOutput.accept(ModBlocks.JOHNNY_SINS_BLOCK.get());
                        pOutput.accept(ModBlocks.JOHNNY_SINS_GRASS.get());
                        pOutput.accept(ModBlocks.SHATTERED_JOHNNY_SINS_BLOCK.get());
                        pOutput.accept(ModBlocks.JOHNNY_SINS_LOG.get());
                        pOutput.accept(ModBlocks.JOHNNY_SINS_LEAVES.get());
                        pOutput.accept(ModBlocks.JOHNNY_SINS_PLANKS.get());
                        pOutput.accept(ModBlocks.JOHNNY_SINS_ORE.get());
                        pOutput.accept(ModBlocks.JOHNNY_SINS_STAIRS.get());
                        pOutput.accept(ModBlocks.JOHNNY_SINS_SLAB.get());
                        pOutput.accept(ModBlocks.JOHNNY_SINS_BUTTON.get());
                        pOutput.accept(ModBlocks.JOHNNY_SINS_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.JOHNNY_SINS_DOOR.get());
                        pOutput.accept(ModBlocks.JOHNNY_SINS_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.JOHNNY_SINS_FENCE.get());
                        pOutput.accept(ModBlocks.JOHNNY_SINS_GATE.get());
                        pOutput.accept(ModBlocks.JOHNNY_SINS_WALL.get());
                        //ITEMS
                        pOutput.accept(ModItems.JOHNNY_SINS_INGOT.get());
                        //TOOLS
                        pOutput.accept(ModItems.JOHNNY_SINS_SWORD.get());
                        pOutput.accept(ModItems.JOHNNY_SINS_PICKAXE.get());
                        pOutput.accept(ModItems.JOHNNY_SINS_AXE.get());
                        pOutput.accept(ModItems.JOHNNY_SINS_SHOVEL.get());
                        pOutput.accept(ModItems.JOHNNY_SINS_HOE.get());
                        //ARMOR
                        pOutput.accept(ModItems.JOHNNY_SINS_HELMET.get());
                        pOutput.accept(ModItems.JOHNNY_SINS_CHESTPLATE.get());
                        pOutput.accept(ModItems.JOHNNY_SINS_LEGGINGS.get());
                        pOutput.accept(ModItems.JOHNNY_SINS_BOOTS.get());
                        pOutput.accept(ModBlocks.JOHNNY_SINS_SAPLING.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
