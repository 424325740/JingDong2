package com.example.administrator.jingdong.model;

import com.example.administrator.jingdong.bean.ShowCharBean;
import com.example.administrator.jingdong.model.IModel.IShowCharModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.util.RetrofitHelper;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 吴占彬
 * 2017/12/15
 */

public class ShowCharModel implements IShowCharModel{
    @Override
    public void showchar(Map<String, String> map, final OnNetLinsenter<ShowCharBean> linsenter) {
        RetrofitHelper.getServiceApi().showCharBean(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShowCharBean>() {
                    @Override
                    public void accept(ShowCharBean showCharBean) throws Exception {
                        linsenter.ChengGong(showCharBean);
                    }
                });
    }
}
