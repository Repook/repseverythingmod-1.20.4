package repook.repseverythingmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import repook.repseverythingmod.sound.ModSounds;

public class ConchShellBlock extends Block {
    private static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(1, 0, 5, 15, 6, 11);
    private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(5, 0, 0, 11, 6, 15);
    private static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(1, 0, 5, 15, 6, 11);
    private static final VoxelShape SHAPE_WEST = Block.createCuboidShape(5, 0, 0, 11, 6, 15);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(Properties.HORIZONTAL_FACING);

        // Choose the appropriate shape based on the facing direction
        VoxelShape shape;
        switch (facing) {
            case NORTH:
                shape = SHAPE_NORTH;
                break;
            case EAST:
                shape = SHAPE_EAST;
                break;
            case SOUTH:
                shape = SHAPE_SOUTH;
                break;
            case WEST:
                shape = SHAPE_WEST;
                break;
            default:
                shape = SHAPE_NORTH; // Default to a shape if facing direction is not recognized
                break;
        }

        return VoxelShapes.cuboid(shape.getBoundingBox());
    }


    public static final BooleanProperty SOUND_PLAYED;


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient){
            world.playSound(pos.getX(),pos.getY(),pos.getZ(),ModSounds.ITEM_CONCH_SHELL,SoundCategory.BLOCKS,0.5F,1,false);
        }


        return super.onUse(state, world, pos, player, hand, hit);
    }

    public ConchShellBlock(Settings settings) {
        super(settings);
    }

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    static {
        SOUND_PLAYED = ConchShellBlock.SOUND_PLAYED;
    }

}
