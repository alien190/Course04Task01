package com.example.alien.course04task01.bulder;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class RelativeLayoutBuilder {

    private int paddingLeftPx = 0;
    private int paddingTopPx = 0;
    private int paddingRightPx = 0;
    private int paddingBottomPx = 0;
    private int layoutWidth = -2;
    private int layoutHeight = -2;
    private int gravity = 0;

    public RelativeLayoutBuilder setPaddingLeftPx(int paddingLeftPx) {
        this.paddingLeftPx = paddingLeftPx;
        return this;
    }

    public RelativeLayoutBuilder setPaddingTopPx(int paddingTopPx) {
        this.paddingTopPx = paddingTopPx;
        return this;
    }

    public RelativeLayoutBuilder setPaddingRightPx(int paddingRightPx) {
        this.paddingRightPx = paddingRightPx;
        return this;
    }

    public RelativeLayoutBuilder setPaddingBottomPx(int paddingBottomPx) {
        this.paddingBottomPx = paddingBottomPx;
        return this;
    }

    public RelativeLayoutBuilder setLayoutWidth(int layoutWidth) {
        this.layoutWidth = layoutWidth;
        return this;
    }

    public RelativeLayoutBuilder setLayoutHeight(int layoutHeight) {
        this.layoutHeight = layoutHeight;
        return this;
    }

    public RelativeLayoutBuilder setPaddingPx(int padding) {
        paddingLeftPx = padding;
        paddingTopPx = padding;
        paddingRightPx = padding;
        paddingBottomPx = padding;
        return this;
    }

    public RelativeLayoutBuilder setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public RelativeLayout build(Context context) {
        RelativeLayout layout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams =
                new RelativeLayout.LayoutParams(layoutWidth,
                        layoutHeight);

        layout.setLayoutParams(layoutParams);
        layout.setPadding(paddingLeftPx, paddingTopPx, paddingRightPx, paddingBottomPx);
        layout.setGravity(gravity);

        return layout;
    }
}
