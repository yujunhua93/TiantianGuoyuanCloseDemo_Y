package com.example.junhuayu.tiantianguoyuanclosedemo_y;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    CountTimerView countT ;

    CloseDialog closeDialog;

    ViewGroup rootView;


    PopupWindow popupWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countT = findViewById(R.id.countT);
        countT.startCountDown();
        rootView = (ViewGroup) this.getWindow().getDecorView();
        closeDialog = new CloseDialog(this);
        final View mview = LayoutInflater.from(this).inflate(R.layout.close_dialog_layout,null);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                rootView.addView(mview);
//                rootView.addView(closeDialog);
                showPopupWindow();
            }
        });

    }

    private void showPopupWindow() {
            final ViewGroup contentView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.close_dialog_layout,null);
            final PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            popupWindow.setFocusable(true);
            popupWindow.showAtLocation(rootView, Gravity.CENTER,0,0);
            final CountTimerView countTimerView = contentView.findViewById(R.id.close_iv);
            countTimerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
             });
            final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(countTimerView,"translationY",0,-50);
            objectAnimator.start();
            objectAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    countTimerView.startCountDown();
                    ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(contentView,"alpha",0.0f);
                    objectAnimator1.setDuration(5000);
                    objectAnimator1.start();
                    objectAnimator1.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            popupWindow.dismiss();
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });

                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
    }
}
