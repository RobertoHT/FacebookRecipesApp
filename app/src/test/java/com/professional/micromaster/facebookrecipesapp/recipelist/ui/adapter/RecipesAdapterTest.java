package com.professional.micromaster.facebookrecipesapp.recipelist.ui.adapter;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.SendButton;
import com.facebook.share.widget.ShareButton;
import com.professional.micromaster.facebookrecipesapp.BaseTest;
import com.professional.micromaster.facebookrecipesapp.BuildConfig;
import com.professional.micromaster.facebookrecipesapp.R;
import com.professional.micromaster.facebookrecipesapp.entities.Recipe;
import com.professional.micromaster.facebookrecipesapp.libs.base.ImageLoader;
import com.professional.micromaster.facebookrecipesapp.support.ShadowRecyclerViewAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.internal.ShadowExtractor;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Roberto Hdez. on 30/06/17.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, shadows = {ShadowRecyclerViewAdapter.class})
public class RecipesAdapterTest extends BaseTest {
    @Mock
    private Recipe recipe;
    @Mock
    private ImageLoader imageLoader;
    @Mock
    private List<Recipe> recipeList;
    @Mock
    private OnItemClickListener onItemClickListener;

    private String URL;
    private RecipesAdapter adapter;
    private ShadowRecyclerViewAdapter shadowAdapter;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        URL = "http://galileo.edu";
        when(recipe.getSourceURL()).thenReturn(URL);

        adapter = new RecipesAdapter(recipeList, imageLoader, onItemClickListener);
        shadowAdapter = (ShadowRecyclerViewAdapter) ShadowExtractor.extract(adapter);

        Activity activity = Robolectric.setupActivity(Activity.class);
        RecyclerView recyclerView = new RecyclerView(activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        recyclerView.setAdapter(adapter);
    }

    @Test
    public void testSetRecipes_ItemCountMatches() throws Exception {
        int itemCount = 5;
        when(recipeList.size()).thenReturn(itemCount);
        adapter.setRecipes(recipeList);

        assertEquals(itemCount, adapter.getItemCount());
    }

    @Test
    public void testRemoveRecipe_IsRemovesFromAdapter() throws Exception {
        adapter.removeRecipe(recipe);
        verify(recipeList).remove(recipe);
    }

    @Test
    public void testOnItemClick_ShouldCallListener() throws Exception {
        int positionToClick = 0;
        when(recipeList.get(positionToClick)).thenReturn(recipe);

        shadowAdapter.itemVisible(positionToClick);
        shadowAdapter.performItemClick(positionToClick);

        verify(onItemClickListener).onItemClick(recipe);
    }

    @Test
    public void testViewHolder_ShouldRenderTitle() throws Exception {
        int positionToShow = 0;
        String recipeTitle = "title";
        when(recipe.getTitle()).thenReturn(recipeTitle);
        when(recipeList.get(positionToShow)).thenReturn(recipe);

        shadowAdapter.itemVisible(positionToShow);

        View view = shadowAdapter.getViewForHolderPosition(positionToShow);
        TextView txtRecipeName = (TextView) view.findViewById(R.id.txtRecipeName);

        assertEquals(recipeTitle, txtRecipeName.getText().toString());
    }

    @Test
    public void testOnFavoriteClick_ShouldCallListener() throws Exception {
        int positionToClick = 0;
        boolean favorite = true;
        when(recipe.getFavorite()).thenReturn(favorite);
        when(recipeList.get(positionToClick)).thenReturn(recipe);

        shadowAdapter.itemVisible(positionToClick);
        shadowAdapter.performItemClickOverViewInHolder(positionToClick, R.id.imgFav);

        View view = shadowAdapter.getViewForHolderPosition(positionToClick);
        ImageButton imgFav = (ImageButton) view.findViewById(R.id.imgFav);

        assertEquals(favorite, imgFav.getTag());
        verify(onItemClickListener).onFavClick(recipe);
    }

    @Test
    public void testOnNonFavoriteClick_ShouldCallListener() throws Exception {
        int positionToClick = 0;
        boolean favorite = false;
        when(recipe.getFavorite()).thenReturn(favorite);
        when(recipeList.get(positionToClick)).thenReturn(recipe);

        shadowAdapter.itemVisible(positionToClick);
        shadowAdapter.performItemClickOverViewInHolder(positionToClick, R.id.imgFav);

        View view = shadowAdapter.getViewForHolderPosition(positionToClick);
        ImageButton imgFav = (ImageButton) view.findViewById(R.id.imgFav);

        assertEquals(favorite, imgFav.getTag());
        verify(onItemClickListener).onFavClick(recipe);
    }

    @Test
    public void testOnDeleteClick_ShouldCallListener() throws Exception {
        int positionToClick = 0;
        when(recipeList.get(positionToClick)).thenReturn(recipe);

        shadowAdapter.itemVisible(positionToClick);
        shadowAdapter.performItemClickOverViewInHolder(positionToClick, R.id.imgDelete);

        verify(onItemClickListener).onDeleteClick(recipe);
    }

    @Test
    public void testFBShareBind_shareContentSet() throws Exception {
        int positionToShow = 0;
        when(recipeList.get(positionToShow)).thenReturn(recipe);

        shadowAdapter.itemVisible(positionToShow);
        View view = shadowAdapter.getViewForHolderPosition(positionToShow);
        ShareButton fbShare = (ShareButton) view.findViewById(R.id.fbShare);

        ShareContent shareContent = fbShare.getShareContent();
        assertNotNull(shareContent);
        assertEquals(URL, shareContent.getContentUrl().toString());
    }

    @Test
    public void testFBSendBind_shareContentSet() throws Exception {
        int positionToShow = 0;
        when(recipeList.get(positionToShow)).thenReturn(recipe);

        shadowAdapter.itemVisible(positionToShow);
        View view = shadowAdapter.getViewForHolderPosition(positionToShow);
        SendButton fbSend = (SendButton) view.findViewById(R.id.fbSend);

        ShareContent shareContent = fbSend.getShareContent();
        assertNotNull(shareContent);
        assertEquals(URL, shareContent.getContentUrl().toString());
    }
}
