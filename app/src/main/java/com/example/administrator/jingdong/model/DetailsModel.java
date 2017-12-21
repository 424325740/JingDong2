package com.example.administrator.jingdong.model;

import com.example.administrator.jingdong.bean.DetailsBean;
import com.example.administrator.jingdong.model.IModel.IDetailsModel;
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

public class DetailsModel implements IDetailsModel{
    @Override
    public void Detailsdata(Map<String, String> map, final OnNetLinsenter<DetailsBean> linsenter) {
        RetrofitHelper.getServiceApi().xiangqing(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DetailsBean>() {
                    @Override
                    public void accept(DetailsBean detailsBean) throws Exception {
                        linsenter.ChengGong(detailsBean);
                    }
                });
    }
}
