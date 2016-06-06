# GoodViewDemo
模仿点赞效果
//核心代码：整体是一个popuuwindow
//给效果设定布局
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
        
        
  //初始化动画     
  mAnimation = new AnimationSet(true);
        TranslateAnimation trans = new TranslateAnimation(0,0,from_y_delta,-distance);
        AlphaAnimation alpha = new AlphaAnimation(from_alpha,to_alpha);
        mAnimation.addAnimation(trans);
        mAnimation.addAnimation(alpha);
        mAnimation.setDuration(Duration);
        mAnimation.setFillAfter(true);
