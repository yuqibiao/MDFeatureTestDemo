package com.yyyu.mdfeaturetestdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yyyu.mdfeaturetestdemo.animation.TestAniActivity;
import com.yyyu.mdfeaturetestdemo.bottom_navigation.TestBottomNavActivity;
import com.yyyu.mdfeaturetestdemo.coordinator_layout.CoordinatorActivity;
import com.yyyu.mdfeaturetestdemo.transition.TestActTransitionActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_bottom_nav).setOnClickListener(this);
        findViewById(R.id.btn_ani_test).setOnClickListener(this);
        findViewById(R.id.btn_act_transition).setOnClickListener(this);
        findViewById(R.id.btn_coordinator).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bottom_nav:
                startActivity(new Intent(this , TestBottomNavActivity.class ));
                break;
            case R.id.btn_ani_test:
                startActivity(new Intent(this , TestAniActivity.class));
                break;
            case R.id.btn_act_transition:
                startActivity(new Intent(this , TestActTransitionActivity.class));
                break;
            case R.id.btn_coordinator:
                startActivity(new Intent(this , CoordinatorActivity.class));
                break;
        }
    }
}
