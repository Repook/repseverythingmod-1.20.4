package repook.repseverythingmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;
import repook.repseverythingmod.block.custom.LuckyCatBlock;
import repook.repseverythingmod.block.custom.StrawBlock;
import repook.repseverythingmod.block.custom.TraditionalLanternBlock;

public class ModBlocks {


public static final Block TRADITIONAL_LANTERN = registerBlock("traditional_lantern"
        ,new TraditionalLanternBlock(FabricBlockSettings.copyOf(Blocks.LANTERN).breakInstantly()));

    public static final Block ERODED_BRICKS = registerBlock("eroded_bricks"
            ,new Block(FabricBlockSettings.copyOf(Blocks.PACKED_MUD)));

    public static final Block ERODED_BRICK_STAIRS = registerBlock("eroded_brick_stairs",
            new StairsBlock(ModBlocks.ERODED_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.MUD_BRICK_STAIRS)));

    public static final Block ERODED_BRICK_SLAB = registerBlock("eroded_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.MUD_BRICK_SLAB)));

    public static final Block ERODED_BRICK_WALL = registerBlock("eroded_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.MUD_BRICK_WALL)));


    public static final Block CHISELED_ERODED_BRICKS = registerBlock("chiseled_eroded_bricks"
            ,new Block(FabricBlockSettings.copyOf(Blocks.MUD_BRICKS)));


    public static final Block STRAW_BLOCK = registerBlock("straw_block"
            ,new StrawBlock(FabricBlockSettings.copyOf(Blocks.HAY_BLOCK).nonOpaque()));




    public static final Block LUCKY_CAT = Registry.register(Registries.BLOCK, new Identifier(RepsEverythingMod.MOD_ID,"lucky_cat")
            ,new LuckyCatBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).breakInstantly().nonOpaque()));



    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(RepsEverythingMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(RepsEverythingMod.MOD_ID, name),block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(RepsEverythingMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        RepsEverythingMod.LOGGER.info("Registering Mod Blocks for" + RepsEverythingMod.MOD_ID);
    }
}
