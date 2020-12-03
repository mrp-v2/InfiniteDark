package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.block.DarkGlassBlock;
import mrp_v2.infinitedark.util.ObjectHolder;
import mrp_v2.mrplibrary.datagen.providers.BlockStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;

public class BlockStateGenerator extends BlockStateProvider
{
    public static final HashMap<Direction, Pair<Integer, Integer>> FACE_ROTATION_MAP;

    static
    {
        FACE_ROTATION_MAP = new HashMap<>();
        FACE_ROTATION_MAP.put(Direction.NORTH, Pair.of(0, 0));
        FACE_ROTATION_MAP.put(Direction.EAST, Pair.of(0, 90));
        FACE_ROTATION_MAP.put(Direction.SOUTH, Pair.of(0, 180));
        FACE_ROTATION_MAP.put(Direction.WEST, Pair.of(0, -90));
        FACE_ROTATION_MAP.put(Direction.UP, Pair.of(-90, 0));
        FACE_ROTATION_MAP.put(Direction.DOWN, Pair.of(90, 0));
    }

    public BlockStateGenerator(DataGenerator gen, String modid, ExistingFileHelper exFileHelper)
    {
        super(gen, modid, exFileHelper);
    }

    @Override protected void registerStatesAndModels()
    {
        final ResourceLocation darkTexLoc = modLoc("block/dark");
        simpleBlock(ObjectHolder.DARK_BLOCK.get(),
                cubeAllTinted(ObjectHolder.DARK_BLOCK.getId().getPath(), darkTexLoc));
        slabBlockTinted(ObjectHolder.DARK_SLAB_BLOCK.get(), darkTexLoc, darkTexLoc);
        stairsBlockTinted(ObjectHolder.DARK_STAIRS_BLOCK.get(), darkTexLoc);
        ModelFile baseDarkGlassModel = this.models().withExistingParent(DarkGlassBlock.ID, mcLoc("block/block"))
                .texture("particle", darkTexLoc).texture("glass", mcLoc("block/glass")).texture("dark", darkTexLoc)
                .element().from(0, 0, 0).to(16, 16, 16)
                .allFaces((face, builder) -> builder.texture("#glass").cullface(face)).face(Direction.NORTH)
                .texture("#dark").tintindex(0).end().end();
        VariantBlockStateBuilder darkGlassVariantBuilder = this.getVariantBuilder(ObjectHolder.DARK_GLASS_BLOCK.get());
        for (Direction dir : Direction.values())
        {
            darkGlassVariantBuilder.partialState().with(BlockStateProperties.FACING, dir).modelForState()
                    .rotationX(FACE_ROTATION_MAP.get(dir).getLeft()).rotationY(FACE_ROTATION_MAP.get(dir).getRight())
                    .modelFile(baseDarkGlassModel).addModel();
        }
    }
}
