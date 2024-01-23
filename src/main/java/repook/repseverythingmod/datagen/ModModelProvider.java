package repook.repseverythingmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.block.ModBlocks;
import repook.repseverythingmod.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        BlockStateModelGenerator.BlockTexturePool eroded = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ERODED_BRICKS);

        eroded.family(BlockFamilies.register(ModBlocks.ERODED_BRICKS).build());
    blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TRADITIONAL_LANTERN);


    //blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.STRAW_BLOCK);

    blockStateModelGenerator.registerParentedItemModel(ModItems.ERODED_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
    blockStateModelGenerator.registerParentedItemModel(ModItems.SCARECROW_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));

        eroded.stairs(ModBlocks.ERODED_BRICK_STAIRS);
        eroded.slab(ModBlocks.ERODED_BRICK_SLAB);
        eroded.wall(ModBlocks.ERODED_BRICK_WALL);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PHANTOM_BOOTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCARECROW, Models.GENERATED);
        itemModelGenerator.register(ModItems.CONCH_SHELL, Models.GENERATED);
    }


}

