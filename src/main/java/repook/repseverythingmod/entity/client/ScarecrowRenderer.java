package repook.repseverythingmod.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;
import repook.repseverythingmod.entity.custom.ScarecrowEntity;
import repook.repseverythingmod.entity.layer.ModModelLayers;

public class ScarecrowRenderer extends MobEntityRenderer<ScarecrowEntity,ScarecrowModel<ScarecrowEntity>> {

    private static final Identifier TEXTURE = new Identifier(RepsEverythingMod.MOD_ID,"textures/entity/scarecrow.png");
    public ScarecrowRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ScarecrowModel<>(ctx.getPart(ModModelLayers.SCARECROW)), 0.6f);
    }

    @Override
    public Identifier getTexture(ScarecrowEntity entity) {
        return TEXTURE;
    }
}
