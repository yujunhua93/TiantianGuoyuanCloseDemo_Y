package com.example.junhuayu.tiantianguoyuanclosedemo_y;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by junhua.yu on 2018/4/11.
 */

public class CloseDialog extends ViewGroup {

    private Context mContext;

    private int mHeight;

    private int mWidth;

    private View rootView;

    private CountTimerView countTimerView;

    public CloseDialog(Context context) {
        this(context,null);
    }

    public CloseDialog(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CloseDialog(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    private void init() {
        rootView = LayoutInflater.from(mContext).inflate(R.layout.close_dialog_layout,null);
        addView(rootView);
        countTimerView = new CountTimerView(mContext);
        addView(countTimerView);
        countTimerView.startCountDown();
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
//        addView(countTimerView);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
