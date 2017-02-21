package com.yyyu.mdfeaturetestdemo.transition.page;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;

import com.yyyu.mdfeaturetestdemo.R;

/**
 * 功能：
 * Created by yyyu on 2017/2/21.
 */

public class ContentTransitionActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTransition();
        setContentView(R.layout.activity_content_transition);
    }

    public void back(View v){
        finishAfterTransition();
    }

    @Override
    public void onBackPressed() {
        finishAfterTransition();
    }

    private void setTransition() {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setAllowEnterTransitionOverlap(false);
        getWindow().setAllowReturnTransitionOverlap(false);

        Slide slide = new Slide(Gravity.TOP);
        slide.setDuration(500);
        getWindow().setEnterTransition(slide);

        Slide slide2 = new Slide(Gravity.BOTTOM);
        slide.setDuration(500);
        getWindow().setReturnTransition(slide2);

    }

}
