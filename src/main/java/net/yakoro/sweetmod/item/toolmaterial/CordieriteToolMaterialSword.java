package net.yakoro.sweetmod.item.toolmaterial;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.yakoro.sweetmod.item.ModItems;

public class CordieriteToolMaterialSword implements ToolMaterial {

    public static final CordieriteToolMaterialSword INSTANCE = new CordieriteToolMaterialSword();
    @Override
    public int getDurability() {
        return 2000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 20;
    }

    @Override
    public int getMiningLevel() {
        return 0;
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
