package com.professional.micromaster.facebookrecipesapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Roberto on 26/06/17.
 */

public class RecipeClient {
    private final static String BASE_URL = "http://food2fork.com/api/";
    private Retrofit retrofit;

    public RecipeClient() {
        this.retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public RecipeService getRecipeService() {
        return this.retrofit.create(RecipeService.class);
    }
}
