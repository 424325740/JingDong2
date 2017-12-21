package com.example.administrator.jingdong.view.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.adapter.SousuoAdapter;
import com.example.administrator.jingdong.bean.SousuoBean;
import com.example.administrator.jingdong.presenter.SousuoPresenter;
import com.example.administrator.jingdong.util.ChengjinshiCode;
import com.example.administrator.jingdong.view.view.Sousuo_view;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowSousuoActivity extends AppCompatActivity implements Sousuo_view {

    @BindView(R.id.et_sousuo)
    EditText etSousuo;
    @BindView(R.id.sousuo)
    ImageView sousuo;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.finsh)
    ImageView finsh;
    private SousuoPresenter presenter;
    private List<SousuoBean.DataBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sousuo);
        ButterKnife.bind(this);
        ChengjinshiCode.getInstance().Immersive(getWindow(), getActionBar());
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        presenter = new SousuoPresenter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);

    }


    @Override
    public void sousuo(SousuoBean bean) {
        list = bean.getData();
        rv.setAdapter(new SousuoAdapter(this, list));
    }

    @Override
    public String keywords() {
        return etSousuo.getText().toString();
    }

    @OnClick({R.id.finsh, R.id.sousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.finsh:
                finish();
                break;
            case R.id.sousuo:
                presenter.sousuodata();
                break;
                default:
        }
    }
}
