package net.yakoro.sweetmod;

import net.fabricmc.api.ModInitializer;
import net.yakoro.sweetmod.block.ModBlocks;
import net.yakoro.sweetmod.fluid.ModFluids;
import net.yakoro.sweetmod.item.ModItems;
import net.yakoro.sweetmod.util.ModFlammableBlocks;
import net.yakoro.sweetmod.util.ModStrippableBlocks;
import net.yakoro.sweetmod.villager.ModVillagers;
import net.yakoro.sweetmod.world.feature.ModConfiguredFeatures;
import net.yakoro.sweetmod.world.gen.ModOreGeneration;
import net.yakoro.sweetmod.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class SweetMod implements ModInitializer {
	public static final String MOD_ID = "sweetmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

        ModVillagers.registerVillagers();
		ModVillagers.registerTrades();
		ModWorldGen.generateWorldGen();

		ModFlammableBlocks.registerFlammableBlock();
		ModStrippableBlocks.registerStrippables();

		ModFluids.register();
	}
}
