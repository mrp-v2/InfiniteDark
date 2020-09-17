package mrp_v2.infinitedark.block;

import mrp_v2.infinitedark.util.ObjectHolder;
import mrp_v2.infinitedark.util.Util;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

abstract public class BaseBlock extends Block
{
    protected BaseBlock(Properties properties, String id)
    {
        super(properties);
        this.setRegistryName(Util.makeLoc(id));
    }

    public BlockItem createItem()
    {
        BlockItem item = new BlockItem(this, getItemProperties());
        item.setRegistryName(this.getRegistryName());
        return item;
    }

    protected Item.Properties getItemProperties()
    {
        return new Item.Properties().group(ObjectHolder.DARK_ITEM_GROUP);
    }
}
