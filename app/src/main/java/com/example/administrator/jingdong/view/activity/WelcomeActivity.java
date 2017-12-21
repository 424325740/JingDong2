package com.example.administrator.jingdong.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.jingdong.MainActivity;
import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.util.ChengjinshiCode;

public class WelcomeActivity extends AppCompatActivity {
    //创建Handler
    Handler handler;
    //定义一个变量
    int item=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //沉浸式
        ChengjinshiCode.getInstance().Immersive(getWindow(), getActionBar());
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 让item--

                //判断
                if (item==1) {
                    //item==1的时候就跳转
                    Intent intent=new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                item--;
                handler.postDelayed(this,2000);
            }
        },2000);
    }
}
