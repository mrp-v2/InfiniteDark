package mrp_v2.infinitedark.block;

import mrp_v2.infinitedark.InfiniteDark;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InfiniteDark.ID) public class DarkBlock extends BaseBlock
{
    public static final String ID = "dark";

    public DarkBlock()
    {
        super(Properties.from(Blocks.BLACK_CONCRETE), ID);
    }
}
