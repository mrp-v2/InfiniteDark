package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.mrplibrary.datagen.DataGeneratorHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = InfiniteDark.ID, bus = Mod.EventBusSubscriber.Bus.MOD) public class DataGenHandler
{
    @SubscribeEvent public static void registerDataProviders(final GatherDataEvent event)
    {
        DataGeneratorHelper helper = new DataGeneratorHelper(event, InfiniteDark.ID);
        helper.addLootTables(new LootTables());
        helper.addRecipeProvider(RecipeGenerator::new);
        helper.addItemTagsProvider(ItemTagGenerator::new);
        helper.addBlockStateProvider(BlockStateGenerator::new);
        helper.addItemModelProvider(ItemModelGenerator::new);
        helper.addLanguageProvider(EN_USTranslationGenerator::new);
    }
}
