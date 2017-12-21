package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.bean.ShowRessBean;
import com.example.administrator.jingdong.model.IModel.IShowRessModel;
import com.example.administrator.jingdong.model.ShowRessModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.view.view.ShowRess_view;

import java.util.HashMap;
import java.util.Map;

/**
 * 吴占彬
 * 2017/12/16
 */

public class ShowRessPresneter {
    private IShowRessModel model;
    private ShowRess_view view;

    public ShowRessPresneter(ShowRess_view view) {
        this.view = view;
        model=new ShowRessModel();
    }
    public void showress(){
        int uid = view.uid();
        Map<String,String> map=new HashMap<>();
        map.put("uid",uid+"");
        map.put("source","android");
        model.showress(map, new OnNetLinsenter<ShowRessBean>() {
            @Override
            public void ChengGong(ShowRessBean bean) {
                view.showress(bean);
            }

            @Override
            public Void ShiBai(Exception e) {
                return null;
            }
        });
    }
}
