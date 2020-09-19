package mrp_v2.infinitedark.util;

import mrp_v2.infinitedark.InfiniteDark;
import net.minecraft.util.ResourceLocation;

public class Util
{
    public static ResourceLocation makeLoc(String parts)
    {
        return new ResourceLocation(InfiniteDark.ID, parts);
    }
}
