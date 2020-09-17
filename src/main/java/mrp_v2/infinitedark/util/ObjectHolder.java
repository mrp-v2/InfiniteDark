package mrp_v2.infinitedark.util;

import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.infinitedark.block.DarkBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InfiniteDark.ID, bus = Mod.EventBusSubscriber.Bus.MOD) public class ObjectHolder
{
    public static final DarkBlock DARK_BLOCK;
    public static final ItemGroup DARK_ITEM_GROUP;
    public static final BlockItem DARK_BLOCK_ITEM;
    public static final Tags.IOptionalNamedTag<Item> DARK_ITEMS_TAG = ItemTags.createOptional(Util.makeLoc("dark"));

    static
    {
        DARK_ITEM_GROUP = new ItemGroup("dark")
        {
            @OnlyIn(Dist.CLIENT) @Override public ItemStack createIcon()
            {
                return new ItemStack(DARK_BLOCK);
            }
        };
        DARK_BLOCK = new DarkBlock();
        DARK_BLOCK_ITEM = DARK_BLOCK.createItem();
    }

    @SubscribeEvent public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(ObjectHolder.DARK_BLOCK);
    }

    @SubscribeEvent public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(ObjectHolder.DARK_BLOCK_ITEM);
    }
}
