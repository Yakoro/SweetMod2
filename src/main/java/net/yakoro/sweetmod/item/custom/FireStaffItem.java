package net.yakoro.sweetmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.yakoro.sweetmod.entity.custom.InvisibleProjectileEntity;
import net.yakoro.sweetmod.item.ModItems;

public class FireStaffItem extends Item {

    public FireStaffItem(Settings settings) {
        super(settings);
    }

    //public ExplosiveGunItem(Item.Settings settings) { super(settings); }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {



        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_PLAYER_HURT_ON_FIRE, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));



        if (!world.isClient) {
            InvisibleProjectileEntity invisibleProjectileEntity = new InvisibleProjectileEntity(world, user);
            invisibleProjectileEntity.setItem(ModItems.INVISIBLE_PROJECTILE.getDefaultStack());
            invisibleProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0f, 20f, 0f);
            world.spawnEntity(invisibleProjectileEntity);
            user.getItemCooldownManager().set(this, 10);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));


        return TypedActionResult.success(itemStack, world.isClient());
    }


}