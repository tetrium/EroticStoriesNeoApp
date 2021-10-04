package com.hardcodeflow.eroticstories.common.customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class TextViewSFProDisplayUltralightItalic extends androidx.appcompat.widget.AppCompatTextView {

    public TextViewSFProDisplayUltralightItalic(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewSFProDisplayUltralightItalic(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewSFProDisplayUltralightItalic(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/SF-Pro-Display-UltralightItalic.otf");
            setTypeface(tf);
        }
    }
}
