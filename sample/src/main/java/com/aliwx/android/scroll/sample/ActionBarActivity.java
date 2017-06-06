package com.aliwx.android.scroll.sample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aliwx.android.scroll.ScrollToTopHelper;

public class ActionBarActivity extends Activity {

    /**
     * 是否要点击title滚动到顶部
     */
    private boolean mIsScrollToTop;

    /**
     * 滚动到顶部的view
     */
    private View mScrollView;

    @Override
    public void setContentView(int layoutResID) {
        setContentView(LayoutInflater.from(this).inflate(layoutResID, null));
    }

    @Override
    public void setContentView(View view) {
        ViewGroup rootView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.action_bar_activity_layout, null);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, R.id.title_bar_container);
        rootView.addView(view, 1, params);

        super.setContentView(rootView);
        initView();
    }

    private void initView() {
        String title = getTitle().toString();
        ((TextView) findViewById(R.id.title_text_center)).setText(title);
        findViewById(R.id.title_bar_container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollToTopIfNeed();
            }
        });
        findViewById(R.id.left_back_image_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void showBackButton(boolean show) {
        findViewById(R.id.left_back_image_view).setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }

    public void setScrollToTop(boolean isScrollToTop) {
        mIsScrollToTop = isScrollToTop;
    }

    /**
     * 滚动到顶部
     */
    private void scrollToTopIfNeed() {
        if (!mIsScrollToTop) {
            return;
        }
        ScrollToTopHelper.scrollToTop(this);
    }
}
