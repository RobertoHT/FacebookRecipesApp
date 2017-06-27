package com.professional.micromaster.facebookrecipesapp.recipemain;

import java.util.Random;

/**
 * Created by Roberto Hdez. on 26/06/17.
 */

public class GetNextRecipeInteractorImpl implements GetNextRecipeInteractor {
    private RecipeMainRepository repository;

    public GetNextRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        int recipePage = new Random().nextInt(RecipeMainRepository.RECIPE_RANGE);
        repository.setRecipePage(recipePage);
        repository.getNextRecipe();
    }
}
