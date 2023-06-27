package net.yakoro.sweetmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.yakoro.sweetmod.SweetMod;

import net.minecraft.util.registry.Registry;
import net.yakoro.sweetmod.block.custom.*;
import net.yakoro.sweetmod.item.ModItemGroup;

public class ModBlocks {
    public static final Block CORDIERITE_BLOCK = registerBlock("cordierite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.CORDIERITE);
    public static final Block CORDIERITE_ORE = registerBlock("cordierite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(1,50)), ModItemGroup.CORDIERITE);
    public static final Block DEEPSLATE_CORDIERITE_ORE = registerBlock("deepslate_cordierite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
            UniformIntProvider.create(1,50)), ModItemGroup.CORDIERITE);

    public static final Block URANIUM_BLOCK = registerBlock("uranium_block",
            new UraniumBlock(FabricBlockSettings.of(Material.METAL).luminance(10).strength(4f).requiresTool()), ModItemGroup.CORDIERITE);
    public static final Block URANIUM_ORE = registerBlock("uranium_ore",
            new UraniumOreBlock(FabricBlockSettings.of(Material.STONE).luminance(10).strength(4f).requiresTool(),
                    UniformIntProvider.create(5,10)), ModItemGroup.CORDIERITE);
    public static final Block DEEPSLATE_URANIUM_ORE = registerBlock("deepslate_uranium_ore",
            new UraniumOreBlock(FabricBlockSettings.of(Material.STONE).luminance(10).strength(4f).requiresTool(),
                    UniformIntProvider.create(5,10)), ModItemGroup.CORDIERITE);

    public static final Block HEAL_BLOCK = registerBlock("heal_block",
            new HealBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.CORDIERITE);

    public static final Block CORDIERITE_LAMP = registerBlock("cordierite_lamp",
            new CordieriteLampBlock(FabricBlockSettings.of(Material.REDSTONE_LAMP).luminance(state -> state.get(CordieriteLampBlock.LIT) ? 15 : 0).strength(4f).requiresTool()), ModItemGroup.CORDIERITE);

    public static final Block HEARTBEETROOTS_CROP = registerBlockWithoutItem("heartbeetroots_crop",
            new HeartBeetrootsCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));

    // Chocolate Tree

    public static final Block CHOCO_LOG = registerBlock("choco_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)), ModItemGroup.SWEET);
    public static final Block CHOCO_WOOD = registerBlock("choco_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)), ModItemGroup.SWEET);
    public static final Block STRIPPED_CHOCO_LOG = registerBlock("stripped_choco_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)), ModItemGroup.SWEET);
    public static final Block STRIPPED_CHOCO_WOOD = registerBlock("stripped_choco_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)), ModItemGroup.SWEET);
    public static final Block CHOCO_PLANKS = registerBlock("choco_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)), ModItemGroup.SWEET);
    public static final Block CHOCO_LEAVES = registerBlock("choco_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)), ModItemGroup.SWEET);
    //public static final Block CHOCO_SAPLING = registerBlock("choco_sapling",
    //        new SaplingBlock(, FabricBlockSettings.copy(Blocks.OAK_LOG)), ModItemGroup.SWEET);


    //


    private static Block registerBlockWithoutItem(String name, Block block){
        return Registry.register(Registry.BLOCK, new Identifier(SweetMod.MOD_ID, name), block);
    }
    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(SweetMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(SweetMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }
    public static void registerModBlocks() {
        SweetMod.LOGGER.debug("Registering ModBlocks for " + SweetMod.MOD_ID);
    }

}
