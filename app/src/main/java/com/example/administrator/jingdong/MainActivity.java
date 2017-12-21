package com.example.administrator.jingdong;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

import com.example.administrator.jingdong.fragment.ClassifyFragment;
import com.example.administrator.jingdong.fragment.FaxianFragment;
import com.example.administrator.jingdong.fragment.HomeFragment;
import com.example.administrator.jingdong.fragment.MyFragment;
import com.example.administrator.jingdong.fragment.ShopcartFragment;
import com.example.administrator.jingdong.util.ChengjinshiCode;
import com.hjm.bottomtabbar.BottomTabBar;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AutoLayoutActivity {

    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //沉浸式
        ChengjinshiCode.getInstance().Immersive(getWindow(),getActionBar());
        //隐藏标题栏
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        ButterKnife.bind(this);
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(40, 40)
                .setFontSize(10)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.BLACK)
                .addTabItem("首页", R.mipmap.bc4, HomeFragment.class)
                .addTabItem("分类", R.mipmap.classify, ClassifyFragment.class)
                .addTabItem("发现", R.mipmap.fenxiang, FaxianFragment.class)
                .addTabItem("购物车", R.mipmap.bco, ShopcartFragment.class)
                .addTabItem("我的", R.mipmap.aa7, MyFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }
}
