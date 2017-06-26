package com.professional.micromaster.facebookrecipesapp.recipemain;

import com.professional.micromaster.facebookrecipesapp.recipemain.event.RecipeMainEvent;
import com.professional.micromaster.facebookrecipesapp.recipemain.ui.RecipeMainView;

/**
 * Created by Roberto on 26/06/17.
 */

public interface RecipeMainPresenter {
    void onCreate();
    void onDestroy();

    void dismissRecipe();
    void getNextRecipe();
    void saveRecipe();
    void onEventMainThread(RecipeMainEvent event);

    void imageReady();
    void imageError(String error);

    RecipeMainView getView();
}
