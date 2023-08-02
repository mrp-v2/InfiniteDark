package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.util.ObjectHolder;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ItemTagGenerator extends mrp_v2.mrplibrary.datagen.providers.ItemTagsProvider
{
    public ItemTagGenerator(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, String modId,
            @Nullable ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, blockTagProvider, modId, existingFileHelper);
    }

    @Override protected void addTags()
    {
        this.tag(ObjectHolder.DARK_ITEMS_TAG)
                .add(ObjectHolder.DARK_BLOCK_ITEM.get(), ObjectHolder.DARK_SLAB_BLOCK_ITEM.get(),
                        ObjectHolder.DARK_STAIRS_BLOCK_ITEM.get(), ObjectHolder.DARK_GLASS_BLOCK_ITEM.get());
    }
}
