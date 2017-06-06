package com.aliwx.android.scroll.sample;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aliwx.android.scroll.sample.ActionBarActivity;
import com.aliwx.android.scroll.ui.ScrollToTopScrollView;
import com.aliwx.android.scroll.ui.ScrollToTopWebView;

public class WebViewActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScrollToTop(true);

        ScrollToTopWebView webView = new ScrollToTopWebView(this);
        webView.loadUrl("http://leehong2005.com/2016/10/20/slideback-for-android/");

        setContentView(webView);
    }
}
