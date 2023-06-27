package net.yakoro.sweetmod.item.toolmaterial;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.yakoro.sweetmod.item.ModItems;

public class CordieriteToolMaterialPickaxe implements ToolMaterial {

    public static final CordieriteToolMaterialPickaxe INSTANCE2 = new CordieriteToolMaterialPickaxe();
    @Override
    public int getDurability() {
        return 2000;
    }

    @Override
    public float getMiningSpeedMultiplier() { return 30; }

    @Override
    public float getAttackDamage() {
        return 5;
    }

    @Override
    public int getMiningLevel() {
        return 100;
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.CORDIERITE);
    }
}
