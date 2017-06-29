package com.professional.micromaster.facebookrecipesapp.recipelist.di;

import com.professional.micromaster.facebookrecipesapp.libs.di.LibsModule;
import com.professional.micromaster.facebookrecipesapp.recipelist.RecipeListPresenter;
import com.professional.micromaster.facebookrecipesapp.recipelist.ui.adapter.RecipesAdapter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Roberto on 27/06/17.
 */

@Singleton
@Component(modules = {RecipeListModule.class, LibsModule.class})
public interface RecipeListComponent {
    RecipesAdapter getAdapter();
    RecipeListPresenter getPresenter();
}
