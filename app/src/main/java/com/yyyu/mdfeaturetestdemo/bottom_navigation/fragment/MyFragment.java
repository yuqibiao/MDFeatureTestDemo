package com.yyyu.mdfeaturetestdemo.bottom_navigation.fragment;

import android.widget.TextView;

import com.yyyu.mdfeaturetestdemo.R;

/**
 * 功能：
 * Created by yyyu on 2017/2/20.
 */

public class MyFragment extends BaseFragment{

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    protected void init() {
        TextView tv_title = getView(R.id.tv_title);
        tv_title.setText("MY");
    }
}
