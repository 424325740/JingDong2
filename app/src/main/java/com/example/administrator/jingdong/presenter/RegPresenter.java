package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.bean.RegisterBean;
import com.example.administrator.jingdong.model.IModel.IReginModel;
import com.example.administrator.jingdong.model.RegModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.view.view.ILogin_view;

import java.util.HashMap;
import java.util.Map;

/**
 * 吴占彬
 * 2017/12/9
 */

public class RegPresenter {
    private IReginModel model;
    private ILogin_view view;

    public RegPresenter(ILogin_view view) {
        this.view = view;
        model=new RegModel();
    }
    public void data(){

        String mobile = view.getMobile();
        String password = view.getPassword();
        Map<String,String> map=new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",password);
        map.put("source","android");
        model.Zhuce(map, new OnNetLinsenter<RegisterBean>() {
            @Override
            public void ChengGong(RegisterBean registerBean) {
                view.setZhuce(registerBean);
            }

            @Override
            public Void ShiBai(Exception e) {
                return null;
            }
        });


    }

}
