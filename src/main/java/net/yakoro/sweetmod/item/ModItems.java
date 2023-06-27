package net.yakoro.sweetmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.yakoro.sweetmod.SweetMod;
import net.yakoro.sweetmod.block.ModBlocks;
import net.yakoro.sweetmod.item.custom.ExplosiveGunItem;
import net.yakoro.sweetmod.item.custom.FireStaffItem;
import net.yakoro.sweetmod.item.custom.TotemOfGodItem;
import net.yakoro.sweetmod.item.toolmaterial.CordieriteToolMaterialPickaxe;
import net.yakoro.sweetmod.item.toolmaterial.CordieriteToolMaterialSword;
import net.yakoro.sweetmod.item.custom.HealingStaffItem;
import net.yakoro.sweetmod.item.toolmaterial.MyPickaxeItem;

public class ModItems {

    public static final Item RAW_CORDIERITE = registerItem("raw_cordierite",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));
    public static final Item CORDIERITE = registerItem("cordierite",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));

    public static final Item CORDIERITE_SWORD = registerItem("cordierite_sword",
            new SwordItem(CordieriteToolMaterialSword.INSTANCE, 20, -2f, new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));
    public static final Item HEALING_STAFF = registerItem("healing_staff",
            new HealingStaffItem(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));

    public static final Item CORDIERITE_PICKAXE = registerItem("cordierite_pickaxe",
            new MyPickaxeItem(CordieriteToolMaterialPickaxe.INSTANCE2,2,-2f, new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));

    public static final Item EXPLOSIVE_GUN = registerItem("explosive_gun",
            new ExplosiveGunItem(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));

    public static final Item URANIUM_BALL = registerItem("uranium_ball",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));

    public static final Item RAW_URANIUM = registerItem("raw_uranium",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));
    public static final Item URANIUM = registerItem("uranium",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));

    public static final Item HEARTBEETROOTS_SEEDS = registerItem("heartbeetroots_seeds",
            new AliasedBlockItem(ModBlocks.HEARTBEETROOTS_CROP, new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));

    public static final Item HEARTBEETROOTS = registerItem("heartbeetroots",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE).food(new FoodComponent.Builder().hunger(2).saturationModifier(4f).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 1) , 1.0f).build())));

    public static final Item TOTEM_OF_GOD = registerItem("totem_of_god",
            new TotemOfGodItem(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));

    public static final Item FIRE_STAFF = registerItem("fire_staff",
            new FireStaffItem(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));

    public static final Item INVISIBLE_PROJECTILE = registerItem("invisible_projectile",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));


    public static final Item FLOUR = registerItem("flour",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.SWEET)));

    public static final Item BUTTER = registerItem("butter",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.SWEET)));

    public static final Item CHOCBAR100 = registerItem("chocobar100",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.SWEET).food(new FoodComponent.Builder().hunger(1).saturationModifier(1f).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 500, 1) , 1.0f).build())));

    public static final Item CHOCBAR70 = registerItem("chocobar70",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.SWEET).food(new FoodComponent.Builder().hunger(2).saturationModifier(4f).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 1) , 1.0f).build())));

    public static final Item COCOABEAN = registerItem("cocoabean",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.SWEET)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(SweetMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        SweetMod.LOGGER.debug("Registering Mod Items for " + SweetMod.MOD_ID);
    }

    //public static final Entity EXPLOSIVE_PROJECTILE = registerItem("explosive_projectile",
            //new ExplosiveProjectileEntity(new FabricEntityType<>));

}
