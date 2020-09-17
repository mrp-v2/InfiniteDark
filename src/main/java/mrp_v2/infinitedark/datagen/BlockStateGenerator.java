package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.infinitedark.util.ObjectHolder;
import mrp_v2.infinitedark.util.Util;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateGenerator extends BlockStateProvider
{
    public BlockStateGenerator(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, InfiniteDark.ID, exFileHelper);
    }

    @Override protected void registerStatesAndModels()
    {
        this.simpleBlock(ObjectHolder.DARK_BLOCK, this.models()
                .withExistingParent(Util.getId(ObjectHolder.DARK_BLOCK), BlockModelGenerator.CUBE_ALL_TINTED_LOC)
                .texture("all", "block/dark"));
    }
}
