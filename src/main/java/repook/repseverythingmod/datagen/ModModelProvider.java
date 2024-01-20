package repook.repseverythingmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
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
    blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TRADITIONAL_LANTERN);
    //blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.STRAW_BLOCK);

    blockStateModelGenerator.registerParentedItemModel(ModItems.ERODED_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PHANTOM_BOOTS, Models.GENERATED);
    }
}

