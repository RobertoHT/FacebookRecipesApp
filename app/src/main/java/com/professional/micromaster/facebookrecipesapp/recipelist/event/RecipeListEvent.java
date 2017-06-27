package com.professional.micromaster.facebookrecipesapp.recipelist.event;

import com.professional.micromaster.facebookrecipesapp.entities.Recipe;

import java.util.List;

/**
 * Created by Roberto on 27/06/17.
 */

public class RecipeListEvent {
    public final static int READ_EVENT = 0;
    public final static int UPDATE_EVENT = 1;
    public final static int DELETE_EVENT = 2;

    private int type;
    private List<Recipe> recipeList;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
}
