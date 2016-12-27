package com.eferhatg.animatedbargraph;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;


/**
 * Created by efg on 23/12/2016.
 */

public class AnimatedBarGraph extends LinearLayout {


    Context mContext;

    public AnimatedBarGraph(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    int mToInPercentOfParent;
    int mToInPixel;
    int mAnimDuration;

    private void init(Context context, AttributeSet attrs) {

        this.mContext = context;

        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.AnimatedBarGraph, 0, 0);
        this.mToInPercentOfParent = ta.getInt(R.styleable.AnimatedBarGraph_to_inPercentOfParent, 0);
        this.mToInPixel = ta.getInt(R.styleable.AnimatedBarGraph_to_inPixel, 0);
        this.mAnimDuration = ta.getInt(R.styleable.AnimatedBarGraph_anim_duration, 300);
        ta.recycle();
    }

    public void setToInPercentOfParent(int percent){
        mToInPercentOfParent=percent;

    }
    public void setToInPixel(int pixel){
        mToInPixel=pixel;
    }
    public void setAnimDuration(int duration){
        mAnimDuration=duration;
    }

    public void AnimateBar(){

        float pivotX = 0f;
        float pivotY = 1f;
        float fromX = 1.0f;
        float toX = 1.0f;
        float fromY = 1.0f;

        float toY=SetToY();
        int duration = mAnimDuration;
        ScaleAnimation scaleAnimation = new ScaleAnimation(fromX, toX, fromY, toY, pivotX, pivotY);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        scaleAnimation.setDuration(duration);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setBackgroundColor(Color.BLACK);
        startAnimation(scaleAnimation);
    }

    private float SetToY(){

        if(mToInPercentOfParent==0&&mToInPixel==0){
            throw new RuntimeException("One of to_inPercentOfParent or to_inPixel must be assigned.");
        }
        if(mToInPixel!=0){
            return mToInPixel;
        }

        float toPercent=(mToInPercentOfParent/100f);
        int parentHeight=((ViewGroup) this.getParent()).getHeight();
        return (parentHeight*toPercent);
    }

}
