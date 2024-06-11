package net.kubia.minecraftmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.kubia.minecraftmod.MinecraftMod;
import net.kubia.minecraftmod.entity.ModEntities;
import net.kubia.minecraftmod.entity.custom.JohnnySinsEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class JohnnySinsRenderer extends MobRenderer<JohnnySinsEntity, JohnnySins<JohnnySinsEntity>> {
    public JohnnySinsRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new JohnnySins<>(pContext.bakeLayer(ModModelLayers.JOHNNY_SINS_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(JohnnySinsEntity johnnySinsEntity) {
        return new ResourceLocation(MinecraftMod.MOD_ID, "textures/entity/johnny_sins.png");
    }


    @Override
    public void render(JohnnySinsEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
