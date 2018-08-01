package com.example.alien.course04task01.bulder;

import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextViewBuilder {
    private int layoutWidth = -2;
    private int layoutHeight = -2;
    private int id = 0;
    private int marginLeftPx = 0;
    private int marginTopPx = 0;
    private int marginRightPx = 0;
    private int marginBottomPx = 0;
    private int marginStartPx = 0;
    private int textId = 0;
    private float textSizeSp = 0;
    private int textStyle = 0;

    public TextViewBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public TextViewBuilder setMarginLeftPx(int marginLeftPx) {
        this.marginLeftPx = marginLeftPx;
        return this;
    }

    public TextViewBuilder setMarginTopPx(int marginTopPx) {
        this.marginTopPx = marginTopPx;
        return this;
    }

    public TextViewBuilder setMarginRightPx(int marginRightPx) {
        this.marginRightPx = marginRightPx;
        return this;
    }

    public TextViewBuilder setMarginBottomPx(int marginBottomPx) {
        this.marginBottomPx = marginBottomPx;
        return this;
    }

    public TextViewBuilder setMarginStartPx(int marginStartPx) {
        this.marginStartPx = marginStartPx;
        return this;
    }

    public TextViewBuilder setTextId(int textId) {
        this.textId = textId;
        return this;
    }

    public TextViewBuilder setTextSizeSp(float textSizeSp) {
        this.textSizeSp = textSizeSp;
        return this;
    }

    public TextViewBuilder setTextStyle(int textStyle) {
        this.textStyle = textStyle;
        return this;
    }

    public TextViewBuilder setLayoutWidth(int layoutWidth) {
        this.layoutWidth = layoutWidth;
        return this;
    }

    public TextViewBuilder setLayoutHeight(int layoutHeight) {
        this.layoutHeight = layoutHeight;
        return this;
    }

    public TextView build(Context context) {
        TextView textView = new TextView(context);
        if (id != 0) textView.setId(id);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(layoutWidth,
                layoutHeight);

        layoutParams.setMargins(marginLeftPx, marginTopPx, marginRightPx, marginBottomPx);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            layoutParams.setMarginStart(marginStartPx);
        }
        textView.setLayoutParams(layoutParams);
        textView.setText(textId);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeSp);
        textView.setTypeface(textView.getTypeface(), textStyle);

        return textView;
    }
}
