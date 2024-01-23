package repook.repseverythingmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.block.ModBlocks;
import repook.repseverythingmod.item.ModItems;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GOLDEN_BEETROOT)
                .pattern("GGG")
                .pattern("GBG")
                .pattern("GGG")
                .input('B', Items.BEETROOT)
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.BEETROOT), conditionsFromItem(Items.BEETROOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GOLDEN_BEETROOT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GOLDEN_SWEET_BERRIES)
                .pattern("GGG")
                .pattern("GBG")
                .pattern("GGG")
                .input('B', Items.SWEET_BERRIES)
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GOLDEN_SWEET_BERRIES)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GOLDEN_ROTTEN_FLESH)
                .pattern("GGG")
                .pattern("GBG")
                .pattern("GGG")
                .input('B', Items.ROTTEN_FLESH)
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GOLDEN_ROTTEN_FLESH)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TRADITIONAL_LANTERN, 4)
                .pattern("RYR")
                .pattern("YTY")
                .pattern("RYR")
                .input('R', Blocks.RED_WOOL)
                .input('Y', Blocks.YELLOW_WOOL)
                .input('T', Items.TORCH)
                .criterion(hasItem(Items.TORCH), conditionsFromItem(Items.TORCH))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.TRADITIONAL_LANTERN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PHANTOM_BOOTS)
                .pattern("   ")
                .pattern("B B")
                .pattern("P P")
                .input('P', Items.PHANTOM_MEMBRANE)
                .input('B', Items.BLAZE_ROD)
                .criterion(hasItem(Items.PHANTOM_MEMBRANE), conditionsFromItem(Items.PHANTOM_MEMBRANE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PHANTOM_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.STRAW_BLOCK)
                .pattern("W W")
                .pattern(" W ")
                .pattern("W W")
                .input('W', Items.WHEAT)
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.STRAW_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ERODED_SHIELD)
                .pattern("EEE")
                .pattern("ESE")
                .pattern("EEE")
                .input('S', Items.SHIELD)
                .input('E', ModItems.ERODED_FRAGMENT)
                .criterion(hasItem(ModItems.ERODED_FRAGMENT), conditionsFromItem(ModItems.ERODED_FRAGMENT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ERODED_FRAGMENT)));

        offer2x2CompactingRecipe(exporter,RecipeCategory.DECORATIONS,ModBlocks.ERODED_BRICKS,ModItems.ERODED_FRAGMENT);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SCARECROW)
                .pattern(" P ")
                .pattern("FHF")
                .pattern(" F ")
                .input('H', ModBlocks.STRAW_BLOCK)
                .input('P', Items.CARVED_PUMPKIN)
                .input('F', Items.STICK)
                .criterion(hasItem(Items.HAY_BLOCK), conditionsFromItem(Items.HAY_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCARECROW)));

        offerStonecuttingRecipe(exporter,RecipeCategory.DECORATIONS,ModBlocks.ERODED_BRICK_STAIRS,ModBlocks.ERODED_BRICKS);
        offerStonecuttingRecipe(exporter,RecipeCategory.DECORATIONS,ModBlocks.ERODED_BRICK_SLAB,ModBlocks.ERODED_BRICKS);
        offerStonecuttingRecipe(exporter,RecipeCategory.DECORATIONS,ModBlocks.ERODED_BRICK_WALL,ModBlocks.ERODED_BRICKS);
        offerStonecuttingRecipe(exporter,RecipeCategory.DECORATIONS,ModBlocks.CHISELED_ERODED_BRICKS,ModBlocks.ERODED_BRICKS);

    }






}
