package net.yakoro.sweetmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class InvisibleProjectileEntity extends ThrownItemEntity {

    public InvisibleProjectileEntity(World world, LivingEntity user){
        super(EntityType.SNOWBALL, user, world);

    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);

        if (!this.world.isClient) {
            this.world.sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        //entity.kill();
        //entity.setGlowing(true);
        entity.setOnFireFromLava();
        //entity.setPosition();
        //entityHitResult.getEntity().


    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }
}

