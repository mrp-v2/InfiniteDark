package mrp_v2.infinitedark.util;

import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.infinitedark.block.DarkBlock;
import mrp_v2.infinitedark.block.DarkGlassBlock;
import mrp_v2.infinitedark.block.DarkSlabBlock;
import mrp_v2.infinitedark.block.DarkStairsBlock;
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

import java.util.function.BiFunction;
import java.util.function.Function;

@Mod.EventBusSubscriber(modid = InfiniteDark.ID, bus = Mod.EventBusSubscriber.Bus.MOD) public class ObjectHolder
{
    public static final ItemGroup DARK_ITEM_GROUP;
    public static final Tags.IOptionalNamedTag<Item> DARK_ITEMS_TAG = ItemTags.createOptional(Util.makeLoc("dark"));
    public static final DarkBlock DARK_BLOCK;
    public static final BlockItem DARK_BLOCK_ITEM;
    public static final DarkSlabBlock DARK_SLAB_BLOCK;
    public static final BlockItem DARK_SLAB_BLOCK_ITEM;
    public static final DarkStairsBlock DARK_STAIRS_BLOCK;
    public static final BlockItem DARK_STAIRS_BLOCK_ITEM;
    public static final DarkGlassBlock DARK_GLASS_BLOCK;
    public static final BlockItem DARK_GLASS_BLOCK_ITEM;

    static
    {
        DARK_BLOCK = new DarkBlock();
        DARK_ITEM_GROUP = new ItemGroup("dark")
        {
            @OnlyIn(Dist.CLIENT) @Override public ItemStack createIcon()
            {
                return new ItemStack(DARK_BLOCK);
            }
        };
        DARK_BLOCK_ITEM = createBlockItem(DARK_BLOCK, BlockItem::new);
        DARK_SLAB_BLOCK = new DarkSlabBlock();
        DARK_SLAB_BLOCK_ITEM = createBlockItem(DARK_SLAB_BLOCK, BlockItem::new);
        DARK_STAIRS_BLOCK = new DarkStairsBlock();
        DARK_STAIRS_BLOCK_ITEM = createBlockItem(DARK_STAIRS_BLOCK, BlockItem::new);
        DARK_GLASS_BLOCK = new DarkGlassBlock();
        DARK_GLASS_BLOCK_ITEM = createBlockItem(DARK_GLASS_BLOCK, BlockItem::new);
    }

    @SubscribeEvent public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(DARK_BLOCK, DARK_SLAB_BLOCK, DARK_STAIRS_BLOCK, DARK_GLASS_BLOCK);
    }

    @SubscribeEvent public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry()
                .registerAll(DARK_BLOCK_ITEM, DARK_SLAB_BLOCK_ITEM, DARK_STAIRS_BLOCK_ITEM, DARK_GLASS_BLOCK_ITEM);
    }

    private static <T extends BlockItem> T createBlockItem(Block block,
            BiFunction<Block, Item.Properties, T> constructor)
    {
        return createBlockItem(block, (properties) -> properties, constructor);
    }

    private static <T extends BlockItem> T createBlockItem(Block block,
            Function<Item.Properties, Item.Properties> properties, BiFunction<Block, Item.Properties, T> constructor)
    {
        T item = constructor.apply(block, properties.apply(new Item.Properties().group(DARK_ITEM_GROUP)));
        item.setRegistryName(block.getRegistryName());
        return item;
    }
}
