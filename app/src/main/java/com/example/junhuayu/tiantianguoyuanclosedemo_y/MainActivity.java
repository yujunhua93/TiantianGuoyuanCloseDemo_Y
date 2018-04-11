package com.example.junhuayu.tiantianguoyuanclosedemo_y;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    CountTimerView countT ;

    CloseDialog closeDialog;

    ViewGroup rootView;
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
                rootView.addView(closeDialog);
            }
        });
    }
}
