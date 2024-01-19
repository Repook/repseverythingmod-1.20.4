package repook.repseverythingmod.item.custom;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import repook.repseverythingmod.item.ModArmorMaterials;
import repook.repseverythingmod.item.ModItems;
import repook.repseverythingmod.item.client.PhantomBootsArmorRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class PhantomBootsItem extends ArmorItem implements GeoItem {


    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);
    public PhantomBootsItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private PhantomBootsArmorRenderer renderer;

            @Override
            public BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                        EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
                if (this.renderer == null)
                    this.renderer = new PhantomBootsArmorRenderer();

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);

                return this.renderer;
            }
        });
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        // Check if the player is wearing the custom boots
        if (entity instanceof net.minecraft.entity.player.PlayerEntity &&
                ((net.minecraft.entity.player.PlayerEntity) entity).getEquippedStack(EquipmentSlot.FEET).getItem() instanceof PhantomBootsItem) {
            // Grant slow falling effect
            assert entity instanceof PlayerEntity;
            ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 20, 0, true, false));
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
    @Override
    public Supplier<Object> getRenderProvider() {
        return this.renderProvider;
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("phantom_boots", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
