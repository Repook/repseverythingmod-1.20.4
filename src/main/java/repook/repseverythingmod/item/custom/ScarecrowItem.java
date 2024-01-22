package repook.repseverythingmod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import repook.repseverythingmod.entity.ModEntities;
import repook.repseverythingmod.entity.custom.ScarecrowEntity;

import java.util.Objects;
import java.util.function.Consumer;

public class ScarecrowItem extends Item {
    public ScarecrowItem(Settings settings) {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        Direction direction = context.getSide();
        if (direction == Direction.DOWN) {
            return ActionResult.FAIL;
        } else {
            World world = context.getWorld();
            ItemPlacementContext itemPlacementContext = new ItemPlacementContext(context);
            BlockPos blockPos = itemPlacementContext.getBlockPos();
            ItemStack itemStack = context.getStack();
            Vec3d vec3d = Vec3d.ofBottomCenter(blockPos);
            Box box = EntityType.ARMOR_STAND.getDimensions().getBoxAt(vec3d.getX(), vec3d.getY(), vec3d.getZ());
            if (world.isSpaceEmpty((Entity)null, box) && world.getOtherEntities((Entity)null, box).isEmpty()) {
                if (world instanceof ServerWorld serverWorld) {
                    Consumer<ScarecrowEntity> consumer = EntityType.copier(serverWorld, itemStack, context.getPlayer());
                    ScarecrowEntity scarecrowEntity = (ScarecrowEntity) ModEntities.SCARECROW.create(serverWorld, itemStack.getNbt(), consumer, blockPos, SpawnReason.SPAWN_EGG, true, true);
                    if (scarecrowEntity != null) {
                        // Calculate the yaw rotation to make the scarecrow face the player
                        double playerX = Objects.requireNonNull(context.getPlayer()).getX();
                        double playerZ = context.getPlayer().getZ();
                        double angle = Math.atan2(scarecrowEntity.getZ() - playerZ, scarecrowEntity.getX() - playerX);
                        float yaw = (float) Math.toDegrees(angle);

                        // Set the rotation of the scarecrow entity
                        scarecrowEntity.refreshPositionAndAngles(scarecrowEntity.getX(), scarecrowEntity.getY(), scarecrowEntity.getZ(), yaw, 0.0F);

                        serverWorld.spawnEntityAndPassengers(scarecrowEntity);
                        world.playSound((PlayerEntity) null, scarecrowEntity.getX(), scarecrowEntity.getY(), scarecrowEntity.getZ(),
                                SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS, 0.75F, 0.8F);
                        scarecrowEntity.emitGameEvent(GameEvent.ENTITY_PLACE, context.getPlayer());
                    }

/*                    float f = (float) MathHelper.floor((MathHelper.wrapDegrees(context.getPlayerYaw() - 180.0F) + 22.5F) / 45.0F) * 45.0F;
                    scarecrowEntity.refreshPositionAndAngles(scarecrowEntity.getX(), scarecrowEntity.getY(), scarecrowEntity.getZ(), f, 0.0F);
                    serverWorld.spawnEntityAndPassengers(scarecrowEntity);
                    world.playSound((PlayerEntity)null, scarecrowEntity.getX(), scarecrowEntity.getY(), scarecrowEntity.getZ(), SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS, 0.75F, 0.8F);
                    scarecrowEntity.emitGameEvent(GameEvent.ENTITY_PLACE, context.getPlayer());*/
                }

                itemStack.decrement(1);
                return ActionResult.success(world.isClient);
            } else {
                return ActionResult.FAIL;
            }
        }
    }
}
