package net.yakoro.sweetmod.world.feature;

import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
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
            new StraightTrunkPlacer(8, 10, 6),
            BlockStateProvider.of(ModBlocks.CHOCO_LEAVES),
            new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
            new TwoLayersFeatureSize(1, 0, 2)).build());


    public static void registerConfiguredFeatures() {
        SweetMod.LOGGER.debug("Registering the ModConfiguredFeatures for " + SweetMod.MOD_ID);
    }

}
