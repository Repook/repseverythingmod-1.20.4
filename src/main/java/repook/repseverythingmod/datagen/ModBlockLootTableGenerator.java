package repook.repseverythingmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import repook.repseverythingmod.block.ModBlocks;
import repook.repseverythingmod.item.ModItems;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.TRADITIONAL_LANTERN);
        addDrop(ModBlocks.ERODED_BRICKS);
        addDrop(ModBlocks.ERODED_BRICK_SLAB);
        addDrop(ModBlocks.ERODED_BRICK_WALL);
        addDrop(ModBlocks.ERODED_BRICK_STAIRS);
        addDrop(ModBlocks.CHISELED_ERODED_BRICKS);
        addDrop(ModBlocks.ERODED_BRICK_PILLAR);
        addDrop(ModBlocks.GILDED_CHISELED_ERODED_BRICKS);
        addDrop(ModBlocks.GILDED_ERODED_BRICK_PILLAR);
        addDrop(ModBlocks.CRATE);

        addDrop(ModBlocks.CONCH_SHELL, ModItems.CONCH_SHELL);
    }
}
