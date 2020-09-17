package mrp_v2.infinitedark.util;

import mrp_v2.infinitedark.InfiniteDark;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Util
{
    public static ResourceLocation makeLoc(String... parts)
    {
        return new ResourceLocation(InfiniteDark.ID, String.join("", parts));
    }

    public static <T extends IForgeRegistryEntry<T>> String getId(ForgeRegistryEntry<T> entry)
    {
        return entry.getRegistryName().getPath();
    }
}
