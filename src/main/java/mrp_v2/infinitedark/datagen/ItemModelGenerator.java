package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.block.DarkBlock;
import mrp_v2.infinitedark.block.DarkGlassBlock;
import mrp_v2.infinitedark.block.DarkSlabBlock;
import mrp_v2.infinitedark.block.DarkStairsBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelGenerator extends ItemModelProvider
{
    public ItemModelGenerator(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper)
    {
        super(generator, modid, existingFileHelper);
    }

    @Override protected void registerModels()
    {
        this.simpleWithExistingParent(DarkBlock.ID);
        this.simpleWithExistingParent(DarkSlabBlock.ID);
        this.simpleWithExistingParent(DarkStairsBlock.ID);
        this.simpleWithExistingParent(DarkGlassBlock.ID);
    }

    private ModelBuilder<ItemModelBuilder> simpleWithExistingParent(String path)
    {
        return this.withExistingParent(path, modLoc("block/" + path));
    }
}
