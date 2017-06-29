package com.professional.micromaster.facebookrecipesapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Roberto on 26/06/17.
 */

public interface RecipeService {
    @GET("search")
    Call<RecipeSearchResponse> search(@Query("key") String key,
                                      @Query("sor") String sort,
                                      @Query("count") int count,
                                      @Query("page") int page);
}
