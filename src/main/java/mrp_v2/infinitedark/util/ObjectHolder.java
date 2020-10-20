package mrp_v2.infinitedark.util;

import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.infinitedark.block.DarkBlock;
import mrp_v2.infinitedark.block.DarkSlabBlock;
import mrp_v2.infinitedark.block.DarkStairsBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = InfiniteDark.ID, bus = Mod.EventBusSubscriber.Bus.MOD) public class ObjectHolder
{
    public static final ItemGroup DARK_ITEM_GROUP;
    public static final Tags.IOptionalNamedTag<Item> DARK_ITEMS_TAG = ItemTags.createOptional(Util.makeLoc("dark"));
    public static final RegistryObject<Block> DARK_BLOCK;
    public static final RegistryObject<Item> DARK_BLOCK_ITEM;
    public static final RegistryObject<Block> DARK_SLAB_BLOCK;
    public static final RegistryObject<Item> DARK_SLAB_BLOCK_ITEM;
    public static final RegistryObject<Block> DARK_STAIRS_BLOCK;
    public static final RegistryObject<Item> DARK_STAIRS_BLOCK_ITEM;

    static
    {
        DARK_ITEM_GROUP = new ItemGroup("dark")
        {
            @OnlyIn(Dist.CLIENT) @Override public ItemStack createIcon()
            {
                return new ItemStack(DARK_BLOCK.get());
            }
        };
        DARK_BLOCK = createBlockRegistryObject(DarkBlock.ID);
        DARK_BLOCK_ITEM = createItemRegistryObject(DarkBlock.ID);
        DARK_SLAB_BLOCK = createBlockRegistryObject(DarkSlabBlock.ID);
        DARK_SLAB_BLOCK_ITEM = createItemRegistryObject(DarkSlabBlock.ID);
        DARK_STAIRS_BLOCK = createBlockRegistryObject(DarkStairsBlock.ID);
        DARK_STAIRS_BLOCK_ITEM = createItemRegistryObject(DarkStairsBlock.ID);
    }

    private static RegistryObject<Block> createBlockRegistryObject(ResourceLocation name)
    {
        return createRegistryObject(name, Block.class);
    }

    private static <T extends IForgeRegistryEntry<T>> RegistryObject<T> createRegistryObject(ResourceLocation name,
            Class<T> type)
    {
        return RegistryObject.of(name, type, InfiniteDark.ID);
    }

    private static RegistryObject<Item> createItemRegistryObject(ResourceLocation name)
    {
        return createRegistryObject(name, Item.class);
    }

    @SubscribeEvent public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(new DarkBlock(), new DarkSlabBlock(), new DarkStairsBlock());
    }

    @SubscribeEvent public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry()
                .registerAll(createBlockItem(DARK_BLOCK), createBlockItem(DARK_SLAB_BLOCK),
                        createBlockItem(DARK_STAIRS_BLOCK));
    }

    private static Item createBlockItem(RegistryObject<Block> block)
    {
        return createBlockItem(block, (properties) -> properties);
    }

    private static Item createBlockItem(RegistryObject<Block> block,
            Function<Item.Properties, Item.Properties> properties)
    {
        return createBlockItem(block.get(), properties);
    }

    private static Item createBlockItem(Block block, Function<Item.Properties, Item.Properties> properties)
    {
        return new BlockItem(block, properties.apply(new Item.Properties().group(DARK_ITEM_GROUP))).setRegistryName(
                block.getRegistryName());
    }
}
