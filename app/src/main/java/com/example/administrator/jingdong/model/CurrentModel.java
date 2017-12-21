package com.example.administrator.jingdong.model;

import com.example.administrator.jingdong.bean.CurrentBean;
import com.example.administrator.jingdong.model.IModel.ICurrentModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.util.RetrofitHelper;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 吴占彬
 * 2017/12/13
 */

public class CurrentModel implements ICurrentModel{
    @Override
    public void currentdata(Map<String, String> map, final OnNetLinsenter<CurrentBean> linsenter) {
        RetrofitHelper.getServiceApi().currentbean(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Consumer<CurrentBean>() {
                    @Override
                    public void accept(CurrentBean currentBean) throws Exception {
                        linsenter.ChengGong(currentBean);
                    }
                });
    }
}
