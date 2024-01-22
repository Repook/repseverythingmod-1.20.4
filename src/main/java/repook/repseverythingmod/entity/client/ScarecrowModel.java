package repook.repseverythingmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import repook.repseverythingmod.entity.custom.ScarecrowEntity;

public class ScarecrowModel<T extends ScarecrowEntity> extends EntityModel<T> {
    private final ModelPart Hat;

    private final ModelPart Clothes;

    private final ModelPart Poles;

    private final ModelPart bb_main;

    public ScarecrowModel(ModelPart root) {
        this.Hat = root.getChild("Hat");
        this.Clothes = root.getChild("Clothes");
        this.Poles = root.getChild("Poles");
        this.bb_main = root.getChild("bb_main");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Hat = modelPartData.addChild("Hat", ModelPartBuilder.create(), ModelTransform.of(-1.0F, 3.25F, 0.0F, 0.0436F, 0.0F, -0.0436F));

        ModelPartData Head_r1 = Hat.addChild("Head_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-4.75F, -10.0F, -3.0F, 10.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0441F, -0.0113F, 0.088F));

        ModelPartData Rim = Hat.addChild("Rim", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Head_r2 = Rim.addChild("Head_r2", ModelPartBuilder.create().uv(0, 31).cuboid(-5.0F, -8.0F, 7.0F, 10.0F, 0.0F, 1.0F, new Dilation(0.0F))
                .uv(31, 18).cuboid(-5.0F, -8.0F, -4.0F, 10.0F, 0.0F, 1.0F, new Dilation(0.0F))
                .uv(28, 0).cuboid(-6.0F, -8.0F, -4.0F, 1.0F, 0.0F, 12.0F, new Dilation(0.0F))
                .uv(30, 0).cuboid(5.0F, -8.0F, -4.0F, 1.0F, 0.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0441F, -0.0113F, 0.088F));

        ModelPartData Clothes = modelPartData.addChild("Clothes", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 3.5F, 0.0F));

        ModelPartData Body_r1 = Clothes.addChild("Body_r1", ModelPartBuilder.create().uv(0, 12).cuboid(-5.0F, -13.0F, -3.0F, 10.0F, 13.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 11.5F, 0.75F, -0.1309F, 0.0F, -0.0436F));

        ModelPartData ARM_r1 = Clothes.addChild("ARM_r1", ModelPartBuilder.create().uv(26, 12).cuboid(-9.0F, 0.0F, 0.25F, 10.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3626F, -0.2336F, -0.3883F));

        ModelPartData ARM_r2 = Clothes.addChild("ARM_r2", ModelPartBuilder.create().uv(0, 36).cuboid(-1.0F, 0.0F, 0.5F, 10.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(9.5F, 0.25F, 0.0F, 0.4305F, -0.0735F, 0.2457F));

        ModelPartData Poles = modelPartData.addChild("Poles", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData Pole_r1 = Poles.addChild("Pole_r1", ModelPartBuilder.create().uv(26, 39).cuboid(-1.0F, -22.0F, -1.0F, 2.0F, 22.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

        ModelPartData Pole_r2 = Poles.addChild("Pole_r2", ModelPartBuilder.create().uv(26, 39).cuboid(-1.2738F, -0.6479F, -2.7975F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -21.25F, 3.75F, 0.0772F, 0.1742F, -1.3612F));

        ModelPartData Pole_r3 = Poles.addChild("Pole_r3", ModelPartBuilder.create().uv(26, 39).cuboid(-1.7738F, 1.1021F, -2.2975F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -21.25F, 3.75F, -0.1119F, -0.2816F, 1.2582F));

        ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData Head_r3 = bb_main.addChild("Head_r3", ModelPartBuilder.create().uv(24, 23).cuboid(-4.0F, -8.0F, -2.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -21.0F, 0.0F, 0.0441F, -0.0113F, 0.088F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        Hat.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        Clothes.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        Poles.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }


}