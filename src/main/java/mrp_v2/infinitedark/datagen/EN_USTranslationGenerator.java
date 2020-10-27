package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.util.ObjectHolder;
import mrp_v2.mrp_v2datagenlibrary.datagen.TranslationGenerator;
import net.minecraft.data.DataGenerator;

public class EN_USTranslationGenerator extends TranslationGenerator
{
    public EN_USTranslationGenerator(DataGenerator gen, String modid)
    {
        super(gen, modid, "en_us");
    }

    @Override protected void addTranslations()
    {
        this.add(ObjectHolder.DARK_BLOCK, "Dark Block");
        this.add(ObjectHolder.DARK_SLAB_BLOCK, "Dark Slab");
        this.add(ObjectHolder.DARK_STAIRS_BLOCK, "Dark Stairs");
        this.add(ObjectHolder.DARK_GLASS_BLOCK, "Dark Glass");
        this.add(ObjectHolder.DARK_ITEM_GROUP, "Infinite Dark");
    }
}
