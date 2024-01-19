package repook.repseverythingmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.EntityType;
import repook.repseverythingmod.block.entity.LuckyCatEntity;
import repook.repseverythingmod.block.entity.ModBlockEntities;
import repook.repseverythingmod.block.entity.client.LuckyCatRenderer;
import repook.repseverythingmod.entity.ModEntities;
import repook.repseverythingmod.entity.client.ErodedRenderer;

public class RepsEverythingModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntities.LUCKY_CAT_ENTITY, LuckyCatRenderer::new);

        EntityRendererRegistry.register(ModEntities.ERODED, ErodedRenderer::new);
    }
}
