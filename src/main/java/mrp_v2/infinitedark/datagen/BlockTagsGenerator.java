package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.util.ObjectHolder;
import mrp_v2.mrplibrary.datagen.providers.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class BlockTagsGenerator extends BlockTagsProvider {
    public BlockTagsGenerator(DataGenerator generatorIn, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ObjectHolder.DARK_BLOCK.get())
                .add(ObjectHolder.DARK_GLASS_BLOCK.get())
                .add(ObjectHolder.DARK_SLAB_BLOCK.get())
                .add(ObjectHolder.DARK_STAIRS_BLOCK.get());
    }
}
