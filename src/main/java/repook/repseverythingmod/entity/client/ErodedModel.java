package repook.repseverythingmod.entity.client;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import repook.repseverythingmod.RepsEverythingMod;
import repook.repseverythingmod.entity.custom.ErodedEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ErodedModel extends GeoModel<ErodedEntity> {
    @Override
    public Identifier getModelResource(ErodedEntity animatable) {
        return new Identifier(RepsEverythingMod.MOD_ID, "geo/eroded.geo.json");
    }

    @Override
    public Identifier getTextureResource(ErodedEntity animatable) {
        return new Identifier(RepsEverythingMod.MOD_ID, "textures/entity/eroded.png");
    }

    @Override
    public Identifier getAnimationResource(ErodedEntity animatable) {
        return new Identifier(RepsEverythingMod.MOD_ID, "animations/eroded.animation.json");
    }
    @Override
    public void setCustomAnimations(ErodedEntity animatable, long instanceId, AnimationState<ErodedEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
