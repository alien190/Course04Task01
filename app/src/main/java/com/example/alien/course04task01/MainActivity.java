package com.example.alien.course04task01;

import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.alien.course04task01.bulder.FrameLayoutBuilder;
import com.example.alien.course04task01.bulder.ImageViewBulder;
import com.example.alien.course04task01.bulder.RelativeLayoutBuilder;
import com.example.alien.course04task01.bulder.RelativeLayoutParamsBuilder;
import com.example.alien.course04task01.bulder.TextViewBuilder;

public class MainActivity extends AppCompatActivity {

    private DisplayMetrics metrics = new DisplayMetrics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        TextView tvQuote = findViewById(R.id.tvQuote);
//        RelativeLayout.LayoutParams layoutParams =
//                (RelativeLayout.LayoutParams) tvQuote.getLayoutParams();
//
//        int i =1;

        int ivIconId = 10000;
        int tvTitleId = 10001;
        int tvQuoteId = 10002;


        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        FrameLayout root = new FrameLayoutBuilder()
                .setPaddingPx(dpToPx(16))
                .setLayoutHeight(ViewGroup.LayoutParams.MATCH_PARENT)
                .setLayoutWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                .setGravity(Gravity.CENTER)
                .build(this);

        RelativeLayout relativeLayout = new RelativeLayoutBuilder()
                .setLayoutHeight(ViewGroup.LayoutParams.MATCH_PARENT)
                .setLayoutWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                .setGravity(Gravity.CENTER)
                .build(this);

        ImageView imageView = new ImageViewBulder()
                .setId(ivIconId)
                .setImageResource(R.drawable.sir_max)
                .build(this);


        RelativeLayout.LayoutParams tvTitleLayoutParams = new RelativeLayoutParamsBuilder()
                .alignTop(ivIconId)
                .setMarginLeftPx(dpToPx(8))
                .setMarginStartPx(dpToPx(8))
                .toEndOf(ivIconId)
                .toRightOf(ivIconId)
                .build();

        TextView tvTitle = new TextViewBuilder()
                .setId(tvTitleId)
                .setTextId(R.string.author)
                .setTextSizeSp(28)
                .setTextStyle(Typeface.BOLD)
                .setLayoutParams(tvTitleLayoutParams)
                .build(this);


        RelativeLayout.LayoutParams tvQuoteLayoutParams = new RelativeLayoutParamsBuilder()
                .alignBottom(ivIconId)
                .alignLeft(tvTitleId)
                .alignStart(tvTitleId)
                .below(tvTitleId)
                .setMarginTopPx(dpToPx(8))
                .build();

        TextView tvQuote = new TextViewBuilder()
                .setId(tvQuoteId)
                .setTextId(R.string.quote)
                .setTextSizeSp(14)
                .setTextStyle(Typeface.ITALIC)
                .setLayoutParams(tvQuoteLayoutParams)
                .build(this);

        relativeLayout.addView(imageView);
        relativeLayout.addView(tvTitle);
        relativeLayout.addView(tvQuote);
        root.addView(relativeLayout);
        setContentView(root);

//
//        TextView tvQuote1 = findViewById(tvQuoteId);
//        RelativeLayout.LayoutParams layoutParams =
//                (RelativeLayout.LayoutParams) tvQuote1.getLayoutParams();
//
//        int i =1;
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
