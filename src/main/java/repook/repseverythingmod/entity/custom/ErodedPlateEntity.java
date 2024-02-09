package repook.repseverythingmod.entity.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.LlamaEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import repook.repseverythingmod.entity.ModEntities;
import repook.repseverythingmod.particle.ModParticles;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class ErodedPlateEntity extends ProjectileEntity implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public ErodedPlateEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }


    protected ErodedPlateEntity(World world, ErodedEntity owner) {
        this(ModEntities.ERODED_PLATE, world);
        this.setOwner(owner);
        this.setPosition(owner.getX() - (double)(owner.getWidth() + 1.0F) * 0.5 * (double) MathHelper.sin(owner.bodyYaw * 0.017453292F), owner.getEyeY() - 0.10000000149011612, owner.getZ() + (double)(owner.getWidth() + 1.0F) * 0.5 * (double)MathHelper.cos(owner.bodyYaw * 0.017453292F));
    }

    public void tick() {
        super.tick();
        Vec3d vec3d = this.getVelocity();
        HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);
        this.onCollision(hitResult);
        double d = this.getX() + vec3d.x;
        double e = this.getY() + vec3d.y;
        double f = this.getZ() + vec3d.z;
        this.updateRotation();
        float g = 0.99F;
        float h = 0.06F;
        if (this.getWorld().getStatesInBox(this.getBoundingBox()).noneMatch(AbstractBlock.AbstractBlockState::isAir)) {
            this.discard();
        } else if (this.isInsideWaterOrBubbleColumn()) {
            this.discard();
        } else {
            this.setVelocity(vec3d.multiply(0.9900000095367432));
            if (!this.hasNoGravity()) {
                this.setVelocity(this.getVelocity().add(0.0, -0.05999999865889549, 0.0));
            }

            this.setPosition(d, e, f);
        }
    }
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity var3 = this.getOwner();
        if (var3 instanceof LivingEntity livingEntity) {
            entityHitResult.getEntity().damage(this.getDamageSources().mobProjectile(this, livingEntity), 1.0F);
        }

    }

    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (!this.getWorld().isClient) {
            this.discard();
        }

    }




    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        double d = packet.getVelocityX();
        double e = packet.getVelocityY();
        double f = packet.getVelocityZ();

        for(int i = 0; i < 7; ++i) {
            double g = 0.4 + 0.1 * (double)i;
            this.getWorld().addParticle(ModParticles.ERODED_DIRT_PARTICLE, this.getX(), this.getY(), this.getZ(), d * g, e, f * g);
        }

        this.setVelocity(d, e, f);
    }



    @Override
    protected void initDataTracker() {
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }
    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {

            tAnimationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));


        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
