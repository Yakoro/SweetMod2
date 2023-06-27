package net.yakoro.sweetmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.yakoro.sweetmod.SweetMod;

public class ModItemGroup {
    public static final ItemGroup CORDIERITE = FabricItemGroupBuilder.build(
            new Identifier(SweetMod.MOD_ID, "cordierite"), () -> new ItemStack(ModItems.CORDIERITE));
    public static final ItemGroup SWEET = FabricItemGroupBuilder.build(
            new Identifier(SweetMod.MOD_ID, "sweet"), () -> new ItemStack(ModItems.FLOUR));
}
