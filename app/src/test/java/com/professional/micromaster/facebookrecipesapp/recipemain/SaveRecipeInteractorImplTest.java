package com.professional.micromaster.facebookrecipesapp.recipemain;

import com.professional.micromaster.facebookrecipesapp.BaseTest;
import com.professional.micromaster.facebookrecipesapp.entities.Recipe;

import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

/**
 * Created by Roberto on 30/06/17.
 */

public class SaveRecipeInteractorImplTest extends BaseTest {
    @Mock
    private RecipeMainRepository repository;
    @Mock
    Recipe recipe;
    private SaveRecipeInteractor interactor;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        interactor = new SaveRecipeInteractorImpl(repository);
    }

    @Test
    public void testExecute_callRepository() throws Exception {
        interactor.execute(recipe);
        verify(repository).saveRecipe(recipe);
    }
}
