package repook.repseverythingmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class ErodedEntity extends HostileEntity implements GeoEntity {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    public ErodedEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 16.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75f, 1));

        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));

    }

    @Override
    public void tick() {
        super.tick();

        spawnRandomParticlesAtFeet(this.getWorld());
    }
    private void spawnRandomParticlesAtFeet(World world) {
        if (world.isClient) { // Make sure you are on the client side
            double x = getX();
            double y = getY();
            double z = getZ();

            // Adjust the particle spawn position based on the entity size
            double yOffset = getHeight() / 9.0;

            Random random = world.random;

            for (int i = 0; i < 5; i++) { // Spawn 5 particles in a random pattern
                double offsetX = random.nextGaussian() * 0.2;
                double offsetY = random.nextGaussian() * 0.1;
                double offsetZ = random.nextGaussian() * 0.2;

                double velocityX = random.nextGaussian() * 0.02;
                double velocityY = random.nextGaussian() * 0.02;
                double velocityZ = random.nextGaussian() * 0.02;

                // Spawn particles at the entity's feet with random offsets and velocities
                world.addParticle(ParticleTypes.DUST_PLUME, x + offsetX, y + 0.5f + offsetY, z + offsetZ, velocityX, velocityY, velocityZ);
            }
        }
    }

    private <T extends GeoAnimatable>PlayState predicate(AnimationState<T> tAnimationState) {
        if(tAnimationState.isMoving()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.eroded.idle", Animation.LoopType.LOOP));
        }

        tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.eroded.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
