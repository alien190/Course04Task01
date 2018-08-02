package com.example.alien.course04task01.bulder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class LinearLayoutBuilder {

    private ViewGroup.MarginLayoutParams layoutParams = null;

    public LinearLayoutBuilder setLayoutParams(ViewGroup.MarginLayoutParams layoutParams) {
        this.layoutParams = layoutParams;
        return this;
    }


    public LinearLayout build(Context context) {
        LinearLayout layout = new LinearLayout(context);

        if (layoutParams != null) {
            layout.setLayoutParams(layoutParams);
        }

        return layout;
    }
}
