package repook.repseverythingmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.LlamaEntity;
import net.minecraft.entity.passive.PufferfishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.LlamaSpitEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import repook.repseverythingmod.entity.ModEntities;
import repook.repseverythingmod.particle.ModParticles;
import repook.repseverythingmod.sound.ModSounds;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class ErodedEntity extends HostileEntity implements GeoEntity, RangedAttackMob {

    private static final TrackedData<Integer> STACK_STATE;

    private static final TrackedData<Boolean> MAD;




    public ErodedEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }



    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);


    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 16.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f);
    }


    public boolean isMad() {
        return (Boolean)this.dataTracker.get(MAD);
    }

    public void setMad(boolean shooting) {
        this.dataTracker.set(MAD, shooting);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        //this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(2, new ProjectileAttackGoal(this, 1,40,40,20));

        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));

    }

    @Override
    public boolean isPersistent() {
        return true;
    }

    private <T extends GeoAnimatable>PlayState predicate(AnimationState<T> tAnimationState) {
        if(tAnimationState.isMoving()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.eroded.idle", Animation.LoopType.LOOP));
        }

        tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.eroded.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }



    @Override
    public void tick() {
        super.tick();
        spawnRandomParticlesAtFeet(this.getWorld());

        if (!this.getWorld().isClient) {
            // Check if the entity is below half health
            if (this.getHealth() <= this.getMaxHealth() / 2 && !this.hasStatusEffect(StatusEffects.STRENGTH)) {
                // Apply strength effect
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, Integer.MAX_VALUE, 0, false, false));
                this.setMad(true);

                // Switch textures or perform other actions when health is below half

            }
        }
    }
    


    private void spawnRandomParticlesAtFeet(World world) {
        if (world.isClient) { // Make sure you are on the client side
            double x = getX();
            double y = getY();
            double z = getZ();

            // Adjust the particle spawn position based on the entity size
            double yOffset = getHeight() / 3; // Set yOffset to half of the entity height

            Random random = world.random;

            for (int i = 0; i < 3; i++) { // Spawn 3 particles in a spiral pattern
                double angle = random.nextDouble() * Math.PI * 2.0; // Random angle for spiral
                double radius = random.nextDouble() * 0.5 + 0.5; // Random radius for spiral (starting from 0.5)

                double offsetX = radius * Math.cos(angle);
                double offsetY = random.nextGaussian() * 0.1;
                double offsetZ = radius * Math.sin(angle);

                double velocityX = -offsetZ * 0.5; // Adjust X velocity for the spiral effect
                double velocityY = offsetY * 0.8; // Adjust Y velocity for upward movement
                double velocityZ = offsetX * 0.5; // Adjust Z velocity for the spiral effect

                // Spawn particles at the entity's chest level with random offsets and velocities
                world.addParticle(ModParticles.ERODED_DIRT_PARTICLE, x + offsetX, y + yOffset + offsetY, z + offsetZ, velocityX, velocityY, velocityZ);
            }
        }
    }


    private void drillAttack(LivingEntity target){


    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(MAD, false);
        //this.dataTracker.startTracking(STACK_STATE, 0);
    }

    static {
        MAD = DataTracker.registerData(GhastEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }


    public int getStackState() {
        return (Integer)this.dataTracker.get(STACK_STATE);
    }

    public void setStackState(int puffState) {
        this.dataTracker.set(STACK_STATE, puffState);
    }

    @Override
    protected void attackLivingEntity(LivingEntity target) {
        this.drillAttack(target);
    }
    private void throwAt(Entity target) {
        ErodedPlateEntity erodedPlateEntity = new ErodedPlateEntity(this.getWorld(),this);
        double d = target.getX() - this.getX();
        double e = target.getBodyY(0.3333333333333333) - erodedPlateEntity.getY();
        double f = target.getZ() - this.getZ();
        double g = Math.sqrt(d * d + f * f) * 0.20000000298023224;
        erodedPlateEntity.setVelocity(d, e + g, f, 1.5F, 10.0F);
        if (!this.isSilent()) {
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_BREEZE_SHOOT, this.getSoundCategory(), 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
        }

        this.getWorld().spawnEntity(erodedPlateEntity);

    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ENTITY_ERODED_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ENTITY_ERODED_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ENTITY_ERODED_DEATH;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }



    static {
        STACK_STATE = DataTracker.registerData(PufferfishEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }

    @Override
    public void shootAt(LivingEntity target, float pullProgress) {
        this.throwAt(target);
    }
}
