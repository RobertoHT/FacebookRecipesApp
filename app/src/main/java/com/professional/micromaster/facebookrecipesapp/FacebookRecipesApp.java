package com.professional.micromaster.facebookrecipesapp;

import android.app.Application;
import android.content.Intent;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.professional.micromaster.facebookrecipesapp.libs.di.LibsModule;
import com.professional.micromaster.facebookrecipesapp.login.LoginActivity;
import com.professional.micromaster.facebookrecipesapp.recipemain.di.DaggerRecipeMainComponent;
import com.professional.micromaster.facebookrecipesapp.recipemain.di.RecipeMainComponent;
import com.professional.micromaster.facebookrecipesapp.recipemain.di.RecipeMainModule;
import com.professional.micromaster.facebookrecipesapp.recipemain.ui.RecipeMainActivity;
import com.professional.micromaster.facebookrecipesapp.recipemain.ui.RecipeMainView;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by Roberto on 26/06/17.
 */

public class FacebookRecipesApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFacebook();
        initDB();
    }

    private void initDB() {
        FlowManager.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        DBTearDown();
    }

    private void DBTearDown() {
        FlowManager.destroy();
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(this);
    }

    public void logout() {
        LoginManager.getInstance().logOut();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public RecipeMainComponent getRecipeMainComponent(RecipeMainActivity activity, RecipeMainView view) {
        return DaggerRecipeMainComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .recipeMainModule(new RecipeMainModule(view))
                .build();
    }
}
