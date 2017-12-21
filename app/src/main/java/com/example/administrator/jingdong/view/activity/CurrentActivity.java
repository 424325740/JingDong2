package com.example.administrator.jingdong.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.adapter.CurrentAdapter;
import com.example.administrator.jingdong.bean.CurrentBean;
import com.example.administrator.jingdong.presenter.CurrentPresenter;
import com.example.administrator.jingdong.util.ChengjinshiCode;
import com.example.administrator.jingdong.view.view.Current_view;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CurrentActivity extends AutoLayoutActivity implements Current_view {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.curr_finsh)
    ImageView currFinsh;
    @BindView(R.id.curr_fenlei)
    ImageView currFenlei;
    private int pscid;
    private List<CurrentBean.DataBean> list;
    int goodsType=0;
    private CurrentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current);
        //沉浸式
        ChengjinshiCode.getInstance().Immersive(getWindow(), getActionBar());
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        ButterKnife.bind(this);
        Intent intent = getIntent();
        pscid = intent.getIntExtra("pscid", 0);
        CurrentPresenter presenter = new CurrentPresenter(this);
        presenter.currentdata();
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void CurrentData(CurrentBean bean) {
        list = bean.getData();
        adapter = new CurrentAdapter(list, this);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new CurrentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int pid = list.get(position).getPid();
                Intent intent = new Intent(CurrentActivity.this, DetailsActivity.class);
                intent.putExtra("pid", pid);
                startActivity(intent);
            }
        });
    }

    @Override
    public int pscid() {
        return pscid;
    }


    @OnClick({R.id.curr_finsh, R.id.curr_fenlei})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.curr_finsh:
                finish();
                break;
            case R.id.curr_fenlei:
                if (goodsType==0){
                    currFenlei.setImageResource(R.mipmap.a_4);
                    //1：设置布局类型
                    adapter.setType(1);
                    //2：设置对应的布局管理器
                    rv.setLayoutManager(new GridLayoutManager(this,2));
                    //3：刷新adapter
                    adapter.notifyDataSetChanged();
                    goodsType=1;
                }else {
                    currFenlei.setImageResource(R.mipmap.a_r);
                    adapter.setType(0);
                    rv.setLayoutManager(new LinearLayoutManager(this));
                    adapter.notifyDataSetChanged();
                    goodsType=0;
                }
                break;
                default:
        }
    }
}
