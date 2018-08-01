package com.example.alien.course04task01;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DisplayMetrics metrics = new DisplayMetrics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        int ivIconId = 1;

        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        FrameLayout root = getFrameLayout(16);
        RelativeLayout relativeLayout = getRelativeLayout();

        ImageView imageView = getImageView(ivIconId);

        TextView textView = getTextView(1, 8, 0, 0, 0,
                8, R.string.author, 28, Typeface.BOLD);

        relativeLayout.addView(imageView);
        relativeLayout.addView(textView);
        root.addView(relativeLayout);
        setContentView(root);

    }

    private int dpToPx(int dp) {
        return Math.round(dp * metrics.density);
    }

    private FrameLayout getFrameLayout(int padding) {
        padding = dpToPx(padding);

        FrameLayout layout = new FrameLayout(this);
        FrameLayout.LayoutParams layoutParams =
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(layoutParams);
        layout.setPadding(padding, padding, padding, padding);

        return layout;
    }

    private RelativeLayout getRelativeLayout() {

        RelativeLayout layout = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams =
                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.setGravity(Gravity.CENTER);
        layout.setLayoutParams(layoutParams);

        return layout;
    }

    private ImageView getImageView(int ivIconId) {
        ImageView imageView = new ImageView(this);
        imageView.setId(ivIconId);
        imageView.setImageResource(R.drawable.sir_max);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dpToPx(128), dpToPx(192));
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    private TextView getTextView(int id, int marginLeftDp, int marginTopDp, int marginRightDp,
                                 int marginBottomDp, int marginStartDp, int textId, float textSizeSp, int textStyle) {
        TextView textView = new TextView(this);
        textView.setId(id);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(dpToPx(marginLeftDp), dpToPx(marginTopDp), dpToPx(marginRightDp), dpToPx(marginBottomDp));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            layoutParams.setMarginStart(dpToPx(marginStartDp));
        }
        textView.setLayoutParams(layoutParams);
        textView.setText(textId);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeSp);
        textView.setTypeface(textView.getTypeface(), textStyle);

        return textView;
    }
}
