package repook.repseverythingmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.item.BookItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repook.repseverythingmod.block.ModBlocks;
import repook.repseverythingmod.block.entity.ModBlockEntities;
import repook.repseverythingmod.enchantment.ModEnchantments;
import repook.repseverythingmod.entity.ModEntities;
import repook.repseverythingmod.entity.custom.ErodedEntity;
import repook.repseverythingmod.item.ModItemGroup;
import repook.repseverythingmod.item.ModItems;
import software.bernie.geckolib.GeckoLib;

public class RepsEverythingMod implements ModInitializer {
	public static final String MOD_ID = "repseverythingmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroup();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerAllBlockEntities();
		ModEnchantments.registerModEnchantments();

		GeckoLib.initialize();

		FabricDefaultAttributeRegistry.register(ModEntities.ERODED, ErodedEntity.setAttributes());
	}

}