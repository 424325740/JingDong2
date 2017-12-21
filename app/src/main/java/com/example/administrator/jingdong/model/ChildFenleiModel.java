package com.example.administrator.jingdong.model;

import com.example.administrator.jingdong.bean.ChildFenLeiBean;
import com.example.administrator.jingdong.model.IModel.IChildFenleiModel;
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

public class ChildFenleiModel implements IChildFenleiModel {
    @Override
    public void childdata(Map<String,String> map, final OnNetLinsenter<ChildFenLeiBean> linsenter) {
        RetrofitHelper.getServiceApi().childfenlei(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ChildFenLeiBean>() {
                    @Override
                    public void accept(ChildFenLeiBean childFenLeiBean) throws Exception {
                        linsenter.ChengGong(childFenLeiBean);
                    }
                });
    }
}
