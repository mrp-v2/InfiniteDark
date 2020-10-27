package mrp_v2.infinitedark.block;

import mrp_v2.infinitedark.util.ObjectHolder;
import mrp_v2.infinitedark.util.Util;
import net.minecraft.block.SlabBlock;
import net.minecraft.util.ResourceLocation;

public class DarkSlabBlock extends SlabBlock
{
    public static final ResourceLocation ID = Util.makeLoc(DarkBlock.ID.getPath() + "_slab");

    public DarkSlabBlock()
    {
        super(Properties.from(ObjectHolder.DARK_BLOCK));
        this.setRegistryName(ID);
    }
}
