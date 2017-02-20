package com.yyyu.mdfeaturetestdemo.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.yyyu.mdfeaturetestdemo.R;

/**
 * 功能：MD中交互动效测试
 *
 *  参考：
 *  http://blog.csdn.net/qibin0506/article/details/49069089
 *
 * Created by yyyu on 2017/2/20.
 */

public class TestAniActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "TestAniActivity";

    private ImageView iv_circular;
    private ImageView iv_vector;
    private RelativeLayout card_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_ani);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_circular).setOnClickListener(this);
        findViewById(R.id.btn_curved).setOnClickListener(this);
        findViewById(R.id.btn_vector).setOnClickListener(this);
        findViewById(R.id.tv_content).setOnClickListener(this);
        iv_vector = (ImageView) findViewById(R.id.iv_vector);
        iv_circular = (ImageView) findViewById(R.id.iv_circular);
        findViewById(R.id.iv_rect).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_circular:
                circularChg(iv_circular);
                break;
            case R.id.btn_curved:
                moveByPath(iv_circular);
                break;
            case R.id.btn_vector:
                Drawable d = iv_vector.getDrawable();
                if (d instanceof Animatable) ((Animatable) d).start();
                break;
            case R.id.iv_rect:
                RelativeLayout card_content = (RelativeLayout) findViewById(R.id.card_content);
                Drawable card = card_content.getBackground();
                if (card instanceof Animatable) ((Animatable) card).start();
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void moveByPath(View view) {
        float pointX = view.getX();
        float pointY = view.getY();
        Path path = new Path();
        path.moveTo(pointX, pointY);
        path.lineTo(pointX + 500, pointY + 300);
        path.lineTo(pointX, pointY + 600);
        path.close();
        ObjectAnimator animator = new ObjectAnimator().ofFloat(view, view.X, view.Y, path);
        animator.setDuration(2000);
        animator.start();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void circularChg(final View view) {
        int centerX = view.getWidth() / 2;
        int centerY = view.getHeight() / 2;
        float maxRadius = Math.max(view.getWidth() / 2, view.getHeight());
        if (view.getVisibility() == View.VISIBLE) {
            Animator animator = ViewAnimationUtils.createCircularReveal(view, centerX, centerY, maxRadius, 0);
            animator.setDuration(1000);
            animator.start();
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    view.setVisibility(View.GONE);
                }
            });
        } else {
            view.setVisibility(View.VISIBLE);
            Animator animator = ViewAnimationUtils.createCircularReveal(view, centerX, centerY, 0, maxRadius);
            animator.setDuration(1000);
            animator.start();
        }
    }

}
