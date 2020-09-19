package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.infinitedark.block.DarkBlock;
import mrp_v2.infinitedark.block.DarkSlabBlock;
import mrp_v2.infinitedark.util.ObjectHolder;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.ArrayList;
import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider
{
    public RecipeGenerator(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override protected void registerRecipes(Consumer<IFinishedRecipe> iFinishedRecipeConsumer)
    {
        Ingredient cobble = Ingredient.fromTag(Tags.Items.COBBLESTONE);
        ArrayList<Ingredient> acceptedBlackDyes = new ArrayList<>();
        acceptedBlackDyes.add(Ingredient.fromTag(Tags.Items.DYES_BLACK));
        acceptedBlackDyes.add(Ingredient.fromItems(Items.COAL, Items.CHARCOAL));
        Ingredient blacks = Ingredient.merge(acceptedBlackDyes);
        ShapelessRecipeBuilder.shapelessRecipe(ObjectHolder.DARK_BLOCK.get(), 8)
                .addIngredient(cobble, 8)
                .addIngredient(blacks)
                .setGroup(DarkBlock.ID.getPath())
                .addCriterion("has_cobble", hasItem(Tags.Items.COBBLESTONE))
                .build(iFinishedRecipeConsumer);
        ShapedRecipeBuilder.shapedRecipe(ObjectHolder.DARK_SLAB_BLOCK.get(), 6)
                .patternLine("###")
                .key('#', ObjectHolder.DARK_BLOCK.get())
                .setGroup(DarkSlabBlock.ID.getPath())
                .addCriterion("has_dark_block", hasItem(ObjectHolder.DARK_BLOCK.get()))
                .build(iFinishedRecipeConsumer);
    }

    @Override public String getName()
    {
        return super.getName() + ": " + InfiniteDark.ID;
    }
}
