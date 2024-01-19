package repook.repseverythingmod.item.client;

import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;
import repook.repseverythingmod.item.custom.LuckyCatBlockItem;
import software.bernie.geckolib.model.GeoModel;

public class LuckyCatBlockItemModel extends GeoModel<LuckyCatBlockItem> {
    @Override
    public Identifier getModelResource(LuckyCatBlockItem animatable) {
        return new Identifier(RepsEverythingMod.MOD_ID, "geo/lucky_cat.geo.json");
    }

    @Override
    public Identifier getTextureResource(LuckyCatBlockItem animatable) {
        return new Identifier(RepsEverythingMod.MOD_ID, "textures/block/lucky_cat.png");
    }

    @Override
    public Identifier getAnimationResource(LuckyCatBlockItem animatable) {
        return new Identifier(RepsEverythingMod.MOD_ID, "animations/lucky_cat.animation.json");
    }
}
