package repook.repseverythingmod.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.WritableBookItem;

public class FrostEnchantment extends Enchantment {
    protected FrostEnchantment(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        target.setFrozenTicks(500);
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
