package com.yyyu.mdfeaturetestdemo.transition.page;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yyyu.mdfeaturetestdemo.R;

/**
 * 功能：v21以下Activity跳转动画
 *
 * Created by yyyu on 2017/2/21.
 */

public class OverridePendingActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_override_pending);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.activity_left_in , R.anim.activity_right_out);
    }
}
