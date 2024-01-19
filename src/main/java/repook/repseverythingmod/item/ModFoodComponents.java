package repook.repseverythingmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;


public class ModFoodComponents {


    public static final FoodComponent GOLDEN_BEETROOT = new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2400, 1), 1.0F).build();

    public static final FoodComponent GOLDEN_SWEET_BERRIES = new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2400, 0), 1.0F).build();

    public static final FoodComponent GOLDEN_ROTTEN_FLESH = new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 4800, 0), 1.0F).build();

}
