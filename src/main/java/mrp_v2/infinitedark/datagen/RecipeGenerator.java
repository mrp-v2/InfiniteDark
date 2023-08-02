package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.util.ObjectHolder;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.ArrayList;
import java.util.function.Consumer;

public class RecipeGenerator extends mrp_v2.mrplibrary.datagen.providers.RecipeProvider
{
    protected RecipeGenerator(DataGenerator dataGeneratorIn, String modId)
    {
        super(dataGeneratorIn, modId);
    }

    @Override protected void buildShapelessRecipes(Consumer<IFinishedRecipe> iFinishedRecipeConsumer)
    {
        Ingredient cobble = Ingredient.of(Tags.Items.COBBLESTONE);
        ArrayList<Ingredient> acceptedBlackDyes = new ArrayList<>();
        acceptedBlackDyes.add(Ingredient.of(Tags.Items.DYES_BLACK));
        acceptedBlackDyes.add(Ingredient.of(Items.COAL, Items.CHARCOAL));
        Ingredient blacks = Ingredient.merge(acceptedBlackDyes);
        InventoryChangeTrigger.Instance hasDarkBlock = has(ObjectHolder.DARK_BLOCK.get());
        ShapelessRecipeBuilder.shapeless(ObjectHolder.DARK_BLOCK.get(), 8)
                .requires(cobble, 8)
                .requires(blacks)
                .unlockedBy("has_cobble", has(Tags.Items.COBBLESTONE))
                .save(iFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ObjectHolder.DARK_SLAB_BLOCK.get(), 6)
                .pattern("###")
                .define('#', ObjectHolder.DARK_BLOCK.get())
                .unlockedBy("has_dark_block", hasDarkBlock)
                .save(iFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ObjectHolder.DARK_STAIRS_BLOCK.get(), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ObjectHolder.DARK_BLOCK.get())
                .unlockedBy("has_dark_block", hasDarkBlock)
                .save(iFinishedRecipeConsumer);
        ShapelessRecipeBuilder.shapeless(ObjectHolder.DARK_GLASS_BLOCK.get(), 6)
                .requires(ObjectHolder.DARK_BLOCK.get())
                .requires(Blocks.GLASS, 5)
                .unlockedBy("has_dark_block", hasDarkBlock)
                .save(iFinishedRecipeConsumer);
    }
}
