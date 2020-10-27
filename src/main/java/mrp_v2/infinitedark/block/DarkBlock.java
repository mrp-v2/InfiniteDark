package mrp_v2.infinitedark.block;

import mrp_v2.infinitedark.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;

public class DarkBlock extends Block
{
    public static final Block PARENT_BLOCK = Blocks.BLACK_CONCRETE;
    public static final ResourceLocation ID = Util.makeLoc("dark");

    public DarkBlock()
    {
        super(Properties.from(PARENT_BLOCK).setAllowsSpawn(Blocks::neverAllowSpawn));
        this.setRegistryName(ID);
    }
}
