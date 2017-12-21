package com.example.administrator.jingdong.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.jingdong.MainActivity;
import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.bean.LoginBean;
import com.example.administrator.jingdong.bean.RegisterBean;
import com.example.administrator.jingdong.presenter.LoginPresenter;
import com.example.administrator.jingdong.presenter.RegPresenter;
import com.example.administrator.jingdong.util.ChengjinshiCode;
import com.example.administrator.jingdong.util.MySharedPreferences;
import com.example.administrator.jingdong.view.view.ILogin_view;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录类
 */
public class LoginActivity extends AutoLayoutActivity implements ILogin_view {

    @BindView(R.id.et_mobile)
    EditText etMobile;
    @BindView(R.id.et_pass)
    EditText etPass;
    @BindView(R.id.deng_btn)
    Button dengBtn;
    @BindView(R.id.zhuce)
    TextView zhuce;
    @BindView(R.id.qqdenglu)
    ImageView qqdenglu;
    private LoginPresenter presenter;
    private RegPresenter regPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //沉浸式
        ChengjinshiCode.getInstance().Immersive(getWindow(),getActionBar());
        //隐藏标题栏
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        ButterKnife.bind(this);
        //实例化P层调用方法
        presenter = new LoginPresenter(this);
        regPresenter=new RegPresenter(this);

    }

    @Override
    public void setBean(LoginBean bean) {
        LoginBean.DataBean data = bean.getData();
        String mobile = data.getMobile();
        String password = data.getPassword();
        int uid = data.getUid();
        MySharedPreferences.putString("loginname",mobile);
        MySharedPreferences.putString("loginpwd",password);
        MySharedPreferences.putInt("uid",uid);
        Toast.makeText(this, bean.getMsg(), Toast.LENGTH_LONG).show();
        Intent intent=new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void setZhuce(RegisterBean bean) {
        Toast.makeText(this, bean.getMsg(), Toast.LENGTH_LONG).show();
    }

    @Override
    public String getMobile() {
        return etMobile.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPass.getText().toString();
    }

    @OnClick({R.id.zhuce, R.id.qqdenglu,R.id.deng_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhuce:
                regPresenter.data();
                break;
            case R.id.qqdenglu:
                break;
            case R.id.deng_btn:
                presenter.Data();
                break;
                default:
        }
    }
}
