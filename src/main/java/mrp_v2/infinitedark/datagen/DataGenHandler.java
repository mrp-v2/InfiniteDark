package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.InfiniteDark;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = InfiniteDark.ID, bus = Mod.EventBusSubscriber.Bus.MOD) public class DataGenHandler
{
    @SubscribeEvent public static void registerDataProviders(final GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        if (event.includeServer())
        {
            generator.addProvider(new LootTableGenerator(generator));
            generator.addProvider(new RecipeGenerator(generator));
            BlockTagsProvider blockTagsProvider = new BlockTagsProvider(generator, InfiniteDark.ID, fileHelper);
            generator.addProvider(new ItemTagGenerator(generator, blockTagsProvider, fileHelper));
        }
        if (event.includeClient())
        {
            generator.addProvider(new BlockModelGenerator(generator, fileHelper));
            generator.addProvider(new BlockStateGenerator(generator, fileHelper));
            generator.addProvider(new ItemModelGenerator(generator, fileHelper));
        }
    }
}
