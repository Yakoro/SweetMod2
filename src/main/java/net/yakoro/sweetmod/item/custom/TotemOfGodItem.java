package net.yakoro.sweetmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.server.MinecraftServer;

public class TotemOfGodItem extends Item {

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (!user.world.isClient() && hand == Hand.MAIN_HAND) {
            world.addParticle(ParticleTypes.SMOKE, true, user.getX(), user.getY(), user.getZ(), 0.1, 0.1, 0.1);

            if (world.isNight()) {
                MinecraftServer server = world.getServer();
                if (server != null) {
                    long timeOfDay = 6000; // midi
                    server.getCommandManager().execute(server.getCommandSource().withSilent().withLevel(2),
                            "time set " + timeOfDay);
                    user.getItemCooldownManager().set(this, 10000);
                }
            } else {
                MinecraftServer server = world.getServer();
                if (server != null) {
                    long timeOfDay = 13000; // minuit
                    server.getCommandManager().execute(server.getCommandSource().withSilent().withLevel(2),
                            "time set " + timeOfDay);
                    user.getItemCooldownManager().set(this, 10000);
                }
            }

        }
        return super.use(world, user, hand);
    }

    public TotemOfGodItem(Settings settings) {
        super(settings);
    }
}
