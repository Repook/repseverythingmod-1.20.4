package repook.repseverythingmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;
import repook.repseverythingmod.block.ModBlocks;
import repook.repseverythingmod.enchantment.ModEnchantments;
import repook.repseverythingmod.potion.ModPotions;

public class ModItemGroup {



    public static final ItemGroup REPS_EVERYTHING_MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RepsEverythingMod.MOD_ID, "reps_everything_mod_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.reps_everything_mod_group"))
                    .icon(() -> new ItemStack(ModItems.GOLDEN_BEETROOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.GOLDEN_BEETROOT);
                        entries.add(ModItems.ENCHANTED_GOLDEN_BEETROOT);
                        entries.add(ModItems.GOLDEN_SWEET_BERRIES);
                        entries.add(ModItems.ENCHANTED_GOLDEN_SWEET_BERRIES);
                        entries.add(ModItems.GOLDEN_ROTTEN_FLESH);
                        entries.add(ModItems.ENCHANTED_GOLDEN_ROTTEN_FLESH);
                        entries.add(ModItems.ENCHANTED_GOLDEN_CARROT);
                        entries.add(ModBlocks.TRADITIONAL_LANTERN);
                        entries.add(ModItems.LUCKY_CAT_BLOCK_ITEM);
                        entries.add(ModItems.PHANTOM_BOOTS);
                        entries.add(ModItems.ERODED_SPAWN_EGG);
                        entries.add(ModBlocks.ERODED_BRICKS);
                        entries.add(ModBlocks.GILDED_ERODED_BRICKS);
                        entries.add(ModBlocks.ERODED_BRICK_STAIRS);
                        entries.add(ModBlocks.GILDED_ERODED_BRICK_STAIRS);
                        entries.add(ModBlocks.ERODED_BRICK_SLAB);
                        entries.add(ModBlocks.GILDED_ERODED_BRICK_SLAB);
                        entries.add(ModBlocks.ERODED_BRICK_WALL);
                        entries.add(ModBlocks.GILDED_ERODED_BRICK_WALL);
                        entries.add(ModBlocks.CHISELED_ERODED_BRICKS);
                        entries.add(ModBlocks.GILDED_CHISELED_ERODED_BRICKS);
                        entries.add(ModBlocks.ERODED_BRICK_PILLAR);
                        entries.add(ModBlocks.GILDED_ERODED_BRICK_PILLAR);
                        entries.add(ModItems.ERODED_FRAGMENT);
                        entries.add(ModItems.ERODED_SHIELD);
                        entries.add(ModItems.SCARECROW);
                        entries.add(ModBlocks.STRAW_BLOCK);
                        entries.add(ModBlocks.CRATE);
                        entries.add(ModItems.CONCH_SHELL);
                        addCustomEnchantmentBooks(entries);
                    }).build());

    private static void addCustomEnchantmentBooks(ItemGroup.Entries entries) {

        Enchantment myCustomEnchantment = ModEnchantments.FRIGID_STRIKE;

        for (int level = myCustomEnchantment.getMinLevel(); level <= myCustomEnchantment.getMaxLevel(); level++) {
            ItemStack book = EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(myCustomEnchantment, level));
            entries.add(book, ItemGroup.StackVisibility.PARENT_TAB_ONLY);
        }
        Enchantment frostEnchantment = ModEnchantments.FROST;
        for (int level = frostEnchantment.getMinLevel(); level <= frostEnchantment.getMaxLevel(); level++) {
            ItemStack book = EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(frostEnchantment, level));
            entries.add(book, ItemGroup.StackVisibility.PARENT_TAB_ONLY);
        }
    }




    public static void registerItemGroup(){
        RepsEverythingMod.LOGGER.info("Registering Item Group for"+ RepsEverythingMod.MOD_ID);

    }
}
