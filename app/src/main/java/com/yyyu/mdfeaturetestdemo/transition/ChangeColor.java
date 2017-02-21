package com.yyyu.mdfeaturetestdemo.transition;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import android.util.Log;
import android.view.ViewGroup;

/**
 * 功能：自定义颜色改变Transition
 *
 * Created by yyyu on 2017/2/21.
 */

public class ChangeColor extends Transition{

    private static final String TAG = "ChangeColor";

    private final String BACKGROUND = "com.yyyu.changcolor.view.background";

    //---对视图树中所有的view进行调用，可以在这里记录所关心的属性，此处为background
    @Override
    public void captureStartValues( TransitionValues transitionValues) {
        Drawable drawable = transitionValues.view.getBackground();
        if( drawable instanceof ColorDrawable){
            transitionValues.values.put(BACKGROUND , ((ColorDrawable) drawable).getColor());
        }
    }

    //---同理记录结束状态的View background
    @Override
    public void captureEndValues(TransitionValues transitionValues) {

        Drawable drawable = transitionValues.view.getBackground();
        if( drawable instanceof ColorDrawable){
            transitionValues.values.put(BACKGROUND , ((ColorDrawable) drawable).getColor());
        }
    }

    //---具体的动画处理
    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, final TransitionValues endValues) {

        if(startValues == null || endValues == null){
            return null;
        }

        int startBgColor = (int) startValues.values.get(BACKGROUND);
        int endBgColor = (int) endValues.values.get(BACKGROUND);
        if(startBgColor != endBgColor){
            ValueAnimator animator = ValueAnimator.ofObject(new ArgbEvaluator() , startBgColor , endBgColor);
            animator.setDuration(1000);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    Object value = animation.getAnimatedValue();
                    if (value!=null){
                        endValues.view.setBackgroundColor((Integer)value);
                    }
                }
            });
            return animator;
        }
        return null;
    }

    //---返回transitionValues中存储的值（次方法必须重写）
    @Override
    public String[] getTransitionProperties() {
        Log.e(TAG, "getTransitionProperties: ===========" );
        return new String[]{
                BACKGROUND
        };
    }
}
