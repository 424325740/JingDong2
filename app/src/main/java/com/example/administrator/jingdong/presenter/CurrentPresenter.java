package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.bean.CurrentBean;
import com.example.administrator.jingdong.model.CurrentModel;
import com.example.administrator.jingdong.model.IModel.ICurrentModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.view.view.Current_view;

import java.util.HashMap;
import java.util.Map;

/**
 * 吴占彬
 * 2017/12/13
 */

public class CurrentPresenter {
    private ICurrentModel model;
    private Current_view view;

    public CurrentPresenter(Current_view view) {
        this.view = view;
        model=new CurrentModel();
    }
    public void currentdata(){
        int pscid = view.pscid();
        Map<String,String> map=new HashMap<>();
        map.put("pscid",pscid+"");
        map.put("source","android");
        model.currentdata(map, new OnNetLinsenter<CurrentBean>() {
            @Override
            public void ChengGong(CurrentBean bean) {
                view.CurrentData(bean);
            }

            @Override
            public Void ShiBai(Exception e) {
                return null;
            }
        });
    }
}
