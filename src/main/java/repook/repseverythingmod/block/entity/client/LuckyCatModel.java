package repook.repseverythingmod.block.entity.client;

import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;
import repook.repseverythingmod.block.entity.LuckyCatEntity;
import software.bernie.example.client.model.block.GeckoHabitatModel;
import software.bernie.geckolib.model.GeoModel;

public class LuckyCatModel extends GeoModel<LuckyCatEntity> {


    @Override
    public Identifier getModelResource(LuckyCatEntity animatable) {
        return new Identifier(RepsEverythingMod.MOD_ID, "geo/lucky_cat.geo.json");
    }



    @Override
    public Identifier getTextureResource(LuckyCatEntity animatable) {
        return new Identifier(RepsEverythingMod.MOD_ID, "textures/block/lucky_cat.png");
    }

    @Override
    public Identifier getAnimationResource(LuckyCatEntity animatable) {
        return new Identifier(RepsEverythingMod.MOD_ID, "animations/lucky_cat.animation.json");
    }
}
