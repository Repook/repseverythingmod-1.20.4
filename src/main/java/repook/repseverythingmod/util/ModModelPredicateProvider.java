package repook.repseverythingmod.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.item.ModItems;

public class ModModelPredicateProvider {
    public static void registerModModels() {

        ModelPredicateProviderRegistry.register(ModItems.ERODED_SHIELD, new Identifier("blocking"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f);
    }
}
