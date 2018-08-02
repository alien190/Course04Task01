package com.example.alien.course04task01;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
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
import com.example.alien.course04task01.bulder.FrameLayoutParamsBuilder;
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


        RelativeLayout relativeLayout = getRelativeLayout();
        relativeLayout.addView(getIvIcon());
        relativeLayout.addView(getTvTitle());

        ScrollView scrollView = getScroll();
        scrollView.addView(getTvQuote());
        relativeLayout.addView(scrollView);

        relativeLayout.addView(getEtComment());

        LinearLayout linearLayout = getLinearLayout();
        relativeLayout.addView(linearLayout);
        linearLayout.addView(getButton(BTN_PREV_ID, R.string.previous));
        linearLayout.addView(getButton(BTN_NEXT_ID, R.string.next));

        FrameLayout root = getRootLayout();
        root.addView(relativeLayout);
        setContentView(root);

    }

    private Button getButton(int btnId, int textId) {
        LinearLayout.LayoutParams btnPrevParams = new LinearLayoutParamsBuilder()
                .setLayoutWidth(0)
                .setLayoutHeight(LayoutParams.WRAP_CONTENT)
                .setWeight(1)
                .build();
        return new ButtonBuilder()
                .setId(btnId)
                .setTextId(textId)
                .setLayoutParams(btnPrevParams)
                .build(this);
    }

    private LinearLayout getLinearLayout() {
        RelativeLayout.LayoutParams linearParams = new RelativeLayoutParamsBuilder()
                .setLayoutWidth(LayoutParams.MATCH_PARENT)
                .setLayoutHeight(LayoutParams.WRAP_CONTENT)
                .below(ET_COMMENT_ID)
                .build();
        return new LinearLayoutBuilder()
                .setLayoutParams(linearParams)
                .build(this);
    }

    private EditText getEtComment() {
        RelativeLayout.LayoutParams etCommentLayoutParams = new RelativeLayoutParamsBuilder()
                .setLayoutWidth(LayoutParams.MATCH_PARENT)
                .setLayoutHeight(LayoutParams.WRAP_CONTENT)
                .below(IV_ICON_ID)
                .setMarginTopPx(dpToPx(8))
                .build();
        return new EditTextBuilder()
                .setHintId(R.string.comment)
                .setId(ET_COMMENT_ID)
                .setInputType(EditorInfo.TYPE_CLASS_TEXT)
                .setLayoutParams(etCommentLayoutParams)
                .setTextSizeSp(14)
                .build(this);
    }

    private TextView getTvQuote() {
        LinearLayout.LayoutParams tvQuoteLayoutParams = new LinearLayoutParamsBuilder()
                .setLayoutWidth(LayoutParams.WRAP_CONTENT)
                .setLayoutHeight(LayoutParams.WRAP_CONTENT)
                .build();
        return new TextViewBuilder()
                .setId(TV_QUOTE_ID)
                .setTextId(R.string.quote)
                .setTextSizeSp(14)
                .setTextStyle(Typeface.ITALIC)
                .setLayoutParams(tvQuoteLayoutParams)
                .build(this);
    }

    private ScrollView getScroll() {
        RelativeLayout.LayoutParams scrollLayoutParams = new RelativeLayoutParamsBuilder()
                .alignBottom(IV_ICON_ID)
                .alignLeft(TV_TITLE_ID)
                .alignStart(TV_TITLE_ID)
                .below(TV_TITLE_ID)
                .setMarginTopPx(dpToPx(8))
                .build();
        return new ScrollViewBuilder()
                .setId(SCROLL_ID)
                .setLayoutParams(scrollLayoutParams)
                .build(this);
    }

    private TextView getTvTitle() {
        RelativeLayout.LayoutParams tvTitleLayoutParams = new RelativeLayoutParamsBuilder()
                .alignTop(IV_ICON_ID)
                .setMarginLeftPx(dpToPx(8))
                .setMarginStartPx(dpToPx(8))
                .toEndOf(IV_ICON_ID)
                .toRightOf(IV_ICON_ID)
                .build();
        return new TextViewBuilder()
                .setId(TV_TITLE_ID)
                .setTextId(R.string.author)
                .setTextSizeSp(28)
                .setTextStyle(Typeface.BOLD)
                .setLayoutParams(tvTitleLayoutParams)
                .build(this);
    }

    private ImageView getIvIcon() {
        return new ImageViewBulder()
                .setId(IV_ICON_ID)
                .setImageResource(R.drawable.sir_max)
                .build(this);
    }

    private RelativeLayout getRelativeLayout() {
        FrameLayout.LayoutParams layoutParams = new FrameLayoutParamsBuilder()
                .setLayoutHeight(LayoutParams.WRAP_CONTENT)
                .setLayoutWidth(LayoutParams.WRAP_CONTENT)
                .setGravity(Gravity.CENTER)
                .build();

        return new RelativeLayoutBuilder()
                .setLayoutParams(layoutParams)
                .build(this);
    }

    private FrameLayout getRootLayout() {
        return new FrameLayoutBuilder()
                .setPaddingPx(dpToPx(16))
                .setLayoutHeight(LayoutParams.MATCH_PARENT)
                .setLayoutWidth(LayoutParams.MATCH_PARENT)
                .build(this);
    }

    private int dpToPx(int dp) {
        return Math.round(dp * metrics.density);
    }

}
