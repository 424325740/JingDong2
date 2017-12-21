package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.bean.AddRessBean;
import com.example.administrator.jingdong.model.AddRessModel;
import com.example.administrator.jingdong.model.IModel.IAddRessModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.view.view.AddRess_view;

import java.util.HashMap;
import java.util.Map;

/**
 * 吴占彬
 * 2017/12/16
 */

public class AddRessPresenter {
    private IAddRessModel model;
    private AddRess_view view;

    public AddRessPresenter(AddRess_view view) {
        this.view = view;
        model=new AddRessModel();
    }
    public void address(){
        String addr = view.addr();
        int uid = view.uid();
        String mobile = view.mobile();
        String name = view.name();
        Map<String,String> map=new HashMap<>();
        map.put("addr",addr);
        map.put("uid",uid+"");
        map.put("mobile",mobile);
        map.put("name",name);
        map.put("source","android");
        model.address(map, new OnNetLinsenter<AddRessBean>() {
            @Override
            public void ChengGong(AddRessBean bean) {
                if (bean.getCode().equals("0")) {
                    view.AddRess(bean);
                }
            }

            @Override
            public Void ShiBai(Exception e) {
                return null;
            }
        });
    }
}
