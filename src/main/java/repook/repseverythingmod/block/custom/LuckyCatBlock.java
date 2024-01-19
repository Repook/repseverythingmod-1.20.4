package repook.repseverythingmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import repook.repseverythingmod.block.entity.LuckyCatEntity;
import software.bernie.example.block.GeckoHabitatBlock;
import software.bernie.example.block.entity.GeckoHabitatBlockEntity;
import software.bernie.example.client.model.block.GeckoHabitatModel;
import software.bernie.example.client.renderer.block.GeckoHabitatBlockRenderer;

public class LuckyCatBlock extends BlockWithEntity{

    private static final VoxelShape SHAPE = Block.createCuboidShape(5, 0, 5, 11, 13, 11);

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public LuckyCatBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }



    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LuckyCatEntity(pos,state);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }





    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
