package com.professional.micromaster.facebookrecipesapp.libs.base;

import android.widget.ImageView;

/**
 * Created by Roberto on 26/06/17.
 */

public interface ImageLoader {
    void load(ImageView imageView, String URL);
    void setOnFinishedImageLoadingListener(Object listener);
}
