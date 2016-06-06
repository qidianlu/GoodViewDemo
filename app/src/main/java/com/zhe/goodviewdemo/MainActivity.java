package com.zhe.goodviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhe.goodviewdemo.view.GoodView;

public class MainActivity extends AppCompatActivity {

    private GoodView goodView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goodView = new GoodView(this);

    }

    public void text(View v){
        goodView.setText("+2");
        goodView.setTextColor(Color.parseColor("#0000ff"));
        goodView.setDuration(1000);
        goodView.show(v);
    }
}
