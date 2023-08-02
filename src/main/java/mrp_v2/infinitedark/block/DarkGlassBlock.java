package mrp_v2.infinitedark.block;

import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

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

    @Nullable @Override public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return super.getStateForPlacement(context)
                .setValue(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite());
    }

    @Override protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(BlockStateProperties.FACING);
    }

    @Override public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos)
    {
        if (state.getValue(BlockStateProperties.FACING) == Direction.UP)
        {
            return false;
        }
        return super.propagatesSkylightDown(state, reader, pos);
    }
}
