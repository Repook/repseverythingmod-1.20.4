package repook.repseverythingmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import repook.repseverythingmod.datagen.*;

public class RepsEverythingModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModRecipeGenerator::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockLootTableGenerator::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModAdvancementProvider::new);
	}
}
