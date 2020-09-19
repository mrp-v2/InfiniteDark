package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.infinitedark.util.Util;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.BiConsumer;

public class BlockModelGenerator extends BlockModelProvider
{
    public static final ResourceLocation CUBE_TINTED_LOC = Util.makeLoc("block/cube_tinted");
    public static final ResourceLocation CUBE_ALL_TINTED_LOC = Util.makeLoc("block/cube_all_tinted");
    public static final ResourceLocation SLAB_TINTED_LOC = Util.makeLoc("block/slab_tinted");
    public static final ResourceLocation SLAB_TOP_TINTED_LOC = Util.makeLoc("block/slab_top_tinted");
    private static BiConsumer<Direction, ModelBuilder<BlockModelBuilder>.ElementBuilder.FaceBuilder> tintFunction =
            (direction, builder) -> builder.tintindex(0);

    public BlockModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, InfiniteDark.ID, existingFileHelper);
    }

    @Override protected void registerModels()
    {
        this.registerFullBlockModels();
        this.registerSlabModels();
    }

    private void registerFullBlockModels()
    {
        this.getBuilder(CUBE_TINTED_LOC.toString())
                .parent(this.getExistingFile(mcLoc("block/block")))
                .element()
                .from(0, 0, 0)
                .to(16, 16, 16)
                .allFaces((direction, builder) -> builder.cullface(direction).texture("#" + direction.toString()).end())
                .faces(tintFunction)
                .end();
        ModelBuilder<BlockModelBuilder> cubeAllTintedBuilder = this.getBuilder(CUBE_ALL_TINTED_LOC.toString())
                .parent(this.getExistingFile(CUBE_TINTED_LOC))
                .texture("particle", "#all");
        for (Direction direction : Direction.values())
        {
            cubeAllTintedBuilder = cubeAllTintedBuilder.texture(direction.toString(), "#all");
        }
    }

    private void registerSlabModels()
    {
        ModelBuilder<BlockModelBuilder>.ElementBuilder slabTintedBuilder = this.getBuilder(SLAB_TINTED_LOC.toString())
                .parent(this.getExistingFile(mcLoc("block/block")))
                .texture("particle", "#side")
                .element();
        ModelBuilder<BlockModelBuilder>.ElementBuilder slabTopTintedBuilder =
                this.getBuilder(SLAB_TOP_TINTED_LOC.toString()).texture("particle", "#side").element();
        slabTintedBuilder.from(0, 0, 0)
                .to(16, 8, 16)
                .face(Direction.DOWN)
                .texture("#bottom")
                .cullface(Direction.DOWN)
                .end()
                .face(Direction.UP)
                .texture("#top")
                .end();
        slabTopTintedBuilder.from(0, 8, 0)
                .to(16, 16, 16)
                .face(Direction.DOWN)
                .texture("#bottom")
                .end()
                .face(Direction.UP)
                .texture("#top")
                .cullface(Direction.UP)
                .end();
        BiConsumer<ModelBuilder<BlockModelBuilder>.ElementBuilder, Direction> sideBuilder =
                (builder, side) -> builder.face(side).texture("#side").cullface(side).end();
        for (Direction direction : Direction.Plane.HORIZONTAL)
        {
            sideBuilder.accept(slabTintedBuilder, direction);
            sideBuilder.accept(slabTopTintedBuilder, direction);
        }
        slabTintedBuilder.faces(tintFunction).end();
        slabTopTintedBuilder.faces(tintFunction).end();
    }
}
