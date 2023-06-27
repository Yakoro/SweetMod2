package net.yakoro.sweetmod.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public abstract class AcidFluid extends FlowableFluid {

    @Override
    protected boolean isInfinite() {
        return true;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        final BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    @Override
    protected int getFlowSpeed(WorldView world) {
        return 3;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView world) { return 1; }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }

    @Override
    public int getLevel(FluidState state) {
        return 0;
    }

    @Override
    public int getTickRate(WorldView world) {
        return 5;
    }

    @Override
    protected float getBlastResistance() {
        return 100f;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    public Fluid getStill() {
        return ModFluids.STILL_ACID;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_ACID;
    }

    @Override
    public Item getBucketItem() {
        return ModFluids.ACID_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModFluids.ACID_BLOCK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override
    public boolean isStill(FluidState state) {
        return false;
    }

    public static class Flowing extends AcidFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
            BlockPos blockPos = pos.up();
            if (world.getBlockState(blockPos).isAir() && !world.getBlockState(blockPos).isOpaqueFullCube(world, blockPos)) {
                if (random.nextInt(20) == 0) {
                    double d = (double)pos.getX() + random.nextDouble();
                    double e = (double)pos.getY() + 1.0;
                    double f = (double)pos.getZ() + random.nextDouble();
                    world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0, 0.0, 0.0);
                    world.playSound(d, e, f, SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS, 0.2f + random.nextFloat() * 0.2f, 0.9f + random.nextFloat() * 0.15f, false);
                }
                if (random.nextInt(200) == 0) {
                    world.playSound(pos.getX(), (double)pos.getY(), (double)pos.getZ(), SoundEvents.BLOCK_LAVA_AMBIENT, SoundCategory.BLOCKS, 0.2f + random.nextFloat() * 0.2f, 0.9f + random.nextFloat() * 0.15f, false);
                }
            }
        }

        @Override
        @Nullable
        public ParticleEffect getParticle() {
            return ParticleTypes.GLOW;
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends AcidFluid {
        @Override
        public int getLevel(FluidState state) {
            return 8;
        }
        public boolean isStill(FluidState state) {
            return true;
        }
    }

}
