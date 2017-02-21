package com.yyyu.mdfeaturetestdemo.transition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.ChangeBounds;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yyyu.mdfeaturetestdemo.R;


/**
 * 功能：延迟transition动画
 *
 * Created by yyyu on 2017/2/21.
 */

public class DelayTransitionActivity extends AppCompatActivity{

    private LinearLayout rootView;
    private View view1;
    private View view2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delay_transition);
        initView();
    }

    private void initView() {
        rootView = (LinearLayout) findViewById(R.id.rootView);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
    }

    public void start(View v){

        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(2000);
        TransitionManager.beginDelayedTransition(rootView , changeBounds);

        ViewGroup.LayoutParams params1 = view1.getLayoutParams();
        params1.width = 600;
        params1.height = 600;
        view1.setLayoutParams(params1);

        ViewGroup.LayoutParams params2 = view2.getLayoutParams();
        params2.width = 50;
        params2.height = 50;
        view2.setLayoutParams(params2);

    }

}
