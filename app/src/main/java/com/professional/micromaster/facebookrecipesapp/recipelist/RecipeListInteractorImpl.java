package com.professional.micromaster.facebookrecipesapp.recipelist;

/**
 * Created by Roberto on 27/06/17.
 */

public class RecipeListInteractorImpl implements RecipeListInteractor {
    private RecipeListRepository repository;

    public RecipeListInteractorImpl(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getSavedRecipes();
    }
}
