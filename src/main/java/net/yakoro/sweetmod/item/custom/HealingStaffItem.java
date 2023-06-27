package net.yakoro.sweetmod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class HealingStaffItem extends Item {

    public HealingStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.world.isClient() && hand == Hand.MAIN_HAND) {
            if(!entity.isPlayer()) {
                entity.takeKnockback(8, user.getX() - entity.getX(), user.getZ() - entity.getZ());
            }
            if(entity.isPlayer()) {
                entity.heal(6);
                user.getItemCooldownManager().set(this, 20);
            }
        }
        return super.useOnEntity(stack, user, entity, hand);
    }

    /*@Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient() && context.getHand() == Hand.MAIN_HAND) {
            //context.getPlayer().takeKnockback(4, context.getPlayer().getX() - context.getBlockPos().getX(), context.getPlayer().getZ() - context.getBlockPos().getZ());
            //context.getPlayer().setNoGravity(true);
            //context.getPlayer().setVelocity(context.getPlayer().getVelocity().add(0, 0.5, 0));
            //context.getPlayer().jump();
            context.getPlayer().setNoGravity(false);
            context.getPlayer().sendMessage(Text.literal("Fonctionne !!"));
        }
        return super.useOnBlock(context);
    }*/

}




