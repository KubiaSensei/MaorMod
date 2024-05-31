package net.kubia.minecraftmod.block;

import net.kubia.minecraftmod.MinecraftMod;
import net.kubia.minecraftmod.item.ModItems;
import net.kubia.minecraftmod.sound.ModSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MinecraftMod.MOD_ID);

    //Johnny Sins Set(Block,Stairs,Walls,etc.)
    public static final RegistryObject<Block> JOHNNY_SINS_BLOCK = registerBlock("johnny_sins_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(ModSounds.JOHNNY_SINS_BLOCK_SOUNDS)));

    public static final RegistryObject<Block> JOHNNY_SINS_ORE = registerBlock("johnny_sins_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).sound(ModSounds.JOHNNY_SINS_BLOCK_SOUNDS)));
    public static final RegistryObject<Block> JOHNNY_SINS_STAIRS = registerBlock("johnny_sins_stairs",
            () -> new StairBlock(() -> ModBlocks.JOHNNY_SINS_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(ModSounds.JOHNNY_SINS_BLOCK_SOUNDS)));
    public static final RegistryObject<Block> JOHNNY_SINS_SLAB = registerBlock("johnny_sins_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(ModSounds.JOHNNY_SINS_BLOCK_SOUNDS)));
    public static final RegistryObject<Block> JOHNNY_SINS_BUTTON = registerBlock("johnny_sins_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(ModSounds.JOHNNY_SINS_BLOCK_SOUNDS),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> JOHNNY_SINS_PRESSURE_PLATE = registerBlock("johnny_sins_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .sound(ModSounds.JOHNNY_SINS_BLOCK_SOUNDS), BlockSetType.IRON));
    public static final RegistryObject<Block> JOHNNY_SINS_FENCE = registerBlock("johnny_sins_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(ModSounds.JOHNNY_SINS_BLOCK_SOUNDS)));
    public static final RegistryObject<Block> JOHNNY_SINS_GATE = registerBlock("johnny_sins_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(ModSounds.JOHNNY_SINS_BLOCK_SOUNDS),
                    ModSounds.JOHNNY_SINS_BLOCK_PLACE.get(), ModSounds.JOHNNY_SINS_BLOCK_PLACE.get()));
    public static final RegistryObject<Block> JOHNNY_SINS_WALL = registerBlock("johnny_sins_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(ModSounds.JOHNNY_SINS_BLOCK_SOUNDS)));
    public static final RegistryObject<Block> JOHNNY_SINS_DOOR= registerBlock("johnny_sins_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(ModSounds.JOHNNY_SINS_BLOCK_SOUNDS),
                    BlockSetType.IRON));
    public static final RegistryObject<Block> JOHNNY_SINS_TRAPDOOR = registerBlock("johnny_sins_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(ModSounds.JOHNNY_SINS_BLOCK_SOUNDS),
                    BlockSetType.OAK));
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
