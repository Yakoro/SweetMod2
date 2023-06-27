package net.yakoro.sweetmod.item.toolmaterial;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class MyPickaxeItem extends PickaxeItem {
    public MyPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    } 
}
