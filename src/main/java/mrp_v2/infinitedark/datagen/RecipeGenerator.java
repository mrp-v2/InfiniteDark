package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.infinitedark.util.ObjectHolder;
import mrp_v2.infinitedark.util.Util;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapelessRecipeBuilder;
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
        ShapelessRecipeBuilder.shapelessRecipe(ObjectHolder.DARK_BLOCK, 8)
                .addIngredient(cobble, 8)
                .addIngredient(blacks)
                .setGroup(Util.getId(ObjectHolder.DARK_BLOCK))
                .addCriterion("has_cobble", hasItem(Tags.Items.COBBLESTONE))
                .build(iFinishedRecipeConsumer);
    }

    @Override public String getName()
    {
        return super.getName() + ": " + InfiniteDark.ID;
    }
}
