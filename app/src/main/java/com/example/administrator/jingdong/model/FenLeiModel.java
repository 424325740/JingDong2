package com.example.administrator.jingdong.model;

import com.example.administrator.jingdong.bean.FenLeiBean;
import com.example.administrator.jingdong.model.IModel.IFenLeiModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.util.RetrofitHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 吴占彬
 * 2017/12/12
 */

public class FenLeiModel implements IFenLeiModel {
    @Override
    public void data(final OnNetLinsenter<FenLeiBean> linsenter) {
        RetrofitHelper.getServiceApi().fenLeiBean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FenLeiBean>() {
                    @Override
                    public void accept(FenLeiBean fenleiBean) throws Exception {
                        linsenter.ChengGong(fenleiBean);
                    }
                });
    }
}
