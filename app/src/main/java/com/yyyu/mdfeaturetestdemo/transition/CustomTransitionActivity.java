package com.yyyu.mdfeaturetestdemo.transition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.yyyu.mdfeaturetestdemo.R;

/**
 * 功能：自定义transition测试
 *
 * Created by yyyu on 2017/2/21.
 */

public class CustomTransitionActivity extends AppCompatActivity{

    private static final String TAG = "CustomTransitionActivit";

    private LinearLayout rootView;
    private View view1;
    private View view2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_transition);
        rootView = (LinearLayout) findViewById(R.id.root_view_custom);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
    }

    public void start(View view){
        ChangeColor changeColor = new ChangeColor();
        changeColor.setDuration(2000);
        TransitionManager.beginDelayedTransition(rootView , changeColor);

        view1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
        view2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));


    }

}
