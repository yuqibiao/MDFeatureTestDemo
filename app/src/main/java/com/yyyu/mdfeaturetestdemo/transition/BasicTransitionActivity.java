package com.yyyu.mdfeaturetestdemo.transition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.ChangeBounds;
import android.support.transition.Scene;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.yyyu.mdfeaturetestdemo.R;


/**
 * 功能：Transition动画基础
 *
 * Created by yyyu on 2017/2/21.
 */

public class BasicTransitionActivity extends AppCompatActivity implements View.OnClickListener{

    private FrameLayout fl_root;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_transitions);
        initView();
    }

    private void initView() {
        fl_root = (FrameLayout) findViewById(R.id.fl_root);
        findViewById(R.id.btn_default).setOnClickListener(this);
        findViewById(R.id.btn_target).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_default:
                chgDefault();
                break;
            case R.id.btn_target:
                chgTarget();
                break;
        }
    }

    private void chgDefault() {
        Scene scene2 = Scene.getSceneForLayout(fl_root , R.layout.scene2 , this);
        TransitionManager.go(scene2 , new ChangeBounds());
    }

    private void chgTarget() {
        Scene scene2 = Scene.getSceneForLayout(fl_root , R.layout.scene2 , this);
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(2000);
        changeBounds.addTarget(R.id.image1);
        TransitionManager.go(scene2 , changeBounds);
    }

}
