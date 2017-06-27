package com.professional.micromaster.facebookrecipesapp.recipemain.ui;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Roberto on 27/06/17.
 */

public class SwipeGestureDetector extends GestureDetector.SimpleOnGestureListener {
    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHLOD = 100;

    private SwipeGestureListener listener;

    public SwipeGestureDetector(SwipeGestureListener listener) {
        this.listener = listener;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float diffY = e2.getY() - e1.getY();
        float diffX = e2.getX() - e1.getX();
        if (Math.abs(diffX) > Math.abs(diffY) && Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHLOD) {
            if (diffX > 0) {
                listener.onKeep();
            } else {
                listener.onDismiss();
            }
        }
        return super.onFling(e1, e2, velocityX, velocityY);
    }
}
