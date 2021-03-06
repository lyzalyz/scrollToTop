package com.aliwx.android.scroll.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

import com.aliwx.android.scroll.IScrollToTopInterface;
import com.aliwx.android.scroll.ScrollToTopHelper;

/**
 * 支持平滑滚动到顶部的ScrollView
 *
 * @author lihong
 * @since 2016/11/03
 */
public class ScrollToTopScrollView extends ScrollView implements IScrollToTopInterface {

    /**
     * 是否支持滚动到顶部
     */
    private boolean mIsScrollToTopEnabled = true;

    public ScrollToTopScrollView(Context context) {
        super(context);

        init(context);
    }

    public ScrollToTopScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public ScrollToTopScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {
        setScrollToTopEnabled(ScrollToTopHelper.isScrollToTopEnabled());
    }

    /**
     * Scroll to top
     */
    @Override
    public void scrollToTop() {
        if (isScrollToTopEnabled()) {
            smoothScrollTo(0, 0);
        }
    }

    /**
     * The scroll to top is enabled or not
     *
     * @return true/false
     */
    @Override
    public boolean isScrollToTopEnabled() {
        return mIsScrollToTopEnabled;
    }

    /**
     * Set the scroll to top enabled
     *
     * @param enabled true/false
     */
    @Override
    public void setScrollToTopEnabled(boolean enabled) {
        mIsScrollToTopEnabled = enabled;
    }
}
