package mrp_v2.infinitedark.client.util;

import mrp_v2.infinitedark.InfiniteDark;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class ObjectHolder
{
    public static final KeyBinding DARK_TOGGLE =
            new KeyBinding(InfiniteDark.ID + ".keybind.toggleDark", GLFW.GLFW_KEY_V,
                    InfiniteDark.ID + ".keybind.category");
}
