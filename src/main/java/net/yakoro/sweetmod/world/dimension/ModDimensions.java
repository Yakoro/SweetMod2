package net.yakoro.sweetmod.world.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.yakoro.sweetmod.SweetMod;

public class ModDimensions {
    public static final RegistryKey<World> SUGAR_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY,
            new Identifier(SweetMod.MOD_ID, "sugardim"));
    public static final RegistryKey<DimensionType> SUGAR_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, SUGAR_DIMENSION_KEY.getValue());

    public static void register() {
        SweetMod.LOGGER.debug("Registering ModDimensions for " + SweetMod.MOD_ID);
    }
}
