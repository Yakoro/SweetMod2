package net.yakoro.sweetmod.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.yakoro.sweetmod.block.ModBlocks;

public class ModFlammableBlocks {
    public static void registerFlammableBlock() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.CHOCO_LOG, 5, 5);
        registry.add(ModBlocks.CHOCO_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_CHOCO_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_CHOCO_WOOD, 5, 5);
        registry.add(ModBlocks.CHOCO_PLANKS, 5, 20);
        registry.add(ModBlocks.CHOCO_LEAVES, 30, 60);
    }
}
