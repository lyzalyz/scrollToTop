package com.aliwx.android.scroll.sample;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aliwx.android.scroll.sample.ActionBarActivity;
import com.aliwx.android.scroll.ui.ScrollToTopScrollView;

public class ScrollViewActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScrollToTop(true);

        ScrollToTopScrollView scrollView = new ScrollToTopScrollView(this);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(100, 10, 0, 10);

        for (int i = 0; i < 100; i ++) {
            TextView textView = new TextView(this);
            textView.setLayoutParams(params);
            textView.setText("test" + i);
            textView.setTextSize(30);
            linearLayout.addView(textView);
        }

        scrollView.addView(linearLayout);
        setContentView(scrollView);
    }
}
