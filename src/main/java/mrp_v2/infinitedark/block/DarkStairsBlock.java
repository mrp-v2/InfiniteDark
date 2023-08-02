package mrp_v2.infinitedark.block;

import mrp_v2.infinitedark.util.ObjectHolder;
import net.minecraft.world.level.block.StairBlock;

public class DarkStairsBlock extends StairBlock
{
    public static final String ID = DarkBlock.ID + "_stairs";

    public DarkStairsBlock()
    {
        super(() -> ObjectHolder.DARK_BLOCK.get().defaultBlockState(), DarkBlock.BASIC_PROPERTIES.get());
    }
}
