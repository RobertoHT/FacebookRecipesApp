package com.professional.micromaster.facebookrecipesapp;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by praxis on 26/06/17.
 */

public class FacebookRecipesApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFacebook();
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(this);
    }
}
