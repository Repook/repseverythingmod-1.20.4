package repook.repseverythingmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import repook.repseverythingmod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider{
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.ERODED_BRICK_WALL,ModBlocks.GILDED_ERODED_BRICK_WALL);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ERODED_BRICKS,
                        ModBlocks.GILDED_ERODED_BRICKS,
                        ModBlocks.ERODED_BRICK_STAIRS,
                        ModBlocks.GILDED_ERODED_BRICK_STAIRS,
                        ModBlocks.ERODED_BRICK_SLAB,
                        ModBlocks.GILDED_ERODED_BRICK_SLAB,
                        ModBlocks.ERODED_BRICK_WALL,
                        ModBlocks.GILDED_ERODED_BRICK_WALL,
                        ModBlocks.CHISELED_ERODED_BRICKS,
                        ModBlocks.GILDED_CHISELED_ERODED_BRICKS,
                        ModBlocks.ERODED_BRICK_PILLAR,
                        ModBlocks.GILDED_ERODED_BRICK_PILLAR
                        );

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.STRAW_BLOCK);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.CRATE);
    }
}
