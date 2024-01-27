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
import repook.repseverythingmod.entity.custom.ScarecrowEntity;
import repook.repseverythingmod.item.ModItemGroup;
import repook.repseverythingmod.item.ModItems;
import repook.repseverythingmod.particle.ModParticles;
import repook.repseverythingmod.potion.ModPotions;
import repook.repseverythingmod.sound.ModSounds;
import repook.repseverythingmod.util.ModLootTableModifiers;
import repook.repseverythingmod.util.ModRegistries;
import software.bernie.geckolib.GeckoLib;

public class RepsEverythingMod implements ModInitializer {
	public static final String MOD_ID = "repseverythingmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModSounds.registerSounds();
		ModItemGroup.registerItemGroup();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerAllBlockEntities();
		ModEnchantments.registerModEnchantments();
		ModPotions.registerPotions();

		GeckoLib.initialize();
		ModParticles.registerParticles();

		FabricDefaultAttributeRegistry.register(ModEntities.ERODED, ErodedEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SCARECROW, ScarecrowEntity.setAttributes());


		ModLootTableModifiers.modifyLootTables();
		ModRegistries.registerModStuffs();
	}

}