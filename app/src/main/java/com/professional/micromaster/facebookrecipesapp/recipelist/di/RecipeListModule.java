package com.professional.micromaster.facebookrecipesapp.recipelist.di;

import com.professional.micromaster.facebookrecipesapp.entities.Recipe;
import com.professional.micromaster.facebookrecipesapp.libs.base.EventBus;
import com.professional.micromaster.facebookrecipesapp.libs.base.ImageLoader;
import com.professional.micromaster.facebookrecipesapp.recipelist.RecipeListInteractor;
import com.professional.micromaster.facebookrecipesapp.recipelist.RecipeListInteractorImpl;
import com.professional.micromaster.facebookrecipesapp.recipelist.RecipeListPresenter;
import com.professional.micromaster.facebookrecipesapp.recipelist.RecipeListPresenterImpl;
import com.professional.micromaster.facebookrecipesapp.recipelist.RecipeListRepository;
import com.professional.micromaster.facebookrecipesapp.recipelist.RecipeListRepositoryImpl;
import com.professional.micromaster.facebookrecipesapp.recipelist.StoredRecipesInteractor;
import com.professional.micromaster.facebookrecipesapp.recipelist.StoredRecipesInteractorImpl;
import com.professional.micromaster.facebookrecipesapp.recipelist.ui.RecipeListView;
import com.professional.micromaster.facebookrecipesapp.recipelist.ui.adapter.OnItemClickListener;
import com.professional.micromaster.facebookrecipesapp.recipelist.ui.adapter.RecipesAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by praxis on 27/06/17.
 */

@Module
public class RecipeListModule {
    private RecipeListView view;
    private OnItemClickListener onItemClickListener;

    public RecipeListModule(RecipeListView view, OnItemClickListener onItemClickListener) {
        this.view = view;
        this.onItemClickListener = onItemClickListener;
    }

    @Provides @Singleton
    RecipeListView providesRecipeListView() {
        return this.view;
    }

    @Provides @Singleton
    RecipeListPresenter providesRecipeListPresenter(EventBus eventBus, RecipeListView view, RecipeListInteractor listInteractor, StoredRecipesInteractor storedInteractor) {
        return new RecipeListPresenterImpl(eventBus, view, listInteractor, storedInteractor);
    }

    @Provides @Singleton
    StoredRecipesInteractor providesStoredRecipesInteractor(RecipeListRepository repository) {
        return new StoredRecipesInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeListInteractor providesRecipeListInteractor(RecipeListRepository repository) {
        return new RecipeListInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeListRepository providesRecipeListRepository(EventBus eventBus) {
        return new RecipeListRepositoryImpl(eventBus);
    }

    @Provides @Singleton
    RecipesAdapter providesRecipesAdapter(List<Recipe> recipeList, ImageLoader imageLoader, OnItemClickListener onItemClickListener) {
        return new RecipesAdapter(recipeList, imageLoader, onItemClickListener);
    }

    @Provides @Singleton
    OnItemClickListener providesOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Provides @Singleton
    List<Recipe> providesEmptyList() {

        return new ArrayList<Recipe>();
    }
}
