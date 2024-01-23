package repook.repseverythingmod.item.custom;

import net.minecraft.block.CarrotsBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import repook.repseverythingmod.block.ModBlocks;
import repook.repseverythingmod.block.custom.ConchShellBlock;
import repook.repseverythingmod.sound.ModSounds;

public class ConchShellItem extends Item {
    int cooldown;


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
            world.setBlockState(blockPos, ModBlocks.CONCH_SHELL.getDefaultState());

            // Decrease the item stack count
            if (player != null && !player.isCreative()) {
                context.getStack().decrement(1);
            }

            // Play a sound or perform other actions as needed
            world.playSound(player, blockPos, SoundEvents.BLOCK_GLASS_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);

            return ActionResult.success(world.isClient());
        }

        return super.useOnBlock(context);
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
