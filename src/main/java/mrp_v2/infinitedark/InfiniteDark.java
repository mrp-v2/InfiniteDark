package mrp_v2.infinitedark;

import mrp_v2.infinitedark.config.ClientConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(InfiniteDark.ID) public class InfiniteDark
{
    public static final String ID = "infinite" + "dark";

    public InfiniteDark()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.INSTANCE_SPEC);
    }
}
