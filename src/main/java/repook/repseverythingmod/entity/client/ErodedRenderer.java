package repook.repseverythingmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.PufferfishEntity;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.entity.custom.ErodedEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ErodedRenderer extends GeoEntityRenderer<ErodedEntity> {


    private final GeoModel<ErodedEntity> largeModel = this.getGeoModel();
    public ErodedRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new ErodedModel());
    }

    private static final Identifier TEXTURE = new Identifier("repseverythingmod:textures/entity/eroded.png");
    private static final Identifier ANGRY_TEXTURE = new Identifier("repseverythingmod:textures/entity/eroded_mad.png");


    public Identifier getTextureLocation(ErodedEntity animatable) {
        return animatable.isMad() ? ANGRY_TEXTURE : TEXTURE;
    }


}
