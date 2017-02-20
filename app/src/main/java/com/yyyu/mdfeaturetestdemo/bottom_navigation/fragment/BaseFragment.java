package com.yyyu.mdfeaturetestdemo.bottom_navigation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 功能：
 * Created by yyyu on 2017/2/20.
 */

public abstract  class BaseFragment extends Fragment{

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId() , container , false);
        init();
        return rootView;
    }

    protected abstract int getLayoutId();

    protected abstract void init();

    public <T extends View>T getView(int viewId){
        return (T)rootView.findViewById(viewId);
    }

}
