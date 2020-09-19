package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.infinitedark.block.DarkBlock;
import mrp_v2.infinitedark.block.DarkSlabBlock;
import mrp_v2.infinitedark.util.ObjectHolder;
import mrp_v2.infinitedark.util.Util;
import net.minecraft.block.SlabBlock;
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
        final String darkTexLoc = "block/dark";
        this.simpleBlock(ObjectHolder.DARK_BLOCK.get(), this.models()
                .withExistingParent(DarkBlock.ID.getPath(), BlockModelGenerator.CUBE_ALL_TINTED_LOC)
                .texture("all", darkTexLoc));
        this.slabBlock((SlabBlock) ObjectHolder.DARK_SLAB_BLOCK.get(),
                models().withExistingParent(DarkSlabBlock.ID.getPath(), BlockModelGenerator.SLAB_TINTED_LOC)
                        .texture("side", darkTexLoc)
                        .texture("top", darkTexLoc)
                        .texture("bottom", darkTexLoc), models().withExistingParent(DarkSlabBlock.ID.getPath() + "_top",
                        BlockModelGenerator.SLAB_TOP_TINTED_LOC)
                        .texture("side", darkTexLoc)
                        .texture("top", darkTexLoc)
                        .texture("bottom", darkTexLoc),
                models().getExistingFile(Util.makeLoc("block/" + DarkBlock.ID.getPath())));
    }
}
