package com.professional.micromaster.facebookrecipesapp.recipelist;

import com.professional.micromaster.facebookrecipesapp.entities.Recipe;

/**
 * Created by Roberto on 27/06/17.
 */

public interface RecipeListRepository {
    void getSavedRecipes();
    void updateRecipe(Recipe recipe);
    void removeRecipe(Recipe recipe);
}
