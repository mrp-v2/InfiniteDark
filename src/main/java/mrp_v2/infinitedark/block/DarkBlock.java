package mrp_v2.infinitedark.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class DarkBlock extends Block
{
    public static final Block PARENT_BLOCK = Blocks.BLACK_CONCRETE;
    public static final String ID = "dark";
    public static Supplier<Properties> BASIC_PROPERTIES =
            () -> Properties.copy(PARENT_BLOCK).isValidSpawn(Blocks::never);

    public DarkBlock()
    {
        super(BASIC_PROPERTIES.get());
    }
}
