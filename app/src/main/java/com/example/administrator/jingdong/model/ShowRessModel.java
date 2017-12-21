package com.example.administrator.jingdong.model;

import com.example.administrator.jingdong.bean.ShowRessBean;
import com.example.administrator.jingdong.model.IModel.IShowRessModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.util.RetrofitHelper;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 吴占彬
 * 2017/12/16
 */

public class ShowRessModel implements IShowRessModel {

    @Override
    public void showress(Map<String, String> map, final OnNetLinsenter<ShowRessBean> linsenter) {
        RetrofitHelper.getServiceApi().showAddress(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShowRessBean>() {
                    @Override
                    public void accept(ShowRessBean showAddRessBean) throws Exception {
                        linsenter.ChengGong(showAddRessBean);
                    }
                });
    }
}
