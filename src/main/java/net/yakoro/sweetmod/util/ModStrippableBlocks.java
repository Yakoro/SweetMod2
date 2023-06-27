package net.yakoro.sweetmod.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.yakoro.sweetmod.block.ModBlocks;

public class ModStrippableBlocks {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.CHOCO_LOG, ModBlocks.STRIPPED_CHOCO_LOG);
        StrippableBlockRegistry.register(ModBlocks.CHOCO_WOOD, ModBlocks.STRIPPED_CHOCO_WOOD);
    }
}
