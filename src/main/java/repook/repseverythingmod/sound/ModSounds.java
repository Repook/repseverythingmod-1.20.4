package repook.repseverythingmod.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import repook.repseverythingmod.RepsEverythingMod;

public class ModSounds {

    public static final SoundEvent ENTITY_ERODED_AMBIENT = registerSoundEvent("entity_eroded_ambient");
    public static final SoundEvent ENTITY_ERODED_HURT = registerSoundEvent("entity_eroded_hurt");
    public static final SoundEvent ENTITY_ERODED_DEATH = registerSoundEvent("entity_eroded_death");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(RepsEverythingMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds() {
        RepsEverythingMod.LOGGER.info("Registering Mod Sounds for " + RepsEverythingMod.MOD_ID);
    }
}
