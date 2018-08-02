package com.example.alien.course04task01.bulder;

import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.TextView;

public class ButtonBuilder {

    private int id = 0;
    private int textId = 0;
    private MarginLayoutParams layoutParams = null;

    public ButtonBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ButtonBuilder setTextId(int textId) {
        this.textId = textId;
        return this;
    }


    public ButtonBuilder setLayoutParams(MarginLayoutParams layoutParams) {
        this.layoutParams = layoutParams;
        return this;
    }

    public Button build(Context context) {
        Button button = new Button(context);

        if (layoutParams != null) {
            button.setLayoutParams(layoutParams);
        }

        if (id != 0) button.setId(id);
        if (textId != 0) button.setText(textId);
        return button;
    }
}
