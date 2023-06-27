package net.yakoro.sweetmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.yakoro.sweetmod.block.ModBlocks;
import net.yakoro.sweetmod.fluid.ModFluids;

public class SweetModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEARTBEETROOTS_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHOCO_LEAVES, RenderLayer.getCutout());
        //BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHOCO_SAPLING, RenderLayer.getCutout());

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_BEER, ModFluids.FLOWING_BEER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        0xF3D05B
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getSolid(),
                ModFluids.STILL_BEER, ModFluids.FLOWING_BEER);

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_ACID, ModFluids.FLOWING_ACID,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        0x41E35C
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_ACID, ModFluids.FLOWING_ACID);
    }
}
