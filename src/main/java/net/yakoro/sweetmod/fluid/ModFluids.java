package net.yakoro.sweetmod.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.yakoro.sweetmod.SweetMod;
import net.yakoro.sweetmod.item.ModItemGroup;

public class ModFluids {
    public static FlowableFluid STILL_BEER;
    public static FlowableFluid FLOWING_BEER;
    public static Block BEER_BLOCK;
    public static Item BEER_BUCKET;


    public static FlowableFluid STILL_ACID;
    public static FlowableFluid FLOWING_ACID;
    public static Block ACID_BLOCK;
    public static Item ACID_BUCKET;

    public static void register() {
        STILL_BEER = Registry.register(Registry.FLUID,
                new Identifier(SweetMod.MOD_ID, "beer"), new BeerFluid.Still());
        FLOWING_BEER = Registry.register(Registry.FLUID,
                new Identifier(SweetMod.MOD_ID, "flowing_beer"), new BeerFluid.Flowing());

        BEER_BLOCK = Registry.register(Registry.BLOCK, new Identifier(SweetMod.MOD_ID, "beer_block"),
                new FluidBlock(ModFluids.STILL_BEER, FabricBlockSettings.copyOf(Blocks.WATER)) {
                });
        BEER_BUCKET = Registry.register(Registry.ITEM, new Identifier(SweetMod.MOD_ID, "beer_bucket"),
                new BucketItem(ModFluids.STILL_BEER, new FabricItemSettings().group(ModItemGroup.CORDIERITE).recipeRemainder(Items.BUCKET).maxCount(1)));


        STILL_ACID = Registry.register(Registry.FLUID,
                new Identifier(SweetMod.MOD_ID, "acid"), new AcidFluid.Still());
        FLOWING_ACID = Registry.register(Registry.FLUID,
                new Identifier(SweetMod.MOD_ID, "flowing_acid"), new AcidFluid.Flowing());

        ACID_BLOCK = Registry.register(Registry.BLOCK, new Identifier(SweetMod.MOD_ID, "acid_block"),
                new FluidBlock(ModFluids.STILL_ACID, FabricBlockSettings.copyOf(Blocks.WATER)) {
                });
        ACID_BUCKET = Registry.register(Registry.ITEM, new Identifier(SweetMod.MOD_ID, "acid_bucket"),
                new BucketItem(ModFluids.STILL_ACID, new FabricItemSettings().group(ModItemGroup.CORDIERITE).recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}

