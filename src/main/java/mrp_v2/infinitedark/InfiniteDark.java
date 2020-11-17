package mrp_v2.infinitedark;

import mrp_v2.infinitedark.config.ClientConfig;
import mrp_v2.infinitedark.util.ObjectHolder;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(InfiniteDark.ID) public class InfiniteDark
{
    public static final String ID = "infinite" + "dark";

    public InfiniteDark()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.INSTANCE_SPEC);
        ObjectHolder.registerListeners(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
