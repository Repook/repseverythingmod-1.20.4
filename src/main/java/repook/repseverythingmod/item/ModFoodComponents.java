package repook.repseverythingmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;


public class ModFoodComponents {


    public static final FoodComponent GOLDEN_BEETROOT = new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2400, 0), 1.0F).build();

    public static final FoodComponent ENCHANTED_GOLDEN_BEETROOT = new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 4800, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 4800, 1), 1.0F).build();

    public static final FoodComponent GOLDEN_SWEET_BERRIES = new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2400, 0), 1.0F).build();

    public static final FoodComponent ENCHANTED_GOLDEN_SWEET_BERRIES = new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 4800, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 4800, 1), 1.0F).build();

    public static final FoodComponent GOLDEN_ROTTEN_FLESH = new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 4800, 0), 1.0F).build();

    public static final FoodComponent ENCHANTED_GOLDEN_ROTTEN_FLESH = new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 9600, 1), 1.0F).build();

    public static final FoodComponent ENCHANTED_GOLDEN_CARROT = new FoodComponent.Builder().alwaysEdible().hunger(7).saturationModifier(1.4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 1.0F).build();
}
