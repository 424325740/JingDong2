package com.example.administrator.jingdong.view.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.bean.AddRessBean;
import com.example.administrator.jingdong.presenter.AddRessPresenter;
import com.example.administrator.jingdong.util.ChengjinshiCode;
import com.example.administrator.jingdong.util.MySharedPreferences;
import com.example.administrator.jingdong.view.view.AddRess_view;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressActivity extends AutoLayoutActivity implements AddRess_view{

    @BindView(R.id.finsh)
    ImageView finsh;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_mobile)
    EditText etMobile;
    @BindView(R.id.et_region)
    EditText etRegion;
    @BindView(R.id.et_address)
    EditText etAddress;
    @BindView(R.id.btn)
    Button btn;
    private int uid;
    private AddRessPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        //沉浸式
        ChengjinshiCode.getInstance().Immersive(getWindow(),getActionBar());
        //隐藏标题栏
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        presenter = new AddRessPresenter(this);
        uid = MySharedPreferences.getInt("uid", 0);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.finsh, R.id.btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.finsh:
                finish();
                break;
            case R.id.btn:
                presenter.address();
                Toast.makeText(this,"添加成功",Toast.LENGTH_LONG).show();
                break;
                default:
        }
    }

    @Override
    public void AddRess(AddRessBean bean) {

    }

    @Override
    public int uid() {
        return uid;
    }

    @Override
    public String addr() {
        return etAddress.getText().toString();
    }

    @Override
    public String mobile() {
        return etMobile.getText().toString();
    }

    @Override
    public String name() {
        return etName.getText().toString();
    }
}
