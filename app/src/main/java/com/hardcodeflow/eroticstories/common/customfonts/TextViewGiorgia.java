package com.hardcodeflow.eroticstories.common.customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


public class TextViewGiorgia extends androidx.appcompat.widget.AppCompatTextView {
    //private OnSelectionChangedListener callback = null;

    public TextViewGiorgia(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewGiorgia(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewGiorgia(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Georgia.ttf");
            setTypeface(tf);
        }
    }

    /*
    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        if (this.callback != null) this.callback.onSelectionChanged(selStart, selEnd);

    }

    public void setOnSelectionChanged(OnSelectionChangedListener callback) {
        this.callback = callback;
    }*/
}

