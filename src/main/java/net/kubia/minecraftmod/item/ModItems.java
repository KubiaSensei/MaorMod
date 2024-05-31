package net.kubia.minecraftmod.item;

import net.kubia.minecraftmod.MinecraftMod;
import net.kubia.minecraftmod.item.custom.ModArmorItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MinecraftMod.MOD_ID);

    //Tools
    public static final RegistryObject<Item> JOHNNY_SINS_INGOT = ITEMS.register("johnny_sins_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JOHNNY_SINS_SWORD = ITEMS.register("johnny_sins_sword",
            () -> new SwordItem(ModToolTiers.JOHNNY_SINS, 500, 40, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JOHNNY_SINS_PICKAXE = ITEMS.register("johnny_sins_pickaxe",
            () -> new PickaxeItem(ModToolTiers.JOHNNY_SINS, 500, 40, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JOHNNY_SINS_AXE = ITEMS.register("johnny_sins_axe",
            () -> new AxeItem(ModToolTiers.JOHNNY_SINS, 500, 40, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JOHNNY_SINS_SHOVEL = ITEMS.register("johnny_sins_shovel",
            () -> new ShovelItem(ModToolTiers.JOHNNY_SINS, 500, 40, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JOHNNY_SINS_HOE = ITEMS.register("johnny_sins_hoe",
            () -> new HoeItem(ModToolTiers.JOHNNY_SINS, 500, 40, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JOHNNY_SINS_HELMET = ITEMS.register("johnny_sins_helmet",
            () -> new ModArmorItem(ModArmorMaterials.JOHNNY_SINS, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JOHNNY_SINS_CHESTPLATE = ITEMS.register("johnny_sins_chestplate",
            () -> new ArmorItem(ModArmorMaterials.JOHNNY_SINS, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JOHNNY_SINS_LEGGINGS = ITEMS.register("johnny_sins_leggings",
            () -> new ArmorItem(ModArmorMaterials.JOHNNY_SINS, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JOHNNY_SINS_BOOTS = ITEMS.register("johnny_sins_boots",
            () -> new ArmorItem(ModArmorMaterials.JOHNNY_SINS, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}