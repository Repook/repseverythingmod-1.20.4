package repook.repseverythingmod.item.client;

import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;
import repook.repseverythingmod.item.custom.LuckyCatBlockItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class LuckyCatBlockItemRenderer extends GeoItemRenderer<LuckyCatBlockItem> {

    public LuckyCatBlockItemRenderer() {
        super(new LuckyCatBlockItemModel());
    }
}
