package mrp_v2.infinitedark.util;

import mrp_v2.infinitedark.InfiniteDark;
import net.minecraft.resources.ResourceLocation;

public class Util
{
    public static ResourceLocation makeLoc(String path)
    {
        return new ResourceLocation(InfiniteDark.ID, path);
    }
}
