package com.example.administrator.jingdong.model;

import com.example.administrator.jingdong.bean.SousuoBean;
import com.example.administrator.jingdong.model.IModel.ISousuoModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.util.RetrofitHelper;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 吴占彬
 * 2017/12/18
 */

public class SousuoModel implements ISousuoModel {
    @Override
    public void sousuo(Map<String, String> map, final OnNetLinsenter<SousuoBean> linsenter) {
        RetrofitHelper.getServiceApi().sousuobean(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SousuoBean>() {
                    @Override
                    public void accept(SousuoBean sousuoBean) throws Exception {
                        linsenter.ChengGong(sousuoBean);
                    }
                });
    }
}
