package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.mrp_v2datagenlibrary.datagen.DataGeneratorHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = InfiniteDark.ID, bus = Mod.EventBusSubscriber.Bus.MOD) public class DataGenHandler
{
    @SubscribeEvent public static void registerDataProviders(final GatherDataEvent event)
    {
        DataGeneratorHelper helper = new DataGeneratorHelper(event, InfiniteDark.ID);
        if (event.includeServer())
        {
            helper.addLootTables(new LootTables());
            helper.addRecipeGenerator(RecipeGenerator::new);
            helper.addItemTagGenerator(ItemTagGenerator::new);
        }
        if (event.includeClient())
        {
            helper.addBlockStateProvider(BlockStateGenerator::new);
            helper.addItemModelProvider(ItemModelGenerator::new);
            helper.addLanguageProvider(EN_USTranslationGenerator::new);
        }
    }
}
