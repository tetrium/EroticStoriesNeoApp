package com.hardcodeflow.eroticstories.common.customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class TextViewSFProDisplayLight extends androidx.appcompat.widget.AppCompatTextView {

    public TextViewSFProDisplayLight(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewSFProDisplayLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewSFProDisplayLight(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/SF-Pro-Display-Light.otf");
            setTypeface(tf);
        }
    }
}
