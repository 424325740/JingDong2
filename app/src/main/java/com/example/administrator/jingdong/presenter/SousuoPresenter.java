package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.bean.SousuoBean;
import com.example.administrator.jingdong.model.IModel.ISousuoModel;
import com.example.administrator.jingdong.model.SousuoModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.view.view.Sousuo_view;

import java.util.HashMap;
import java.util.Map;

/**
 * 吴占彬
 * 2017/12/18
 */

public class SousuoPresenter {
    private ISousuoModel model;
    private Sousuo_view view;

    public SousuoPresenter(Sousuo_view view) {
        this.view = view;
        model=new SousuoModel();
    }
    public void sousuodata(){
        String keywords = view.keywords();
        Map<String,String> map=new HashMap<>();
        map.put("keywords",keywords);
        map.put("source","android");
        model.sousuo(map, new OnNetLinsenter<SousuoBean>() {
            @Override
            public void ChengGong(SousuoBean bean) {
                view.sousuo(bean);
            }

            @Override
            public Void ShiBai(Exception e) {
                return null;
            }
        });
    }
}
