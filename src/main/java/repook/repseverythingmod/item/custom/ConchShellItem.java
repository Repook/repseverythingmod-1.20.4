package repook.repseverythingmod.item.custom;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import repook.repseverythingmod.block.ModBlocks;
import repook.repseverythingmod.block.custom.ConchShellBlock;
import repook.repseverythingmod.block.custom.LuckyCatBlock;
import repook.repseverythingmod.sound.ModSounds;


public class ConchShellItem extends Item {




    int cooldown;
    public static DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if(user.isSneaking()){
            world.playSound(user,user.getX(),user.getY(),user.getZ(), ModSounds.ITEM_CONCH_SHELL, SoundCategory.PLAYERS);

            user.setCurrentHand(hand);
            cooldown = 20 * 15;
            user.getItemCooldownManager().set(this, cooldown);}

        return super.use(world, user, hand);

    }




    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        BlockPos blockPos = context.getBlockPos().offset(context.getSide());

        // Check if the player can place the custom conch shell at the targeted block
        if (world.getBlockState(blockPos).isReplaceable() && ModBlocks.CONCH_SHELL.getDefaultState().canPlaceAt(world, blockPos)) {
            // Place the custom conch shell block
            float yaw = MathHelper.wrapDegrees(player.getYaw() + 270.0F);

            // Place the custom conch shell block with the calculated rotation
            world.setBlockState(blockPos, ModBlocks.CONCH_SHELL.getDefaultState().with(FACING, getFacingFromYaw(yaw)));

            // Decrease the item stack count
            if (!player.isCreative()) {
                context.getStack().decrement(1);
            }

            // Play a sound or perform other actions as needed
            world.playSound(player, blockPos, SoundEvents.BLOCK_GLASS_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);

            return ActionResult.success(world.isClient());
        }

        return super.useOnBlock(context);
    }

    private Direction getFacingFromYaw(float yaw) {
        return Direction.fromRotation(yaw);
    }


    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.TOOT_HORN;
    }
    public int getMaxUseTime(ItemStack stack) {
        return 80000;
    }


    public ConchShellItem(Settings settings) {
        super(settings);
    }
}
