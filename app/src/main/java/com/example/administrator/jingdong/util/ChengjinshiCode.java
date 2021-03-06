package com.example.administrator.jingdong.util;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;

public class ChengjinshiCode {
  
      private static ChengjinshiCode chengjinshiCode;  
    // 构造函数私有化  
    public ChengjinshiCode() {  
    }  
    public static ChengjinshiCode getInstance() {  
  
        if (chengjinshiCode == null) {  
            // 加锁提高使用效率  
            synchronized (ChengjinshiCode.class) {  
                if (chengjinshiCode == null) {  
                    chengjinshiCode = new ChengjinshiCode();  
                }  
            }  
        }  
        return chengjinshiCode;  
  
    }  
  
    /***  
     * 状态栏透明化  
     * @param window    Window对象  
     * @param actionBar ActionBar对象  
     * ActionBar导包时不要导错了,要导：import android.app.ActionBar  
     */  
    public void Immersive(Window window, ActionBar actionBar) {
  
        if (Build.VERSION.SDK_INT >= 21) {
  
            View view = window.getDecorView();
            // TODO: 2017/4/13 两个FLAG一起使用表示会让应用的主体内容占用系统状态栏的时空间  
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;  
            view.setSystemUiVisibility(option);  
            // 将状态栏设置成透明色  
            window.setStatusBarColor(Color.TRANSPARENT);
  
        }  
     }  
}  