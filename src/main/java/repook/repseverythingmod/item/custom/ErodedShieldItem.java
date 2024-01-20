package repook.repseverythingmod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ErodedShieldItem extends ShieldItem {
    // Cooldown in ticks, initially set to 0
    int cooldown = 20 * 5; // 5 seconds cooldown in ticks

    public ErodedShieldItem(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);


        if (player.isSneaking() && cooldown <= 0) {
            // Calculate launch direction based on player's rotation
            double launchSpeed = 2.0; // Adjust the launch speed as needed
            double launchDirectionX = -Math.sin(Math.toRadians(player.getYaw())) * Math.cos(Math.toRadians(player.getPitch()));
            double launchDirectionY = -Math.sin(Math.toRadians(player.getPitch())) * 0.7; // Adjust the scale to reduce vertical launch
            double launchDirectionZ = Math.cos(Math.toRadians(player.getYaw())) * Math.cos(Math.toRadians(player.getPitch()));

            // Launch the player in the calculated direction
            player.addVelocity(launchDirectionX * launchSpeed, launchDirectionY * launchSpeed, launchDirectionZ * launchSpeed);

            cooldown = 20 * 5; // Reset the cooldown after the dash

            return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
        }

        return super.use(world, player, hand);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (cooldown > 0) {
            cooldown--;
        }
    }
}









