package com.professional.micromaster.facebookrecipesapp.recipemain;

import com.professional.micromaster.facebookrecipesapp.entities.Recipe;

/**
 * Created by Roberto on 26/06/17.
 */

public interface RecipeMainRepository {
    public final static int COUNT = 1;
    public final static int RECIPE_RANGE = 100000;
    public final static String RECENT_SORT = "r";

    void getNextRecipe();
    void saveRecipe(Recipe recipe);
    void setRecipePage(int recipePage);
}
