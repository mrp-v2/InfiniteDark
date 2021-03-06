package mrp_v2.infinitedark.client.util;

import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.infinitedark.config.ClientConfig;
import mrp_v2.infinitedark.util.ObjectHolder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InfiniteDark.ID, value = Dist.CLIENT) public class DarkItemChecker
{
    private static boolean modifyingDark = false;

    @SubscribeEvent public static void clientTick(TickEvent.ClientTickEvent event)
    {
        if (ClientConfig.INSTANCE.useKeyBinding())
        {
            if (!ClientConfig.INSTANCE.keybindToggleMode())
            {
                boolean newModifyingDark = mrp_v2.infinitedark.client.util.ObjectHolder.DARK_TOGGLE.isKeyDown();
                if (modifyingDark != newModifyingDark)
                {
                    modifyingDark = newModifyingDark;
                    updateDarkBlocks();
                }
            }
        } else
        {
            ClientPlayerEntity player = Minecraft.getInstance().player;
            if (player == null)
            {
                return;
            }
            ItemStack[] currentHeldItems = new ItemStack[2];
            currentHeldItems[0] = player.getHeldItemMainhand();
            currentHeldItems[1] = player.getHeldItemOffhand();
            boolean currentHasDark =
                    mrp_v2.infinitedark.util.ObjectHolder.DARK_ITEMS_TAG.contains(currentHeldItems[0].getItem()) ||
                            ObjectHolder.DARK_ITEMS_TAG.contains(currentHeldItems[1].getItem());
            if (modifyingDark != currentHasDark)
            {
                modifyingDark = currentHasDark;
                updateDarkBlocks();
            }
        }
    }

    private static void updateDarkBlocks()
    {
        for (ChunkRenderDispatcher.ChunkRender chunkRender : Minecraft.getInstance().worldRenderer.viewFrustum.renderChunks)
        {
            chunkRender.setNeedsUpdate(false);
        }
    }

    public static boolean isModifyingDark()
    {
        return modifyingDark;
    }

    @SubscribeEvent public static void keyPressed(InputEvent.KeyInputEvent event)
    {
        if (ClientConfig.INSTANCE.useKeyBinding())
        {
            if (mrp_v2.infinitedark.client.util.ObjectHolder.DARK_TOGGLE.isPressed())
            {
                if (ClientConfig.INSTANCE.keybindToggleMode())
                {
                    modifyingDark = !modifyingDark;
                    updateDarkBlocks();
                }
            }
        }
    }
}
