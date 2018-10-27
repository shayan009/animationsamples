package com.demoslideupdown.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;

public class AnimUtils {

    private static int mShortAnimationDuration=500;
    public static void animateViewToHide(final View view){
        view.animate()
                .alpha(0f)
                .setDuration(mShortAnimationDuration)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        view.setVisibility(View.GONE);
                    }
                });
    }
    // slide the view from below itself to the current position
    public static void slideDown(View view,View llDomestic){
        animateViewToShow(llDomestic);
        ObjectAnimator animation = ObjectAnimator.ofFloat(view, "translationY",   0f);
        animation.setDuration(300);
        animation.start();
    }
    public  static void animateViewToShow(View view){
        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);

        // Animate the content view to 100% opacity, and clear any animation
        // listener set on the view.
        view.animate()
                .alpha(1f)
                .setDuration(mShortAnimationDuration)
                .setListener(null);
    }
    // slide the view from its current position to below itself
    public static void slideUp(final View view, final View llDomestic){
        animateViewToHide(llDomestic);

        ObjectAnimator animation = ObjectAnimator.ofFloat(view, "translationY",0f);
        animation.setDuration(300);
        animation.start();

    }
}
