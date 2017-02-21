package com.yyyu.mdfeaturetestdemo.transition;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.yyyu.mdfeaturetestdemo.R;
import com.yyyu.mdfeaturetestdemo.transition.page.ContentTransitionActivity;
import com.yyyu.mdfeaturetestdemo.transition.page.OverridePendingActivity;
import com.yyyu.mdfeaturetestdemo.transition.page.ShareElementTransitionActivity;

/**
 * 功能：测试Activity的过渡动画
 *
 *
 * 参考：
 * http://www.jianshu.com/p/b72718bade45
 * http://www.jianshu.com/p/50f62d9e60e1
 *
 * Created by yyyu on 2017/2/20.
 */

public class TestActTransitionActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTransition();
        setContentView(R.layout.activity_test_transition);
        initView();
    }


    private void initView() {
        findViewById(R.id.btn_basic_tra).setOnClickListener(this);
        findViewById(R.id.btn_delay_tran).setOnClickListener(this);
        findViewById(R.id.btn_custom_tran).setOnClickListener(this);
        findViewById(R.id.btn_pending).setOnClickListener(this);
        findViewById(R.id.btn_content_transition).setOnClickListener(this);
        findViewById(R.id.btn_share_element).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_basic_tra:
                startActivity(new Intent(this , BasicTransitionActivity.class));
                break;
            case R.id.btn_delay_tran:
                startActivity(new Intent(this , DelayTransitionActivity.class));
                break;
            case R.id.btn_custom_tran:
                startActivity(new Intent(this , CustomTransitionActivity.class));
                break;
            case  R.id.btn_pending:
                startActivity(new Intent(this , OverridePendingActivity.class) );
                overridePendingTransition(R.anim.activity_right_in , R.anim.activity_left_out);
                break;
            case R.id.btn_content_transition:
                startActivity(new Intent(this , ContentTransitionActivity.class) , ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.btn_share_element:
                ImageView iv_share = (ImageView) findViewById(R.id.iv_share);
                startActivity(new Intent(this , ShareElementTransitionActivity.class) ,
                        ActivityOptionsCompat.makeSceneTransitionAnimation(this , iv_share , getResources().getString(R.string.img_share)).toBundle());
                break;
        }
    }

    private void setTransition() {

        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setAllowEnterTransitionOverlap(false);
        getWindow().setAllowReturnTransitionOverlap(false);

        Fade fade = new Fade();
        fade.setDuration(800);
        getWindow().setExitTransition(fade);

        Slide slide = new Slide(Gravity.BOTTOM);
        slide.setDuration(500);
        getWindow().setReenterTransition(slide);

        getWindow().setSharedElementEnterTransition(new ChangeBounds());
        getWindow().setSharedElementReenterTransition(new ChangeBounds());

    }

}
