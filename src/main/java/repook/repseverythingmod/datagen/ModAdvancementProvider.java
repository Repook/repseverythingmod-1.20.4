package repook.repseverythingmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.Criterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.advancement.AdvancementProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;
import repook.repseverythingmod.block.ModBlocks;
import repook.repseverythingmod.item.ModItems;

import java.util.Optional;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {



/*        Advancement goldenRottenFlesh = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.CONCH_SHELL),
                        Text.literal("Island-Equivalent Rooster"), Text.literal("Obtain A Conch Shell"),
                        Optional.of(new Identifier(RepsEverythingMod.MOD_ID, "block/straw")), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_conch_shell", InventoryChangedCriterion.Conditions.items(ModItems.CONCH_SHELL))

                .build(consumer, RepsEverythingMod.MOD_ID + ":has_conch_shell").value();*/



    }


}
