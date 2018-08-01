package com.example.alien.course04task01.bulder;

import android.content.Context;
import android.widget.FrameLayout;

public class FrameLayoutBuilder {

    private int paddingLeft = 0;
    private int paddingTop = 0;
    private int paddingRight = 0;
    private int paddingBottom = 0;
    private int layoutWidth = -2;
    private int layoutHeight = -2;

    FrameLayout build(Context context) {
        FrameLayout layout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams =
                new FrameLayout.LayoutParams(layoutWidth,
                        layoutHeight);

        layout.setLayoutParams(layoutParams);
        layout.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);

        return layout;
    }
}
