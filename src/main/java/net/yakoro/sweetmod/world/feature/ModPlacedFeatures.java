package net.yakoro.sweetmod.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryEntry<PlacedFeature> CORDIERITE_ORE_PLACED = PlacedFeatures.register("cordierite_ore_placed",
            ModConfiguredFeatures.CORDIERITE_ORE, modifiersWithCount(9,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80),YOffset.aboveBottom(80))));

    public static final RegistryEntry<PlacedFeature> URANIUM_ORE_PLACED = PlacedFeatures.register("uranium_ore_placed",
            ModConfiguredFeatures.URANIUM_ORE, modifiersWithCount(15,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-50),YOffset.aboveBottom(150))));

    public static final RegistryEntry<PlacedFeature> CHOCO_PLACED = PlacedFeatures.register("choco_placed",
            ModConfiguredFeatures.CHOCO_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
