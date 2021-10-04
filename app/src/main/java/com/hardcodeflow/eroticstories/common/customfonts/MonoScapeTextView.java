package com.hardcodeflow.eroticstories.common.customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class MonoScapeTextView extends androidx.appcompat.widget.AppCompatTextView {

    public MonoScapeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MonoScapeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MonoScapeTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/MonoScape1.ttf");
            setTypeface(tf);
        }
    }
}

