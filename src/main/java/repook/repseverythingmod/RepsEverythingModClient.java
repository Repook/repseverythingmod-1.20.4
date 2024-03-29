package repook.repseverythingmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.ModelIdentifier;
import repook.repseverythingmod.block.ModBlocks;
import repook.repseverythingmod.block.entity.ModBlockEntities;
import repook.repseverythingmod.block.entity.client.LuckyCatRenderer;
import repook.repseverythingmod.entity.ModEntities;
import repook.repseverythingmod.entity.client.ErodedPlateRenderer;
import repook.repseverythingmod.entity.client.ErodedRenderer;
import repook.repseverythingmod.entity.client.ScarecrowModel;
import repook.repseverythingmod.entity.client.ScarecrowRenderer;
import repook.repseverythingmod.entity.layer.ModModelLayers;
import repook.repseverythingmod.particle.ErodedDirtParticle;
import repook.repseverythingmod.particle.ModParticles;
import repook.repseverythingmod.util.ModModelPredicateProvider;

public class RepsEverythingModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntities.LUCKY_CAT_ENTITY, LuckyCatRenderer::new);

        EntityRendererRegistry.register(ModEntities.ERODED, ErodedRenderer::new);

        ModModelPredicateProvider.registerModModels();

        EntityRendererRegistry.register(ModEntities.ERODED_PLATE, ErodedPlateRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.ERODED_DIRT_PARTICLE, ErodedDirtParticle.Factory :: new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRAW_BLOCK, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SCARECROW, ScarecrowModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SCARECROW, ScarecrowRenderer::new);


        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> new ModelIdentifier(RepsEverythingMod.MOD_ID,"conch_shell_3d","inventory"));

    }
}
