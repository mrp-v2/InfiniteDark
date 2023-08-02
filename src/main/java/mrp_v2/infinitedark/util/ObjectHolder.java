package mrp_v2.infinitedark.util;

import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.infinitedark.block.DarkBlock;
import mrp_v2.infinitedark.block.DarkGlassBlock;
import mrp_v2.infinitedark.block.DarkSlabBlock;
import mrp_v2.infinitedark.block.DarkStairsBlock;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.tags.ITag;

public class ObjectHolder {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, InfiniteDark.ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, InfiniteDark.ID);
    public static final CreativeModeTab DARK_ITEM_GROUP;

    public static ITag<Item> GetDarkItemsTag() {
        if (DARK_ITEMS_TAG == null) {
            DARK_ITEMS_TAG = ForgeRegistries.ITEMS.tags().getTag(TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(), Util.makeLoc("dark")));
        }
        return DARK_ITEMS_TAG;
    }

    private static ITag<Item> DARK_ITEMS_TAG = null;
    public static final RegistryObject<DarkBlock> DARK_BLOCK;
    public static final RegistryObject<BlockItem> DARK_BLOCK_ITEM;
    public static final RegistryObject<DarkSlabBlock> DARK_SLAB_BLOCK;
    public static final RegistryObject<BlockItem> DARK_SLAB_BLOCK_ITEM;
    public static final RegistryObject<DarkStairsBlock> DARK_STAIRS_BLOCK;
    public static final RegistryObject<BlockItem> DARK_STAIRS_BLOCK_ITEM;
    public static final RegistryObject<DarkGlassBlock> DARK_GLASS_BLOCK;
    public static final RegistryObject<BlockItem> DARK_GLASS_BLOCK_ITEM;

    static {
        DARK_ITEM_GROUP = new CreativeModeTab("dark") {
            @OnlyIn(Dist.CLIENT)
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(DARK_BLOCK.get());
            }
        };
        DARK_BLOCK = BLOCKS.register(DarkBlock.ID, DarkBlock::new);
        DARK_BLOCK_ITEM = ITEMS.register(DarkBlock.ID, () -> createBlockItem(DARK_BLOCK.get()));
        DARK_SLAB_BLOCK = BLOCKS.register(DarkSlabBlock.ID, DarkSlabBlock::new);
        DARK_SLAB_BLOCK_ITEM = ITEMS.register(DarkSlabBlock.ID, () -> createBlockItem(DARK_SLAB_BLOCK.get()));
        DARK_STAIRS_BLOCK = BLOCKS.register(DarkStairsBlock.ID, DarkStairsBlock::new);
        DARK_STAIRS_BLOCK_ITEM = ITEMS.register(DarkStairsBlock.ID, () -> createBlockItem(DARK_STAIRS_BLOCK.get()));
        DARK_GLASS_BLOCK = BLOCKS.register(DarkGlassBlock.ID, DarkGlassBlock::new);
        DARK_GLASS_BLOCK_ITEM = ITEMS.register(DarkGlassBlock.ID, () -> createBlockItem(DARK_GLASS_BLOCK.get()));
    }

    public static void registerListeners(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }

    private static BlockItem createBlockItem(Block block) {
        return new BlockItem(block, new Item.Properties().tab(DARK_ITEM_GROUP));
    }
}
