package repook.repseverythingmod.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;

public class ModEnchantments {
    public static final Enchantment FRIGID_STRIKE = register("frigid_strike",
            new FrigidStrikeEnchantment(Enchantment.Rarity.COMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static final Enchantment FROST = register("frost",
            new FrigidStrikeEnchantment(Enchantment.Rarity.COMMON,
                    EnchantmentTarget.BOW, EquipmentSlot.MAINHAND));


    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(RepsEverythingMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        RepsEverythingMod.LOGGER.info("Registering ModEnchantments for " + RepsEverythingMod.MOD_ID);
    }
}
