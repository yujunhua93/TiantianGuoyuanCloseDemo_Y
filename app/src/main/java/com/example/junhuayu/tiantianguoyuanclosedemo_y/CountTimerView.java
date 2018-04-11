package com.example.junhuayu.tiantianguoyuanclosedemo_y;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by junhua.yu on 2018/4/11.
 */

public class CountTimerView extends View {

    //圆环画笔
    private Paint mRingPaint;

    //圆圈画笔
    private Paint mCriclePaint;

    //叉号画笔
    private Paint mXPaint;

    private float mCurrentProgress;

    private int mCountTime;

    public CountTimerView(Context context) {
        this(context,null);
    }

    public CountTimerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CountTimerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRingPaint = new Paint();
        mRingPaint.setColor(getResources().getColor(R.color.colorAccent));
        mRingPaint.setAntiAlias(true);
        mRingPaint.setDither(true);
        mRingPaint.setStrokeWidth(5.0f);
        mRingPaint.setStyle(Paint.Style.STROKE);

        mCriclePaint = new Paint();
        mCriclePaint.setColor(getResources().getColor(R.color.colorPrimaryDark));
        mCriclePaint.setAntiAlias(true);
        mCriclePaint.setDither(true);
        mCriclePaint.setStyle(Paint.Style.FILL);
        mCriclePaint.setStrokeWidth(5.0f);

        mXPaint = new Paint();
        mXPaint.setColor(getResources().getColor(R.color.white));
        mXPaint.setAntiAlias(true);
        mXPaint.setDither(true);
        mXPaint.setStyle(Paint.Style.STROKE);
        mXPaint.setStrokeWidth(5.0f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(50,50,100/2,mCriclePaint);
        RectF mRingf = new RectF();
        mRingf.left = 0;
        mRingf.top = 0;
        mRingf.right = 100;
        mRingf.bottom = 100;
        canvas.drawArc(mRingf,-90,mCurrentProgress-360,false,mRingPaint);
        canvas.drawLine(25,25,75,75,mXPaint);
        canvas.drawLine(25,75,75,25,mXPaint);
    }


    public void startCountDown(){
            ValueAnimator valueAnimator = getValueAnimatior(5 * 1000);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                   float i =  Float.valueOf(String.valueOf(valueAnimator.getAnimatedValue()));
                    mCurrentProgress = 360 * (i/100f);

                   postInvalidate();
                }
            });
            valueAnimator.start();
    }

    private ValueAnimator getValueAnimatior(long countDownTime){
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,100);
        valueAnimator.setDuration(countDownTime);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setRepeatCount(0);
        return valueAnimator;
    }

}
