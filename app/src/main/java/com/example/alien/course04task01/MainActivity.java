package com.example.alien.course04task01;

import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.alien.course04task01.bulder.ButtonBuilder;
import com.example.alien.course04task01.bulder.EditTextBuilder;
import com.example.alien.course04task01.bulder.FrameLayoutBuilder;
import com.example.alien.course04task01.bulder.ImageViewBulder;
import com.example.alien.course04task01.bulder.LinearLayoutBuilder;
import com.example.alien.course04task01.bulder.LinearLayoutParamsBuilder;
import com.example.alien.course04task01.bulder.RelativeLayoutBuilder;
import com.example.alien.course04task01.bulder.RelativeLayoutParamsBuilder;
import com.example.alien.course04task01.bulder.ScrollViewBuilder;
import com.example.alien.course04task01.bulder.TextViewBuilder;

public class MainActivity extends AppCompatActivity {

    private DisplayMetrics metrics = new DisplayMetrics();
    private final static int IV_ICON_ID = 10000;
    private final static int TV_TITLE_ID = 10001;
    private final static int TV_QUOTE_ID = 10002;
    private final static int ET_COMMENT_ID = 10003;
    private final static int BTN_PREV_ID = 10004;
    private final static int BTN_NEXT_ID = 10005;
    private final static int SCROLL_ID = 10006;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);


               getWindowManager().getDefaultDisplay().getMetrics(metrics);

        FrameLayout root = new FrameLayoutBuilder()
                .setPaddingPx(dpToPx(16))
                .setLayoutHeight(LayoutParams.MATCH_PARENT)
                .setLayoutWidth(LayoutParams.MATCH_PARENT)
                .setGravity(Gravity.CENTER)
                .build(this);

        RelativeLayout relativeLayout = new RelativeLayoutBuilder()
                .setLayoutHeight(LayoutParams.MATCH_PARENT)
                .setLayoutWidth(LayoutParams.MATCH_PARENT)
                .setGravity(Gravity.CENTER)
                .build(this);

        ImageView imageView = new ImageViewBulder()
                .setId(IV_ICON_ID)
                .setImageResource(R.drawable.sir_max)
                .build(this);


        RelativeLayout.LayoutParams tvTitleLayoutParams = new RelativeLayoutParamsBuilder()
                .alignTop(IV_ICON_ID)
                .setMarginLeftPx(dpToPx(8))
                .setMarginStartPx(dpToPx(8))
                .toEndOf(IV_ICON_ID)
                .toRightOf(IV_ICON_ID)
                .build();

        TextView tvTitle = new TextViewBuilder()
                .setId(TV_TITLE_ID)
                .setTextId(R.string.author)
                .setTextSizeSp(28)
                .setTextStyle(Typeface.BOLD)
                .setLayoutParams(tvTitleLayoutParams)
                .build(this);


        RelativeLayout.LayoutParams scrollLayoutParams = new RelativeLayoutParamsBuilder()
                .alignBottom(IV_ICON_ID)
                .alignLeft(TV_TITLE_ID)
                .alignStart(TV_TITLE_ID)
                .below(TV_TITLE_ID)
                .setMarginTopPx(dpToPx(8))
                .build();

        ScrollView scrollView = new ScrollViewBuilder()
                .setId(SCROLL_ID)
                .setLayoutParams(scrollLayoutParams)
                .build(this);

        LinearLayout.LayoutParams tvQuoteLayoutParams = new LinearLayoutParamsBuilder()
                .setLayoutWidth(LayoutParams.WRAP_CONTENT)
                .setLayoutHeight(LayoutParams.WRAP_CONTENT)
                .build();

        TextView tvQuote = new TextViewBuilder()
                .setId(TV_QUOTE_ID)
                .setTextId(R.string.quote)
                .setTextSizeSp(14)
                .setTextStyle(Typeface.ITALIC)
                .setLayoutParams(tvQuoteLayoutParams)
                .build(this);

        RelativeLayout.LayoutParams etCommentLayoutParams = new RelativeLayoutParamsBuilder()
                .setLayoutWidth(LayoutParams.MATCH_PARENT)
                .setLayoutHeight(LayoutParams.WRAP_CONTENT)
                .below(IV_ICON_ID)
                .setMarginTopPx(dpToPx(8))
                .build();


        EditText etComment = new EditTextBuilder()
                .setHintId(R.string.comment)
                .setId(ET_COMMENT_ID)
                .setInputType(EditorInfo.TYPE_CLASS_TEXT)
                .setLayoutParams(etCommentLayoutParams)
                .setTextSizeSp(14)
                .build(this);


        RelativeLayout.LayoutParams linearParams = new RelativeLayoutParamsBuilder()
                .setLayoutWidth(LayoutParams.MATCH_PARENT)
                .setLayoutHeight(LayoutParams.WRAP_CONTENT)
                .below(ET_COMMENT_ID)
                .build();

        LinearLayout linearLayout = new LinearLayoutBuilder()
                .setLayoutParams(linearParams)
                .build(this);


        LinearLayout.LayoutParams btnPrevParams = new LinearLayoutParamsBuilder()
                .setLayoutWidth(0)
                .setLayoutHeight(LayoutParams.WRAP_CONTENT)
                .setWeight(1)
                .build();

        Button btnPrev = new ButtonBuilder()
                .setId(BTN_PREV_ID)
                .setTextId(R.string.previous)
                .setLayoutParams(btnPrevParams)
                .build(this);

        Button btnNext = new ButtonBuilder()
                .setId(BTN_NEXT_ID)
                .setTextId(R.string.next)
                .setLayoutParams(btnPrevParams)
                .build(this);


        relativeLayout.addView(imageView);
        relativeLayout.addView(tvTitle);
        relativeLayout.addView(scrollView);
        scrollView.addView(tvQuote);
        relativeLayout.addView(etComment);
        relativeLayout.addView(linearLayout);
        linearLayout.addView(btnPrev);
        linearLayout.addView(btnNext);
        root.addView(relativeLayout);
        setContentView(root);

//
//        TextView tvQuote1 = findViewById(TV_QUOTE_ID);
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
