package com.aliwx.android.scroll.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aliwx.android.scroll.ui.ScrollToTopGridView;

public class GridViewActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScrollToTop(true);

        ScrollToTopGridView gridView = new ScrollToTopGridView(this);
        gridView.setNumColumns(3);
        setAdapter(gridView);

        setContentView(gridView);
    }

    private void setAdapter(ScrollToTopGridView gridView) {
        gridView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 300;
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
                    TextView textView = (TextView) LayoutInflater.from(GridViewActivity.this)
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
