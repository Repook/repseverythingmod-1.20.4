package repook.repseverythingmod.item.client;

import net.minecraft.item.ArmorItem;
import repook.repseverythingmod.item.custom.PhantomBootsItem;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PhantomBootsArmorRenderer extends GeoArmorRenderer<PhantomBootsItem> {
    public PhantomBootsArmorRenderer() {
        super(new PhantomBootsArmorModel());
    }
}
