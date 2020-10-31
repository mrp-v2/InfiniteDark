package mrp_v2.infinitedark.client.util;

import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.infinitedark.util.ObjectHolder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = InfiniteDark.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventHandler
{
    @SubscribeEvent public static void clientSetup(final FMLClientSetupEvent event)
    {
        RenderTypeLookup.setRenderLayer(ObjectHolder.DARK_GLASS_BLOCK, RenderType.getCutout());
        ClientRegistry.registerKeyBinding(mrp_v2.infinitedark.client.util.ObjectHolder.DARK_TOGGLE);
    }
}
