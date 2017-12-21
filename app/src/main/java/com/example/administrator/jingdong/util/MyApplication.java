package com.example.administrator.jingdong.util;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 吴占彬
 * 2017/12/10
 */

public class MyApplication extends Application{
    @Override
    public void onCreate(){
        super.onCreate();
        MySharedPreferences.init(this);
        Fresco.initialize(this);
    }
}
