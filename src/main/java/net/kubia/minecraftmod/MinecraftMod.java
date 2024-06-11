package net.kubia.minecraftmod;

import com.mojang.logging.LogUtils;
import net.kubia.minecraftmod.block.ModBlocks;
import net.kubia.minecraftmod.entity.ModEntities;
import net.kubia.minecraftmod.entity.client.JohnnySinsRenderer;
import net.kubia.minecraftmod.item.ModCreativeModTabs;
import net.kubia.minecraftmod.item.ModItems;
import net.kubia.minecraftmod.painting.ModPaintings;
import net.kubia.minecraftmod.sound.ModSounds;
import net.kubia.minecraftmod.worldgen.biome.ModTerrablender;
import net.kubia.minecraftmod.worldgen.biome.surface.ModSurfaceRules;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

@Mod(MinecraftMod.MOD_ID)
public class MinecraftMod
{
    public static final String MOD_ID = "minecraftmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MinecraftMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
        ModSounds.register(modEventBus);
        ModPaintings.register(modEventBus);
        ModTerrablender.registerBiomes();
        ModEntities.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents


    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.JOHNNY_SINS.get(), JohnnySinsRenderer::new);

        }
    }
}
