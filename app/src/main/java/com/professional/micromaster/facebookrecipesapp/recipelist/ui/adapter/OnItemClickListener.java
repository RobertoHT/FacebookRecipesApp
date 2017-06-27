package com.professional.micromaster.facebookrecipesapp.recipelist.ui.adapter;

import com.professional.micromaster.facebookrecipesapp.entities.Recipe;

/**
 * Created by Roberto on 27/06/17.
 */

public interface OnItemClickListener {
    void onFavClick(Recipe recipe);
    void onDeleteClick(Recipe recipe);
    void onItemClick(Recipe recipe);
}
