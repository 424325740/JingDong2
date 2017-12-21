package com.example.administrator.jingdong.model;

import com.example.administrator.jingdong.bean.RegisterBean;
import com.example.administrator.jingdong.model.IModel.IReginModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.util.RetrofitHelper;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 吴占彬
 * 2017/12/9
 */

public class RegModel implements IReginModel {

    @Override
    public void Zhuce(Map<String, String> map, final OnNetLinsenter<RegisterBean> linsenter) {
        RetrofitHelper.getServiceApi().reg(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisterBean>() {
                    @Override
                    public void accept(RegisterBean registerBean) throws Exception {
                        linsenter.ChengGong(registerBean);
                    }
                });
    }
}
