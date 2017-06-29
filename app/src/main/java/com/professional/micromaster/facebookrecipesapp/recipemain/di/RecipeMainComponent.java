package com.professional.micromaster.facebookrecipesapp.recipemain.di;

import com.professional.micromaster.facebookrecipesapp.libs.base.ImageLoader;
import com.professional.micromaster.facebookrecipesapp.libs.di.LibsModule;
import com.professional.micromaster.facebookrecipesapp.recipemain.RecipeMainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Roberto on 27/06/17.
 */

@Singleton
@Component(modules = {RecipeMainModule.class, LibsModule.class})
public interface RecipeMainComponent {
    //void inject(RecipeMainActivity activity);
    ImageLoader getImageLoader();
    RecipeMainPresenter getPresenter();
}
