package com.example.administrator.jingdong.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.adapter.ShowRessAdapter;
import com.example.administrator.jingdong.bean.ShowRessBean;
import com.example.administrator.jingdong.presenter.ShowRessPresneter;
import com.example.administrator.jingdong.util.ChengjinshiCode;
import com.example.administrator.jingdong.util.MySharedPreferences;
import com.example.administrator.jingdong.view.view.ShowRess_view;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShwoAddressActivity extends AutoLayoutActivity implements ShowRess_view {

    @BindView(R.id.btn_address)
    Button btnAddress;
    @BindView(R.id.showaddress)
    RecyclerView showaddress;
    private int uid;
    private List<ShowRessBean.DataBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shwo_address);
        ButterKnife.bind(this);
        uid = MySharedPreferences.getInt("uid", 0);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        showaddress.setLayoutManager(manager);
        ShowRessPresneter presneter = new ShowRessPresneter(this);
        presneter.showress();
        //沉浸式
        ChengjinshiCode.getInstance().Immersive(getWindow(), getActionBar());
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }

    @OnClick({R.id.showaddress, R.id.btn_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.showaddress:
                break;
            case R.id.btn_address:
                Intent intent = new Intent(ShwoAddressActivity.this, AddressActivity.class);
                startActivity(intent);
                break;
            default:
        }
    }

    @Override
    public void showress(ShowRessBean bean) {
        list = bean.getData();
        ShowRessAdapter showRessAdapter = new ShowRessAdapter(list, this);
        showaddress.setAdapter(showRessAdapter);
        showRessAdapter.notifyDataSetChanged();
    }

    @Override
    public int uid() {
        return uid;
    }
}
