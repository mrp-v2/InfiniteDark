package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.infinitedark.util.ObjectHolder;
import mrp_v2.infinitedark.util.Util;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelGenerator extends ItemModelProvider
{
    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, InfiniteDark.ID, existingFileHelper);
    }

    @Override protected void registerModels()
    {
        this.withExistingParent(Util.getId(ObjectHolder.DARK_BLOCK_ITEM),
                Util.makeLoc("block/" + Util.getId(ObjectHolder.DARK_BLOCK)));
    }
}
