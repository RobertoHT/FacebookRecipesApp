package com.professional.micromaster.facebookrecipesapp;

import android.app.Application;
import android.content.Intent;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.professional.micromaster.facebookrecipesapp.login.LoginActivity;
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
}
