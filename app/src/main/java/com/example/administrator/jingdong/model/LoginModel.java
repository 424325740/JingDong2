package com.example.administrator.jingdong.model;

import com.example.administrator.jingdong.bean.LoginBean;
import com.example.administrator.jingdong.model.IModel.ILoginModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.util.RetrofitHelper;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 吴占彬
 * 2017/12/8
 */

public class LoginModel implements ILoginModel {
    @Override
    public void Denglu(Map<String, String> map, final OnNetLinsenter<LoginBean> linsenter) {
        RetrofitHelper.getServiceApi().loginBean(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean javaBean) throws Exception {
                        linsenter.ChengGong(javaBean);
                    }
                });
    }
}
