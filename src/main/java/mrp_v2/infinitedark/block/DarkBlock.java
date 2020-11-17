package mrp_v2.infinitedark.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.function.Supplier;

public class DarkBlock extends Block
{
    public static final Block PARENT_BLOCK = Blocks.BLACK_CONCRETE;
    public static final String ID = "dark";
    public static Supplier<Properties> BASIC_PROPERTIES =
            () -> Properties.from(PARENT_BLOCK).setAllowsSpawn(Blocks::neverAllowSpawn);

    public DarkBlock()
    {
        super(BASIC_PROPERTIES.get());
    }
}
