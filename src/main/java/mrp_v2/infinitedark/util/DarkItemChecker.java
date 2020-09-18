package mrp_v2.infinitedark.util;

import mrp_v2.infinitedark.InfiniteDark;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InfiniteDark.ID, value = Dist.CLIENT) public class DarkItemChecker
{
    private static boolean oldHasDark = false;

    @SubscribeEvent public static void clientTick(TickEvent.ClientTickEvent event)
    {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        if (player == null)
        {
            return;
        }
        ItemStack[] currentHeldItems = new ItemStack[2];
        currentHeldItems[0] = player.getHeldItemMainhand();
        currentHeldItems[1] = player.getHeldItemOffhand();
        boolean currentHasDark = ObjectHolder.DARK_ITEMS_TAG.contains(currentHeldItems[0].getItem()) ||
                ObjectHolder.DARK_ITEMS_TAG.contains(currentHeldItems[1].getItem());
        if (oldHasDark != currentHasDark)
        {
            oldHasDark = currentHasDark;
            updateDarkBlocks();
        }
    }

    private static void updateDarkBlocks()
    {
        for (ChunkRenderDispatcher.ChunkRender chunkRender : Minecraft.getInstance().worldRenderer.viewFrustum.renderChunks)
        {
            chunkRender.setNeedsUpdate(false);
        }
    }

    public static boolean isHoldingDarkItem()
    {
        return oldHasDark;
    }
}
