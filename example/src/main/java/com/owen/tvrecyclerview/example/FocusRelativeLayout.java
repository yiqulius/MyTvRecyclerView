package com.owen.tvrecyclerview.example;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FocusRelativeLayout extends RelativeLayout {
    NiceImageView niv;
    FrameLayout fl;
    private Animation scaleBigAnimation;
    private Animation scaleSmallAnimation;

    public FocusRelativeLayout(Context context) {
        super(context);
    }

    public FocusRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FocusRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (gainFocus) {
            zoomOut();
            if (getChildAt(0) != null && ((FrameLayout) getChildAt(1)).getChildAt(0) != null) {
                niv = (NiceImageView) getChildAt(0);
                niv.setBorderWidth(2);
                niv.setBorderColor(Color.WHITE);
                fl = (FrameLayout) getChildAt(1);
                fl.setVisibility(VISIBLE);
            }
        } else {
            zoomIn();
            if (getChildAt(0) != null && ((FrameLayout) getChildAt(1)).getChildAt(0) != null) {
                niv = (NiceImageView) getChildAt(0);
                niv.setBorderWidth(0);
                fl = (FrameLayout) getChildAt(1);
                fl.setVisibility(INVISIBLE);
            }
        }

    }

    private void zoomIn() {
        if (scaleSmallAnimation == null) {
            scaleSmallAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_small);
        }
        startAnimation(scaleSmallAnimation);
    }

    private void zoomOut() {
        if (scaleBigAnimation == null) {
            scaleBigAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_big);
        }
        startAnimation(scaleBigAnimation);
    }
}
