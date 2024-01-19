package repook.repseverythingmod.block.entity.client;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import repook.repseverythingmod.block.entity.LuckyCatEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class LuckyCatRenderer extends GeoBlockRenderer<LuckyCatEntity> {
    public LuckyCatRenderer(BlockEntityRendererFactory.Context ctx) {
        super(new LuckyCatModel());
    }
}
