package mrp_v2.infinitedark.block;

import mrp_v2.infinitedark.util.ObjectHolder;
import mrp_v2.infinitedark.util.Util;
import net.minecraft.block.StairsBlock;
import net.minecraft.util.ResourceLocation;

public class DarkStairsBlock extends StairsBlock
{
    public static final ResourceLocation ID = Util.makeLoc(DarkBlock.ID.getPath() + "_stairs");

    public DarkStairsBlock()
    {
        super(ObjectHolder.DARK_BLOCK.getDefaultState(), Properties.from(ObjectHolder.DARK_BLOCK));
        this.setRegistryName(ID);
    }
}
