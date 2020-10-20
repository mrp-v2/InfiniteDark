package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.block.DarkBlock;
import mrp_v2.infinitedark.block.DarkSlabBlock;
import mrp_v2.infinitedark.util.Util;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelGenerator extends ItemModelProvider
{
    public ItemModelGenerator(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper)
    {
        super(generator, modid, existingFileHelper);
    }

    @Override protected void registerModels()
    {
        this.withExistingParent(DarkBlock.ID.getPath(), Util.makeLoc("block/" + DarkBlock.ID.getPath()));
        this.withExistingParent(DarkSlabBlock.ID.getPath(), Util.makeLoc("block/" + DarkSlabBlock.ID.getPath()));
    }
}
