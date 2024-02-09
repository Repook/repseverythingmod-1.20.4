package repook.repseverythingmod.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.entity.custom.ErodedEntity;
import repook.repseverythingmod.entity.custom.ErodedPlateEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ErodedPlateRenderer extends GeoEntityRenderer<ErodedPlateEntity> {
    public ErodedPlateRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new ErodedPlateModel());
    }

    private static final Identifier TEXTURE = new Identifier("repseverythingmod:textures/entity/eroded.png");


    @Override
    public Identifier getTextureLocation(ErodedPlateEntity animatable) {
        return TEXTURE;
    }
}
