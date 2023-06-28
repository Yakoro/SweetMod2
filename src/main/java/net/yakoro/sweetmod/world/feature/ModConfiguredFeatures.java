package net.yakoro.sweetmod.world.feature;

import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.MegaPineFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.yakoro.sweetmod.SweetMod;
import net.yakoro.sweetmod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> OVERWORLD_CORDIERITE_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.CORDIERITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_CORDIERITE_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CORDIERITE_ORE =
            ConfiguredFeatures.register("cordierite_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_CORDIERITE_ORE, 9));

    public static final List<OreFeatureConfig.Target> OVERWORLD_URANIUM_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.URANIUM_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_URANIUM_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> URANIUM_ORE =
            ConfiguredFeatures.register("uranium_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_URANIUM_ORE, 9));

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> CHOCO_TREE =
    ConfiguredFeatures.register("choco_tree", Feature.TREE, new TreeFeatureConfig.Builder(
            BlockStateProvider.of(ModBlocks.CHOCO_LOG),
            new StraightTrunkPlacer(3, 4, 2),
            BlockStateProvider.of(ModBlocks.CHOCO_LEAVES),
            new MegaPineFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(8), ConstantIntProvider.create(8)),
            new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final RegistryEntry<PlacedFeature> CHOCO_CHECKED = PlacedFeatures.register("choco_checked",
            ModConfiguredFeatures.CHOCO_TREE, List.of(PlacedFeatures.wouldSurvive(ModBlocks.CHOCO_SAPLING)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> CHOCO_SPAWN =
            ConfiguredFeatures.register("choco_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(CHOCO_CHECKED, 0.5f)),
                    CHOCO_CHECKED));


    public static void registerConfiguredFeatures() {
        SweetMod.LOGGER.debug("Registering the ModConfiguredFeatures for " + SweetMod.MOD_ID);
    }

}
