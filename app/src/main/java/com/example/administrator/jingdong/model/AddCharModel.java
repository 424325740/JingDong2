package com.example.administrator.jingdong.model;

import com.example.administrator.jingdong.bean.AddCharBean;
import com.example.administrator.jingdong.model.IModel.IAddCharModel;
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

public class AddCharModel implements IAddCharModel{
    @Override
    public void addchar(Map<String, String> map, final OnNetLinsenter<AddCharBean> linsenter) {
        RetrofitHelper.getServiceApi().addCharBean(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AddCharBean>() {
                    @Override
                    public void accept(AddCharBean addCharBean) throws Exception {
                        linsenter.ChengGong(addCharBean);
                    }
                });
    }
}
