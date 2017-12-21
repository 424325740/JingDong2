package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.bean.AddCharBean;
import com.example.administrator.jingdong.model.AddCharModel;
import com.example.administrator.jingdong.model.IModel.IAddCharModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.view.view.AddChar_view;

import java.util.HashMap;
import java.util.Map;

/**
 * 吴占彬
 * 2017/12/15
 */

public class AddcharPresenter {
    private IAddCharModel model;
    private AddChar_view view;

    public AddcharPresenter(AddChar_view view) {
        this.view = view;
        model=new AddCharModel();
    }
    public void chardata(){
        int pid = view.pid();
        int uid = view.uid();
        Map<String,String> map=new HashMap<>();
        map.put("uid",uid+"");
        map.put("pid",pid+"");
        map.put("source","android");
        model.addchar(map, new OnNetLinsenter<AddCharBean>() {
            @Override
            public void ChengGong(AddCharBean addCharBean) {
                view.CharBean(addCharBean);
            }

            @Override
            public Void ShiBai(Exception e) {
                return null;
            }
        });
    }
}
