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

public class RecipeGenerator extends mrp_v2.mrp_v2datagenlibrary.datagen.RecipeGenerator
{
    protected RecipeGenerator(DataGenerator dataGeneratorIn, String modId)
    {
        super(dataGeneratorIn, modId);
    }

    @Override protected void registerRecipes(Consumer<IFinishedRecipe> iFinishedRecipeConsumer)
    {
        Ingredient cobble = Ingredient.fromTag(Tags.Items.COBBLESTONE);
        ArrayList<Ingredient> acceptedBlackDyes = new ArrayList<>();
        acceptedBlackDyes.add(Ingredient.fromTag(Tags.Items.DYES_BLACK));
        acceptedBlackDyes.add(Ingredient.fromItems(Items.COAL, Items.CHARCOAL));
        Ingredient blacks = Ingredient.merge(acceptedBlackDyes);
        InventoryChangeTrigger.Instance hasDarkBlock = hasItem(ObjectHolder.DARK_BLOCK.get());
        ShapelessRecipeBuilder.shapelessRecipe(ObjectHolder.DARK_BLOCK.get(), 8)
                .addIngredient(cobble, 8)
                .addIngredient(blacks)
                .addCriterion("has_cobble", hasItem(Tags.Items.COBBLESTONE))
                .build(iFinishedRecipeConsumer);
        ShapedRecipeBuilder.shapedRecipe(ObjectHolder.DARK_SLAB_BLOCK.get(), 6)
                .patternLine("###")
                .key('#', ObjectHolder.DARK_BLOCK.get())
                .addCriterion("has_dark_block", hasDarkBlock)
                .build(iFinishedRecipeConsumer);
        ShapedRecipeBuilder.shapedRecipe(ObjectHolder.DARK_STAIRS_BLOCK.get(), 4)
                .patternLine("#  ")
                .patternLine("## ")
                .patternLine("###")
                .key('#', ObjectHolder.DARK_BLOCK.get())
                .addCriterion("has_dark_block", hasDarkBlock)
                .build(iFinishedRecipeConsumer);
        ShapelessRecipeBuilder.shapelessRecipe(ObjectHolder.DARK_GLASS_BLOCK.get(), 6)
                .addIngredient(ObjectHolder.DARK_BLOCK.get())
                .addIngredient(Blocks.GLASS, 5)
                .addCriterion("has_dark_block", hasDarkBlock)
                .build(iFinishedRecipeConsumer);
    }
}
