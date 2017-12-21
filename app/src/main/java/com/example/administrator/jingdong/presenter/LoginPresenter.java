package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.bean.LoginBean;
import com.example.administrator.jingdong.model.IModel.ILoginModel;
import com.example.administrator.jingdong.model.LoginModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.view.view.ILogin_view;

import java.util.HashMap;
import java.util.Map;

/**
 * 吴占彬
 * 2017/12/8
 */

public class LoginPresenter {
    private ILoginModel model;
    private ILogin_view view;

    public LoginPresenter(ILogin_view view) {
        this.view = view;
        model=new LoginModel();
    }
    //数据交互方法
    public void Data(){
        String mobile = view.getMobile();
        String password = view.getPassword();
        Map<String,String> map=new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",password);
        map.put("source","android");
        model.Denglu(map, new OnNetLinsenter<LoginBean>() {
            @Override
            public void ChengGong(LoginBean loginBean) {
                String code = loginBean.getCode();
                if (code.equals("0")){
                    view.setBean(loginBean);
                }
            }

            @Override
            public Void ShiBai(Exception e) {
                return null;
            }
        });
    }
}
