package repook.repseverythingmod.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;
import repook.repseverythingmod.block.ModBlocks;
import software.bernie.example.GeckoLibMod;
import software.bernie.example.block.GeckoHabitatBlock;

public class ModBlockEntities {


    public static BlockEntityType<LuckyCatEntity> LUCKY_CAT_ENTITY;

    public static void registerAllBlockEntities(){
        LUCKY_CAT_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(RepsEverythingMod.MOD_ID,"lucky_cat_block_entity"),
                FabricBlockEntityTypeBuilder.create(LuckyCatEntity::new,
                        ModBlocks.LUCKY_CAT).build());
    }

}
