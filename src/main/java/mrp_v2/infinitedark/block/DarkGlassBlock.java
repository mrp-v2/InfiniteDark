package mrp_v2.infinitedark.block;

import net.minecraft.world.level.block.AbstractGlassBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;

import javax.annotation.Nullable;

public class DarkGlassBlock extends AbstractGlassBlock
{
    public static final String ID = DarkBlock.ID + "_glass";

    public DarkGlassBlock()
    {
        super(DarkBlock.BASIC_PROPERTIES.get()
                .noOcclusion()
                .isRedstoneConductor(Blocks::never)
                .isSuffocating(Blocks::never)
                .isViewBlocking(Blocks::never));
    }

    @Nullable @Override public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        return super.getStateForPlacement(context)
                .setValue(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite());
    }

    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(BlockStateProperties.FACING);
    }

    @Override public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos)
    {
        if (state.getValue(BlockStateProperties.FACING) == Direction.UP)
        {
            return false;
        }
        return super.propagatesSkylightDown(state, reader, pos);
    }
}
