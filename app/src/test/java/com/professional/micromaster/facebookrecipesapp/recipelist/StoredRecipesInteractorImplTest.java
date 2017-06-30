package com.professional.micromaster.facebookrecipesapp.recipelist;

import com.professional.micromaster.facebookrecipesapp.BaseTest;
import com.professional.micromaster.facebookrecipesapp.entities.Recipe;

import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

/**
 * Created by Roberto on 30/06/17.
 */

public class StoredRecipesInteractorImplTest extends BaseTest {
    @Mock
    private Recipe recipe;
    @Mock
    private RecipeListRepository repository;

    private StoredRecipesInteractorImpl interactor;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        interactor = new StoredRecipesInteractorImpl(repository);
    }

    @Test
    public void testExecuteUpdate_CallsRepository() throws Exception {
        interactor.executeUpdate(recipe);
        verify(repository).updateRecipe(recipe);
    }

    @Test
    public void testExecuteDelete_CallsRepository() throws Exception {
        interactor.executeDelete(recipe);
        verify(repository).removeRecipe(recipe);
    }
}
