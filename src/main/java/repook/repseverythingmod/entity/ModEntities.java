package repook.repseverythingmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.model.SheepEntityModel;
import net.minecraft.client.render.entity.model.SheepWoolEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;
import repook.repseverythingmod.entity.custom.ErodedEntity;
import repook.repseverythingmod.entity.custom.ErodedPlateEntity;
import repook.repseverythingmod.entity.custom.ScarecrowEntity;
import software.bernie.geckolib.model.GeoModel;

public class ModEntities {

    public static final EntityType<ErodedEntity> ERODED = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(RepsEverythingMod.MOD_ID, "eroded"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ErodedEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6F, 1.75F)).build());


    public static final EntityType<ScarecrowEntity> SCARECROW = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(RepsEverythingMod.MOD_ID, "scarecrow"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ScarecrowEntity::new)
                    .dimensions(EntityDimensions.fixed(1, 1.75f)).build());

    public static final EntityType<ErodedPlateEntity> ERODED_PLATE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(RepsEverythingMod.MOD_ID, "eroded_plate"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ErodedPlateEntity::new)
                    .dimensions(EntityDimensions.fixed(1, 0.25F)).build());




}
