package repook.repseverythingmod.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;

public class ModPotions {
    public static final Potion HASTE_POTION = registerPotion("haste_potion",new Potion
            (new StatusEffectInstance(StatusEffects.HASTE,3600,0)));

    public static final Potion STRONG_HASTE_POTION = registerPotion("strong_haste_potion",new Potion
            (new StatusEffectInstance(StatusEffects.HASTE,1800,1)));

    private static Potion registerPotion(String name, Potion potion){
        return Registry.register(Registries.POTION, new Identifier(RepsEverythingMod.MOD_ID, name),potion);
    }

    public static void registerPotions(){
        RepsEverythingMod.LOGGER.info("Registering Potions for" + RepsEverythingMod.MOD_ID);
    }
}
