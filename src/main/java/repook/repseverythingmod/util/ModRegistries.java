package repook.repseverythingmod.util;

import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import repook.repseverythingmod.item.ModItems;
import repook.repseverythingmod.mixin.BrewingRecipeRegistryMixin;
import repook.repseverythingmod.potion.ModPotions;

public class ModRegistries {

    public static void registerModStuffs(){
        registerPotionRecipes();
    }
    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.ERODED_FRAGMENT, ModPotions.HASTE_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.HASTE_POTION, Items.GLOWSTONE, ModPotions.STRONG_HASTE_POTION);
    }
}
