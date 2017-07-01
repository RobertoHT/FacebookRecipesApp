package com.professional.micromaster.facebookrecipesapp.recipelist.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.professional.micromaster.facebookrecipesapp.FacebookRecipesApp;
import com.professional.micromaster.facebookrecipesapp.R;
import com.professional.micromaster.facebookrecipesapp.entities.Recipe;
import com.professional.micromaster.facebookrecipesapp.recipelist.RecipeListPresenter;
import com.professional.micromaster.facebookrecipesapp.recipelist.di.RecipeListComponent;
import com.professional.micromaster.facebookrecipesapp.recipelist.ui.adapter.OnItemClickListener;
import com.professional.micromaster.facebookrecipesapp.recipelist.ui.adapter.RecipesAdapter;
import com.professional.micromaster.facebookrecipesapp.recipemain.ui.RecipeMainActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecipeListActivity extends AppCompatActivity implements RecipeListView, OnItemClickListener {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private RecipesAdapter adapter;
    private RecipeListPresenter presenter;
    private RecipeListComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        ButterKnife.bind(this);
        setupToolbar();
        setupInjection();
        setupRecyclerView();
        presenter.onCreate();
        presenter.getRecipes();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recipes_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_main) {
            navigateToListActivity();
        }
        else if (id == R.id.action_logout) {
            logout();
        }

        return super.onOptionsItemSelected(item);
    }

    private void navigateToListActivity() {
        startActivity(new Intent(this, RecipeMainActivity.class));
    }

    private void logout() {
        FacebookRecipesApp app = (FacebookRecipesApp)getApplication();
        app.logout();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    private void setupInjection() {
        FacebookRecipesApp app = (FacebookRecipesApp)getApplication();
        component = app.getRecipeListComponent(this, this, this);
        presenter = getPresenter();
        adapter = getAdapter();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    @OnClick(R.id.toolbar)
    public void onToolbarClick() {
        recyclerView.smoothScrollToPosition(0);
    }

    @Override
    public void setRecipes(List<Recipe> data) {
        adapter.setRecipes(data);
    }

    @Override
    public void recipeUpdated() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void recipeDeleted(Recipe recipe) {
        adapter.removeRecipe(recipe);
    }

    @Override
    public void onFavClick(Recipe recipe) {
        presenter.toggleFavorite(recipe);
    }

    @Override
    public void onDeleteClick(Recipe recipe) {
        presenter.removeRecipe(recipe);
    }

    @Override
    public void onItemClick(Recipe recipe) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(recipe.getSourceURL())));
    }

    public RecipeListPresenter getPresenter() {
        return component.getPresenter();
    }

    public RecipesAdapter getAdapter() {
        return component.getAdapter();
    }
}
