package mrp_v2.infinitedark.block;

import mrp_v2.infinitedark.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ResourceLocation;

public class DarkGlassBlock extends Block
{
    public static final ResourceLocation ID = Util.makeLoc(DarkBlock.ID.getPath() + "_glass");

    public DarkGlassBlock()
    {
        super(Properties.from(DarkBlock.PARENT_BLOCK));
        this.setRegistryName(ID);
    }

    @Override protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(BlockStateProperties.NORTH, BlockStateProperties.EAST, BlockStateProperties.SOUTH,
                BlockStateProperties.WEST, BlockStateProperties.UP, BlockStateProperties.DOWN);
    }
}
