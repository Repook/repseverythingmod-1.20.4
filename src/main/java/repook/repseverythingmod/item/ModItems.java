package repook.repseverythingmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.DecoratedPotBlock;
import net.minecraft.block.DecoratedPotPatterns;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;
import repook.repseverythingmod.block.ModBlocks;
import repook.repseverythingmod.entity.ModEntities;
import repook.repseverythingmod.item.custom.*;

public class ModItems {


    public static final Item GOLDEN_BEETROOT = registerItem("golden_beetroot",
            new Item(new FabricItemSettings().food(ModFoodComponents.GOLDEN_BEETROOT)));

    public static final Item GOLDEN_SWEET_BERRIES = registerItem("golden_sweet_berries",
            new Item(new FabricItemSettings().food(ModFoodComponents.GOLDEN_SWEET_BERRIES)));

    public static final Item GOLDEN_ROTTEN_FLESH = registerItem("golden_rotten_flesh",
            new Item(new FabricItemSettings().food(ModFoodComponents.GOLDEN_ROTTEN_FLESH)));
    public static final Item ENCHANTED_GOLDEN_BEETROOT = registerItem("enchanted_golden_beetroot",
            new EnchantedGoldenFoodItem(new FabricItemSettings().food(ModFoodComponents.ENCHANTED_GOLDEN_BEETROOT)));

    public static final Item ENCHANTED_GOLDEN_SWEET_BERRIES = registerItem("enchanted_golden_sweet_berries",
            new EnchantedGoldenFoodItem(new FabricItemSettings().food(ModFoodComponents.ENCHANTED_GOLDEN_SWEET_BERRIES)));

    public static final Item ENCHANTED_GOLDEN_ROTTEN_FLESH = registerItem("enchanted_golden_rotten_flesh",
            new EnchantedGoldenFoodItem(new FabricItemSettings().food(ModFoodComponents.ENCHANTED_GOLDEN_ROTTEN_FLESH)));

    public static final Item ENCHANTED_GOLDEN_CARROT = registerItem("enchanted_golden_carrot",
            new EnchantedGoldenFoodItem(new FabricItemSettings().food(ModFoodComponents.ENCHANTED_GOLDEN_CARROT)));

    public static final Item ERODED_SHIELD = registerItem("eroded_shield",
            new ErodedShieldItem(new FabricItemSettings().maxDamage(500)));

    public static final Item ERODED_FRAGMENT = registerItem("eroded_fragment",
            new Item(new FabricItemSettings()));

    public static final Item CONCH_SHELL = registerItem("conch_shell",
            new ConchShellItem(new FabricItemSettings()));

    public static final Item SCARECROW = registerItem("scarecrow",
            new ScarecrowItem(new FabricItemSettings().maxCount(16)));

    public static final Item PHANTOM_BOOTS = registerItem("phantom_boots",
            new PhantomBootsItem( ModArmorMaterials.PHANTOM,ArmorItem.Type.BOOTS,new FabricItemSettings().maxDamage(500)));

    public static final Item LUCKY_CAT_BLOCK_ITEM = registerItem("lucky_cat",
            new LuckyCatBlockItem(ModBlocks.LUCKY_CAT, new FabricItemSettings()));

    public static final Item ERODED_SPAWN_EGG = registerItem("eroded",
            new SpawnEggItem(ModEntities.ERODED,0x846a4e,0x493228, new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(RepsEverythingMod.MOD_ID,name),item);
    }

    public static void registerModItems(){
        RepsEverythingMod.LOGGER.info("Registering Mod Items for"+ RepsEverythingMod.MOD_ID);
    }
}
