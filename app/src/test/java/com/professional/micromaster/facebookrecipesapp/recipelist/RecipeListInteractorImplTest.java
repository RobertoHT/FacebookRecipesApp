package com.professional.micromaster.facebookrecipesapp.recipelist;

import com.professional.micromaster.facebookrecipesapp.BaseTest;

import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

/**
 * Created by Roberto on 30/06/17.
 */

public class RecipeListInteractorImplTest extends BaseTest {
    @Mock
    private RecipeListRepository repository;
    private RecipeListInteractorImpl interactor;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        interactor = new RecipeListInteractorImpl(repository);
    }

    @Test
    public void testExecute_ShouldCallRepository() throws Exception {
        interactor.execute();
        verify(repository).getSavedRecipes();
    }
}
