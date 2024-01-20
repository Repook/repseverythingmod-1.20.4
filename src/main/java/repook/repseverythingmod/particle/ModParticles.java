package repook.repseverythingmod.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;

public class ModParticles {


    public static final DefaultParticleType ERODED_DIRT_PARTICLE =
            registerParticle("eroded_dirt_particle", FabricParticleTypes.simple());



    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(RepsEverythingMod.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        RepsEverythingMod.LOGGER.info("Registering Particles for " + RepsEverythingMod.MOD_ID);
    }
}
