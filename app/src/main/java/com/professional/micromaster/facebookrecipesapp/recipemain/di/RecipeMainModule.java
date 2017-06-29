package com.professional.micromaster.facebookrecipesapp.recipemain.di;

import com.professional.micromaster.facebookrecipesapp.api.RecipeClient;
import com.professional.micromaster.facebookrecipesapp.api.RecipeService;
import com.professional.micromaster.facebookrecipesapp.libs.base.EventBus;
import com.professional.micromaster.facebookrecipesapp.recipemain.GetNextRecipeInteractor;
import com.professional.micromaster.facebookrecipesapp.recipemain.GetNextRecipeInteractorImpl;
import com.professional.micromaster.facebookrecipesapp.recipemain.RecipeMainPresenter;
import com.professional.micromaster.facebookrecipesapp.recipemain.RecipeMainPresenterImpl;
import com.professional.micromaster.facebookrecipesapp.recipemain.RecipeMainRepository;
import com.professional.micromaster.facebookrecipesapp.recipemain.RecipeMainRepositoryImpl;
import com.professional.micromaster.facebookrecipesapp.recipemain.SaveRecipeInteractor;
import com.professional.micromaster.facebookrecipesapp.recipemain.SaveRecipeInteractorImpl;
import com.professional.micromaster.facebookrecipesapp.recipemain.ui.RecipeMainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Roberto on 27/06/17.
 */

@Module
public class RecipeMainModule {
    RecipeMainView view;

    public RecipeMainModule(RecipeMainView view) {
        this.view = view;
    }

    @Provides @Singleton
    RecipeMainView providesRecipeMainView() {
        return this.view;
    }

    @Provides @Singleton
    RecipeMainPresenter providesRecipeMainPresenter(EventBus eventBus, RecipeMainView view, SaveRecipeInteractor saveInteractor, GetNextRecipeInteractor getNextInteractor) {
        return new RecipeMainPresenterImpl(eventBus, view, saveInteractor, getNextInteractor);
    }

    @Provides @Singleton
    SaveRecipeInteractor providesSaveRecipeInteractor(RecipeMainRepository repository) {
        return new SaveRecipeInteractorImpl(repository);
    }

    @Provides @Singleton
    GetNextRecipeInteractor providesGetNextRecipeInteractor(RecipeMainRepository repository) {
        return new GetNextRecipeInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeMainRepository providesRecipeMainRepository(EventBus eventBus, RecipeService service){
        return new RecipeMainRepositoryImpl(eventBus, service);
    }

    @Provides @Singleton
    RecipeService providesRecipeService(){
        return new RecipeClient().getRecipeService();
    }
}
