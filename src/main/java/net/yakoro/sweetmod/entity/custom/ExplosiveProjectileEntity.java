package net.yakoro.sweetmod.entity.custom;

import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class ExplosiveProjectileEntity extends ThrownItemEntity {

    public ExplosiveProjectileEntity(World world, LivingEntity user){
        super(EntityType.SNOWBALL, user, world);

    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        world.createExplosion(this, hitResult.getPos().getX(), hitResult.getPos().getY(), hitResult.getPos().getZ(), 5, Explosion.DestructionType.DESTROY);



        if (!this.world.isClient) {
            this.world.sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }
}

