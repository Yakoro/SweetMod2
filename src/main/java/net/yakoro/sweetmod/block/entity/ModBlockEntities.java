package net.yakoro.sweetmod.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.yakoro.sweetmod.SweetMod;
import net.yakoro.sweetmod.block.ModBlocks;


public class ModBlockEntities {
    public static BlockEntityType<CrusherBlockEntity> CRUSHER_STATION;
    public static BlockEntityType<CreamerBlockEntity> CREAMER_STATION;

    public static void registerBlockEntities() {
        CRUSHER_STATION = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(SweetMod.MOD_ID, "crusher_station"),
                FabricBlockEntityTypeBuilder.create(CrusherBlockEntity::new,
                        ModBlocks.CRUSHER_STATION).build(null));

        CREAMER_STATION = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(SweetMod.MOD_ID, "creamer_station"),
                FabricBlockEntityTypeBuilder.create(CreamerBlockEntity::new,
                        ModBlocks.CREAMER_STATION).build(null));
    }
}


