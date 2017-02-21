package com.yyyu.mdfeaturetestdemo.transition.page;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.view.Window;

import com.yyyu.mdfeaturetestdemo.R;

/**
 * 功能：共享元素
 *
 * Created by yyyu on 2017/2/21.
 */

public class ShareElementTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTransition();
        setContentView(R.layout.activity_share_element);
    }

    @Override
    public void onBackPressed() {
        finishAfterTransition();
    }

    private void setTransition() {

        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setAllowEnterTransitionOverlap(false);
        getWindow().setAllowReturnTransitionOverlap(false);

        getWindow().setSharedElementReturnTransition(new ChangeBounds());
        getWindow().setSharedElementExitTransition(new ChangeBounds());
    }
}
