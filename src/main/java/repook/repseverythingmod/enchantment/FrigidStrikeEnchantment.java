package repook.repseverythingmod.enchantment;

import net.minecraft.block.PowderSnowBlock;
import net.minecraft.client.particle.Particle;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class FrigidStrikeEnchantment extends Enchantment {
    protected FrigidStrikeEnchantment(Rarity rarity, EnchantmentTarget target, EquipmentSlot... slotTypes) {
        super(rarity, target, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {

        if (getMaxLevel() == 1){
            target.setFrozenTicks(500);
        } else if (getMaxLevel() == 2) {
            target.setFrozenTicks(1000);

        }


        if (target instanceof LivingEntity) {
            ServerWorld world = (ServerWorld) target.getWorld();
            for (int i = 0; i < 10; i++) { // You can adjust the number of particles
                double offsetX = world.random.nextGaussian() * 0.2;
                double offsetY = world.random.nextGaussian() * 1.1;
                double offsetZ = world.random.nextGaussian() * 0.2;
                world.spawnParticles(ParticleTypes.SNOWFLAKE,
                        target.getX() + offsetX, target.getY() + offsetY, target.getZ() + offsetZ,
                        10, 0, 0, 0, 0);
            }
            super.onTargetDamaged(user, target, level);
        }

    }
}
