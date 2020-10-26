package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.util.ObjectHolder;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ItemTagGenerator extends mrp_v2.mrp_v2datagenlibrary.datagen.ItemTagGenerator
{
    public ItemTagGenerator(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, String modId,
            @Nullable ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, blockTagProvider, modId, existingFileHelper);
    }

    @Override protected void registerTags()
    {
        this.getOrCreateBuilder(ObjectHolder.DARK_ITEMS_TAG)
                .add(ObjectHolder.DARK_BLOCK_ITEM, ObjectHolder.DARK_SLAB_BLOCK_ITEM,
                        ObjectHolder.DARK_STAIRS_BLOCK_ITEM, ObjectHolder.DARK_GLASS_BLOCK_ITEM);
    }
}
