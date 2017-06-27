package com.professional.micromaster.facebookrecipesapp.recipelist.ui;

import com.professional.micromaster.facebookrecipesapp.entities.Recipe;

import java.util.List;

/**
 * Created by Roberto on 27/06/17.
 */

public interface RecipeListView {
    void setRecipes(List<Recipe> data);
    void recipeUpdated();
    void recipeDeleted(Recipe recipe);
}
