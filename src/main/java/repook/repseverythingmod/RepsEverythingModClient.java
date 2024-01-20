package repook.repseverythingmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import repook.repseverythingmod.block.ModBlocks;
import repook.repseverythingmod.block.entity.ModBlockEntities;
import repook.repseverythingmod.block.entity.client.LuckyCatRenderer;
import repook.repseverythingmod.entity.ModEntities;
import repook.repseverythingmod.entity.client.ErodedRenderer;
import repook.repseverythingmod.particle.ErodedDirtParticle;
import repook.repseverythingmod.particle.ModParticles;
import repook.repseverythingmod.util.ModModelPredicateProvider;

public class RepsEverythingModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntities.LUCKY_CAT_ENTITY, LuckyCatRenderer::new);

        EntityRendererRegistry.register(ModEntities.ERODED, ErodedRenderer::new);
        ModModelPredicateProvider.registerModModels();

        ParticleFactoryRegistry.getInstance().register(ModParticles.ERODED_DIRT_PARTICLE, ErodedDirtParticle.Factory :: new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRAW_BLOCK, RenderLayer.getCutout());




    }
}
