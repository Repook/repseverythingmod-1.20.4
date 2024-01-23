package repook.repseverythingmod.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorStandItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.Arm;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.EulerAngle;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import repook.repseverythingmod.block.custom.StrawBlock;

public class ScarecrowEntity extends MobEntity {
    private EulerAngle bodyRotation;
    private static final EulerAngle DEFAULT_BODY_ROTATION = new EulerAngle(0.0F, 0.0F, 0.0F);

    public static final TrackedData<EulerAngle> TRACKER_BODY_ROTATION;






    @Override
    public boolean isMobOrPlayer() {
        return false;
    }


    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        //this.dataTracker.startTracking(TRACKER_BODY_ROTATION, DEFAULT_BODY_ROTATION);
    }

    @Override
    public boolean isPersistent() {
        return true;
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 1.0D);
    }

    public void setBodyRotation(EulerAngle angle) {
        this.bodyRotation = angle;
        this.dataTracker.set(TRACKER_BODY_ROTATION, angle);
    }

    @Override
    public void tick() {
        super.tick();
/*        EulerAngle eulerAngle2 = this.dataTracker.get(TRACKER_BODY_ROTATION);
        if (!this.bodyRotation.equals(eulerAngle2)) {
            this.setBodyRotation(eulerAngle2);
        }*/
    }



    public EulerAngle getBodyRotation() {
        return this.bodyRotation;
    }

    @Override
    public boolean isPushable() {
            return false;
    }

    @Override
    public boolean canMoveVoluntarily() {
        return false;
    }

    public ScarecrowEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
        this.bodyRotation = DEFAULT_BODY_ROTATION;
    }

    static {
        TRACKER_BODY_ROTATION = DataTracker.registerData(ArmorStandEntity.class, TrackedDataHandlerRegistry.ROTATION);
    }
}
