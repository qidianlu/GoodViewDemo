package com.zhe.goodviewdemo.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by zhangyr on 2016/6/3.
 */
public class GoodView extends PopupWindow{
    private int Duration = 500;
    private int from_y_delta = 0;
    private int distance = 200;
    private String text = "";
    private int textSize = 15;
    private int textColor = Color.parseColor("#ff0000");
    private float from_alpha = 1.0f;
    private float to_alpha = 0.0f;

    private Context context;
    private AnimationSet mAnimation;
    private TextView mGood;

    public GoodView(Context context){
        this.context = context;
        initview();
    }

    private void initview(){

        RelativeLayout layout = new RelativeLayout(context);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);

        mGood = new TextView(context);
        mGood.setIncludeFontPadding(false);
        mGood.setText("+1");
        mGood.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize);
        mGood.setTextColor(textColor);
        mGood.setLayoutParams(params);
        layout.addView(mGood);
        setContentView(layout);

        int width = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int height = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        mGood.measure(width,height);
        setWidth(mGood.getMeasuredWidth());
        setHeight(mGood.getMeasuredHeight() + distance);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setFocusable(false);
        setTouchable(false);
        setOutsideTouchable(false);

        mAnimation = createAnimation();
    }

    private AnimationSet createAnimation(){
        mAnimation = new AnimationSet(true);
        TranslateAnimation trans = new TranslateAnimation(0,0,from_y_delta,-distance);
        AlphaAnimation alpha = new AlphaAnimation(from_alpha,to_alpha);
        mAnimation.addAnimation(trans);
        mAnimation.addAnimation(alpha);
        mAnimation.setDuration(Duration);
        mAnimation.setFillAfter(true);
        return mAnimation;
    }

    public void show(View v){
        if(v!=null){
            int offsetY = -v.getHeight()-getHeight();
            showAsDropDown(v,v.getWidth()/2-getWidth()/2,offsetY);

        }
        mGood.startAnimation(mAnimation);
    }

    public void setText(String text){
        mGood.setText(text);
    }

    public void setTextColor(int color){
        mGood.setTextColor(color);
    }

    public void setDuration(int duration){
        mAnimation.setDuration(duration);
    }
}
