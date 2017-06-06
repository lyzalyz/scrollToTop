package com.aliwx.android.scroll.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aliwx.android.scroll.ui.ScrollToTopListView;

public class ListViewActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScrollToTop(true);

        ScrollToTopListView listView = new ScrollToTopListView(this);
        setAdapter(listView);
        setContentView(listView);
    }

    private void setAdapter(ScrollToTopListView listView) {
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 100;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    TextView textView = (TextView) LayoutInflater.from(ListViewActivity.this)
                        .inflate(android.R.layout.simple_list_item_1, parent, false);

                    textView.setGravity(Gravity.CENTER_VERTICAL);
                    textView.setPadding(30, 0, 0, 0);
                    textView.setTextSize(20);
                    textView.setTextColor(Color.BLACK);
                    convertView = textView;
                }

                TextView textView = (TextView) convertView;
                textView.setText("Item " + String.valueOf(position + 1));

                return convertView;
            }
        });
    }

}
