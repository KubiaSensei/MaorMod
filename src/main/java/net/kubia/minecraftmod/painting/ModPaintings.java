package net.kubia.minecraftmod.painting;

import net.kubia.minecraftmod.MinecraftMod;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANT =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, MinecraftMod.MOD_ID);

    public static final RegistryObject<PaintingVariant> TURTLES = PAINTING_VARIANT.register("turtles",
            () -> new PaintingVariant(160, 160));
    public static final RegistryObject<PaintingVariant> DADDYSINS = PAINTING_VARIANT.register("daddysins",
            () -> new PaintingVariant(160, 160));


    public static void register(IEventBus eventBus) {
        PAINTING_VARIANT.register(eventBus);
    }
}
