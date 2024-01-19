package repook.repseverythingmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;
import repook.repseverythingmod.entity.custom.ErodedEntity;

public class ModEntities {
    public static final EntityType<ErodedEntity> ERODED = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(RepsEverythingMod.MOD_ID, "eroded"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ErodedEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.75f)).build());
}
