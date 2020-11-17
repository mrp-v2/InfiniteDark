package mrp_v2.infinitedark.client.renderer.color;

import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.infinitedark.client.util.DarkItemChecker;
import mrp_v2.infinitedark.config.ClientConfig;
import mrp_v2.infinitedark.util.ObjectHolder;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = InfiniteDark.ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
@OnlyIn(Dist.CLIENT) public class DarkBlockColorer implements IBlockColor, IItemColor
{
    private static final DarkBlockColorer INSTANCE = new DarkBlockColorer();

    @SubscribeEvent public static void registerBlockColors(ColorHandlerEvent.Block event)
    {
        event.getBlockColors()
                .register(INSTANCE, ObjectHolder.DARK_BLOCK.get(), ObjectHolder.DARK_SLAB_BLOCK.get(),
                        ObjectHolder.DARK_STAIRS_BLOCK.get(), ObjectHolder.DARK_GLASS_BLOCK.get());
    }

    @SubscribeEvent public static void registerItemColors(ColorHandlerEvent.Item event)
    {
        event.getItemColors()
                .register(INSTANCE, ObjectHolder.DARK_BLOCK_ITEM.get(), ObjectHolder.DARK_SLAB_BLOCK_ITEM.get(),
                        ObjectHolder.DARK_STAIRS_BLOCK_ITEM.get(), ObjectHolder.DARK_GLASS_BLOCK_ITEM.get());
    }

    @Override
    public int getColor(BlockState blockState, @Nullable IBlockDisplayReader iBlockDisplayReader,
            @Nullable BlockPos pos, int tint)
    {
        return getColor();
    }

    private static int getColor()
    {
        return DarkItemChecker.isModifyingDark() ? ClientConfig.INSTANCE.getColor() : 0;
    }

    @Override public int getColor(ItemStack p_getColor_1_, int p_getColor_2_)
    {
        return getColor();
    }
}
