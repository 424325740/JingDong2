package com.example.administrator.jingdong.model;

import com.example.administrator.jingdong.bean.DeleteBean;
import com.example.administrator.jingdong.model.IModel.IDeleteModel;
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

public class DeleteModel implements IDeleteModel{
    @Override
    public void delete(Map<String, String> map, final OnNetLinsenter<DeleteBean> linsenter) {
        RetrofitHelper.getServiceApi().delete(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DeleteBean>() {
                    @Override
                    public void accept(DeleteBean deleteBean) throws Exception {
                    linsenter.ChengGong(deleteBean);
                    }
                });
    }
}
