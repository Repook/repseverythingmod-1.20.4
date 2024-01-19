package repook.repseverythingmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import repook.repseverythingmod.datagen.ModBlockLootTableGenerator;
import repook.repseverythingmod.datagen.ModModelProvider;
import repook.repseverythingmod.datagen.ModRecipeGenerator;

public class RepsEverythingModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModRecipeGenerator::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockLootTableGenerator::new);
	}
}
