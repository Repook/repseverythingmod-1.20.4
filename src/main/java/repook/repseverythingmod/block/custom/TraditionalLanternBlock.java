package repook.repseverythingmod.block.custom;

import net.minecraft.block.*;
import net.minecraft.client.render.entity.model.DragonHeadEntityModel;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import repook.repseverythingmod.block.ModBlocks;

public class TraditionalLanternBlock extends Block {


    private static final VoxelShape SHAPE = Block.createCuboidShape(2, 9, 2, 14, 16, 14);

    public static DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public TraditionalLanternBlock(Settings settings) {
        super(settings);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }


    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();
        Direction playerFacing = ctx.getHorizontalPlayerFacing().getOpposite();

        // Check if the block can be placed at the given position
        if (isValidPlacement(world, pos, playerFacing)) {
            return this.getDefaultState().with(FACING, playerFacing);
        }

        // Return null to indicate the block cannot be placed here
        return null;
    }

    private boolean isValidPlacement(World world, BlockPos pos, Direction playerFacing) {
        BlockPos topPos = pos.up();
        BlockPos bottomPos = pos.down();

        BlockState bottomBlockState = world.getBlockState(topPos);


        return world.getBlockState(topPos).isSolidBlock(world, bottomPos) &&
                bottomBlockState.getBlock() != this;
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        super.onBroken(world, pos, state);


        if (!world.isClient() && !(world instanceof ServerWorld && isCreative((ServerWorld) world))) {

            dropStacks(state, (World) world, pos);
        }
    }


    private boolean isCreative(ServerWorld world) {
        return world.getPlayers().stream().anyMatch(player -> player.interactionManager.isCreative());
    }
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        BlockState updatedState = super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);

        // Check if the block above is air, and the block below is a lantern block
        BlockPos abovePos = pos.up();

        if (direction == Direction.UP && world.getBlockState(abovePos).isAir() && updatedState.getBlock() == this) {
            world.breakBlock(pos, true);
        }

        return updatedState;
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    }

