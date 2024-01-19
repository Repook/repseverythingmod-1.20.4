package repook.repseverythingmod.item.client;

import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;
import repook.repseverythingmod.item.custom.PhantomBootsItem;
import software.bernie.geckolib.model.GeoModel;

public class PhantomBootsArmorModel extends GeoModel<PhantomBootsItem> {
    @Override
    public Identifier getModelResource(PhantomBootsItem animatable) {
        return new Identifier(RepsEverythingMod.MOD_ID, "geo/phantom_boots.geo.json");
    }

    @Override
    public Identifier getTextureResource(PhantomBootsItem animatable) {
        return new Identifier(RepsEverythingMod.MOD_ID, "textures/armor/phantom_boots.png");
    }

    @Override
    public Identifier getAnimationResource(PhantomBootsItem animatable) {
        return new Identifier(RepsEverythingMod.MOD_ID, "animations/phantom_boots.animation.json");
    }
}
