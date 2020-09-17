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

public class BlockModelGenerator extends BlockModelProvider
{
    public static final ResourceLocation CUBE_TINTED_LOC = Util.makeLoc("block/cube_tinted");
    public static final ResourceLocation CUBE_ALL_TINTED_LOC = Util.makeLoc("block/cube_all_tinted");

    public BlockModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, InfiniteDark.ID, existingFileHelper);
    }

    @Override protected void registerModels()
    {
        this.getBuilder(CUBE_TINTED_LOC.toString())
                .parent(this.getExistingFile(mcLoc("block/block")))
                .element()
                .from(0, 0, 0)
                .to(16, 16, 16)
                .allFaces((direction, builder) -> builder.cullface(direction)
                        .texture("#" + direction.toString())
                        .tintindex(0)
                        .end())
                .end();
        ModelBuilder<BlockModelBuilder> cubeAllTintedBuilder = this.getBuilder(CUBE_ALL_TINTED_LOC.toString())
                .parent(this.getExistingFile(CUBE_TINTED_LOC))
                .texture("particle", "#all");
        for (Direction direction : Direction.values())
        {
            cubeAllTintedBuilder = cubeAllTintedBuilder.texture(direction.toString(), "#all");
        }
    }
}
