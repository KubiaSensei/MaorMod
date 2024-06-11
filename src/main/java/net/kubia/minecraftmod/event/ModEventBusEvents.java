package net.kubia.minecraftmod.event;

import net.kubia.minecraftmod.MinecraftMod;
import net.kubia.minecraftmod.entity.ModEntities;
import net.kubia.minecraftmod.entity.custom.JohnnySinsEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MinecraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.JOHNNY_SINS.get(), JohnnySinsEntity.createAttributes().build());
    }
}
