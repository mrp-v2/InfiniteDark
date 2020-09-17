package mrp_v2.infinitedark.block;

import net.minecraft.block.Blocks;

public class DarkBlock extends BaseBlock
{
    public static final String ID = "dark";

    public DarkBlock()
    {
        super(Properties.from(Blocks.BLACK_CONCRETE), ID);
    }
}
