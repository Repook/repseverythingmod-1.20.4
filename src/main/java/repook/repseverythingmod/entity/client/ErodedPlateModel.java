package repook.repseverythingmod.entity.client;

import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;
import repook.repseverythingmod.entity.custom.ErodedEntity;
import repook.repseverythingmod.entity.custom.ErodedPlateEntity;
import software.bernie.geckolib.model.GeoModel;

public class ErodedPlateModel extends GeoModel<ErodedPlateEntity> {
    @Override
    public Identifier getModelResource(ErodedPlateEntity animatable) {
        return new Identifier(RepsEverythingMod.MOD_ID, "geo/eroded_plate.geo.json");
    }

    @Override
    public Identifier getTextureResource(ErodedPlateEntity animatable) {
        return new Identifier(RepsEverythingMod.MOD_ID, "textures/entity/eroded.png");
    }

    @Override
    public Identifier getAnimationResource(ErodedPlateEntity animatable) {
        return new Identifier(RepsEverythingMod.MOD_ID, "animations/eroded_plate.animation.json");
    }
}
