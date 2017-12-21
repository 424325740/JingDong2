package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.bean.DetailsBean;
import com.example.administrator.jingdong.model.DetailsModel;
import com.example.administrator.jingdong.model.IModel.IDetailsModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.view.view.Detail_view;

import java.util.HashMap;
import java.util.Map;

/**
 * 吴占彬
 * 2017/12/13
 */

public class DetailsPresenter {
    private IDetailsModel model;
    private Detail_view view;

    public DetailsPresenter(Detail_view view) {
        this.view = view;
        model=new DetailsModel();
    }
    public void detailsdata(){
        int pid = view.pid();
        Map<String,String> map=new HashMap<>();
        map.put("pid",pid+"");
        map.put("source","android");
        model.Detailsdata(map, new OnNetLinsenter<DetailsBean>() {
            @Override
            public void ChengGong(DetailsBean bean) {
                view.details(bean);
            }

            @Override
            public Void ShiBai(Exception e) {
                return null;
            }
        });
    }
}
