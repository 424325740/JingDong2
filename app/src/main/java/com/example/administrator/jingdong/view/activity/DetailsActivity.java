package com.example.administrator.jingdong.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.fragment.tab.Find_hotCollectionFragment;
import com.example.administrator.jingdong.fragment.tab.Find_hotMonthFragment;
import com.example.administrator.jingdong.fragment.tab.Find_hotRecommendFragment;
import com.example.administrator.jingdong.util.ChengjinshiCode;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends AutoLayoutActivity {

    String[] title={"商品","详情","评价"};
    private TabLayout tb;
    private ViewPager vp;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //找控件
        tb = (TabLayout) findViewById(R.id.tb);
        vp =(ViewPager)findViewById(R.id.vp);
        initdata();
        //创建适配器
        MyViewPager adapter=new MyViewPager(getSupportFragmentManager());
        vp.setAdapter(adapter);
        tb.setupWithViewPager(vp);
        //沉浸式
        ChengjinshiCode.getInstance().Immersive(getWindow(), getActionBar());
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        ButterKnife.bind(this);


    }
    public void initdata(){
        list = new ArrayList<Fragment>();
        list.add(new Find_hotCollectionFragment());
        list.add(new Find_hotMonthFragment());
        list.add(new Find_hotRecommendFragment());
    }
    //创建适配器
    public class  MyViewPager extends FragmentPagerAdapter {

        public MyViewPager(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        @Override
        public Fragment getItem(int arg0) {
            // TODO Auto-generated method stub
            return list.get(arg0);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            // TODO Auto-generated method stub
            return title[position];
        }

    }




    @OnClick(R.id.finsh)
    public void onViewClicked() {
        finish();
    }

}
