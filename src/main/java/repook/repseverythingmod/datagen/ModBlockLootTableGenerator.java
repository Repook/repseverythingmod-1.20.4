package repook.repseverythingmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import repook.repseverythingmod.block.ModBlocks;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.TRADITIONAL_LANTERN);
        addDrop(ModBlocks.STRAW_BLOCK);
        addDrop(ModBlocks.LUCKY_CAT);
        addDrop(ModBlocks.ERODED_BRICKS);
    }
}
