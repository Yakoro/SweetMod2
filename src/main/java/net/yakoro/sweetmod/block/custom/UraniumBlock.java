package net.yakoro.sweetmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
//import net.minecraft.world.event.GameEventListenerRegistration;
//import net.minecraft.world.event.GameEventListeners;

public class UraniumBlock extends Block {
    public UraniumBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);

        player.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,200, 8));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER,200,8));
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);
        if(entity instanceof LivingEntity player) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,200, 8));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER,200,8));
        }

    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            player.sendMessage(Text.literal("Touché !"));

            if (player.squaredDistanceTo(pos.getX(), pos.getY(), pos.getZ()) < 1.0D) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 60));
                //world.emitGameEvent(player, GameEvent.HIT_GROUND, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
            }
        }
    }
}
