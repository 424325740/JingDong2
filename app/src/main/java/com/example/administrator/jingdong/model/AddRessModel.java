package com.example.administrator.jingdong.model;

import com.example.administrator.jingdong.bean.AddRessBean;
import com.example.administrator.jingdong.model.IModel.IAddRessModel;
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

public class AddRessModel implements IAddRessModel {
    @Override
    public void address(Map<String, String> map, final OnNetLinsenter<AddRessBean> linsenter) {
        RetrofitHelper.getServiceApi().addRessBean(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AddRessBean>() {
                    @Override
                    public void accept(AddRessBean addRessBean) throws Exception {
                        linsenter.ChengGong(addRessBean);
                    }
                });
    }
}
