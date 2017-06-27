package com.professional.micromaster.facebookrecipesapp.recipemain;

import com.professional.micromaster.facebookrecipesapp.entities.Recipe;

/**
 * Created by Roberto Hdez. on 26/06/17.
 */

public class SaveRecipeInteractorImpl implements SaveRecipeInteractor {
    private RecipeMainRepository repository;

    public SaveRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Recipe recipe) {
        repository.saveRecipe(recipe);
    }
}
