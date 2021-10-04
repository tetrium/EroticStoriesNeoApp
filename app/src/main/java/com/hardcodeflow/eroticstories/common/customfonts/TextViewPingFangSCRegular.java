package com.hardcodeflow.eroticstories.common.customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class TextViewPingFangSCRegular  extends androidx.appcompat.widget.AppCompatTextView {

    public TextViewPingFangSCRegular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewPingFangSCRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewPingFangSCRegular(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/PingFang-SC-Regular.ttf");
            setTypeface(tf);
        }
    }
}
