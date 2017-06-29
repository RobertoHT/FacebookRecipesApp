package com.professional.micromaster.facebookrecipesapp.recipemain.ui;

import com.professional.micromaster.facebookrecipesapp.entities.Recipe;

/**
 * Created by Roberto on 26/06/17.
 */

public interface RecipeMainView {
    void showProgress();
    void hideProgress();
    void showUIElements();
    void hideUIElements();
    void saveAnimation();
    void dismissAnimation();

    void onRecipeSaved();

    void setRecipe(Recipe recipe);
    void onGetRecipeError(String error);
}
