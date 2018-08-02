package com.example.alien.course04task01.bulder;

import android.content.Context;
import android.util.TypedValue;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;

public class TextViewBuilder {

    private int id = 0;
    private int textId = 0;
    private float textSizeSp = 0;
    private int textStyle = 0;
    private MarginLayoutParams layoutParams = null;

    public TextViewBuilder setId(int id) {
        this.id = id;
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


    public TextViewBuilder setLayoutParams(MarginLayoutParams layoutParams) {
        this.layoutParams = layoutParams;
        return this;
    }

    public TextView build(Context context) {
        TextView textView = new TextView(context);

        if (layoutParams != null) {
            textView.setLayoutParams(layoutParams);
        }

        if (id != 0) textView.setId(id);
        textView.setText(textId);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeSp);
        textView.setTypeface(textView.getTypeface(), textStyle);

        return textView;
    }
}
