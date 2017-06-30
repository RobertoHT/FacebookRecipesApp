package com.professional.micromaster.facebookrecipesapp.recipemain;

import com.professional.micromaster.facebookrecipesapp.BaseTest;

import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

/**
 * Created by Roberto on 30/06/17.
 */

public class GetNextRecipeInteractorImplTest extends BaseTest {
    @Mock
    private RecipeMainRepository repository;
    private GetNextRecipeInteractorImpl interactor;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        interactor = new GetNextRecipeInteractorImpl(repository);
    }

    @Test
    public void testExecute_callRepository() throws Exception {
        interactor.execute();
        verify(repository).getNextRecipe();
    }
}
