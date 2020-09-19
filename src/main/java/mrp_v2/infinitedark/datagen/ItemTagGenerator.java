package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.infinitedark.util.ObjectHolder;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ItemTagGenerator extends ItemTagsProvider
{
    public ItemTagGenerator(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider,
            @Nullable ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, blockTagProvider, InfiniteDark.ID, existingFileHelper);
    }

    @Override protected void registerTags()
    {
        this.getOrCreateBuilder(ObjectHolder.DARK_ITEMS_TAG)
                .add(ObjectHolder.DARK_BLOCK_ITEM.get(), ObjectHolder.DARK_SLAB_BLOCK_ITEM.get());
    }

    @Override public String getName()
    {
        return super.getName() + ": " + InfiniteDark.ID;
    }
}
