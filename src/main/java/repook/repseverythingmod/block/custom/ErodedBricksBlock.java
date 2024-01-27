package repook.repseverythingmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import repook.repseverythingmod.block.ModBlocks;

public class ErodedBricksBlock extends Block {

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient && hand == Hand.MAIN_HAND) {
            ItemStack heldItem = player.getStackInHand(hand);

            // Check if the held item is a gold ingot
            if (heldItem.getItem() == Items.GOLD_INGOT) {
                // Replace the block with your desired block
                world.setBlockState(pos, ModBlocks.GILDED_ERODED_BRICKS.getDefaultState());

                // Consume the gold ingot from the player's hand
                if (!player.isCreative()) {
                    heldItem.decrement(1);
                }

                // Do any additional logic or play sound if needed
                world.playSound(pos.getX(),pos.getY(),pos.getZ(),SoundEvents.BLOCK_ANVIL_USE,SoundCategory.BLOCKS,1,1,false);

                return ActionResult.SUCCESS;
            }
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }
    public ErodedBricksBlock(Settings settings) {
        super(settings);
    }
}
