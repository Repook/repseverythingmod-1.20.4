package repook.repseverythingmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BellBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SkullBlock;
import net.minecraft.block.entity.BellBlockEntity;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;
import repook.repseverythingmod.block.custom.ErodedSkullBlock;
import repook.repseverythingmod.block.custom.LuckyCatBlock;
import repook.repseverythingmod.block.custom.TraditionalLanternBlock;

public class ModBlocks {


public static final Block TRADITIONAL_LANTERN = registerBlock("traditional_lantern"
        ,new TraditionalLanternBlock(FabricBlockSettings.copyOf(Blocks.LANTERN).breakInstantly()));



    public static final Block ERODED_SKULL = registerBlock("eroded_skull"
            ,new ErodedSkullBlock(FabricBlockSettings.copyOf(Blocks.SKELETON_SKULL).breakInstantly()));

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
