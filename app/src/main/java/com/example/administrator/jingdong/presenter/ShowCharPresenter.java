package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.bean.ShowCharBean;
import com.example.administrator.jingdong.model.IModel.IShowCharModel;
import com.example.administrator.jingdong.model.ShowCharModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.view.view.ShowChar_view;

import java.util.HashMap;
import java.util.Map;

/**
 * 吴占彬
 * 2017/12/15
 */

public class ShowCharPresenter {
    private IShowCharModel model;
    private ShowChar_view view;

    public ShowCharPresenter(ShowChar_view view) {
        this.view = view;
        model=new ShowCharModel();
    }
    public void showdata(){
        int uid = view.uid();
        Map<String,String> map=new HashMap<>();
        map.put("uid",uid+"");
        map.put("source","android");
        model.showchar(map, new OnNetLinsenter<ShowCharBean>() {
            @Override
            public void ChengGong(ShowCharBean bean) {
                view.showdata(bean);
            }

            @Override
            public Void ShiBai(Exception e) {
                return null;
            }
        });
    }
}
