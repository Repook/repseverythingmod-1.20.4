package repook.repseverythingmod.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;
import repook.repseverythingmod.entity.custom.ErodedEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ErodedRenderer extends GeoEntityRenderer<ErodedEntity> {
    public ErodedRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new ErodedModel());


    }


    public Identifier getTextureLocation(ErodedEntity animatable) {
            return new Identifier(RepsEverythingMod.MOD_ID, "textures/entity/eroded.png");
    }
}
