package mrp_v2.infinitedark.client.util;

import mrp_v2.infinitedark.InfiniteDark;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class ObjectHolder
{
    public static final KeyMapping DARK_TOGGLE =
            new KeyMapping(InfiniteDark.ID + ".keybind.toggleDark", GLFW.GLFW_KEY_V,
                    InfiniteDark.ID + ".keybind.category");
}
