package net.kubia.minecraftmod.entity;

import net.kubia.minecraftmod.MinecraftMod;
import net.kubia.minecraftmod.entity.custom.JohnnySinsEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.swing.text.html.parser.Entity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MinecraftMod.MOD_ID);


    public static final RegistryObject<EntityType> JOHNNY_SINS =
            ENTITY_TYPES.register("johnny_sins", () -> EntityType.Builder.of(JohnnySinsEntity::new, MobCategory.MONSTER)
                    .sized(1f, 2f).build("johnny_sins"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
