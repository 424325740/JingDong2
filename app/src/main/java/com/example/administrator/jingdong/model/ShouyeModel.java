package com.example.administrator.jingdong.model;

import com.example.administrator.jingdong.bean.ShouYeBean;
import com.example.administrator.jingdong.model.IModel.IShouYeModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.util.RetrofitHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 吴占彬
 * 2017/12/11
 */

public class ShouyeModel implements IShouYeModel {
    @Override
    public void shouyedata(final OnNetLinsenter<ShouYeBean> linsenter) {
        RetrofitHelper.getServiceApi().shouye()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShouYeBean>() {
                    @Override
                    public void accept(ShouYeBean shouYeBean) throws Exception {
                        linsenter.ChengGong(shouYeBean);
                    }
                });
    }
}
