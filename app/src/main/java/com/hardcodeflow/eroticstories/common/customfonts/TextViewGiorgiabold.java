package com.hardcodeflow.eroticstories.common.customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class TextViewGiorgiabold extends androidx.appcompat.widget.AppCompatTextView {

    public TextViewGiorgiabold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewGiorgiabold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewGiorgiabold(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/georgia bold.ttf");
            setTypeface(tf);
        }
    }
}