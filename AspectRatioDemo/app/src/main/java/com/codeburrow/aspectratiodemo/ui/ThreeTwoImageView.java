package com.codeburrow.aspectratiodemo.ui;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Subclass ImageView to enforce a given aspect ratio.
 * Credits to nickbutcher.
 */
public class ThreeTwoImageView extends ForegroundImageView {

    public ThreeTwoImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int desiredHeight = width * 2 / 3;
        int threeTwoHeightMeasureSpec = MeasureSpec.makeMeasureSpec(desiredHeight, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, threeTwoHeightMeasureSpec);
    }
}
