package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.bean.ChildFenLeiBean;
import com.example.administrator.jingdong.model.ChildFenleiModel;
import com.example.administrator.jingdong.model.IModel.IChildFenleiModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.view.view.Childfenlei_view;

import java.util.HashMap;
import java.util.Map;

/**
 * 吴占彬
 * 2017/12/13
 */

public class ChildfenleiPresenter {
    private IChildFenleiModel model;
    private Childfenlei_view view;

    public ChildfenleiPresenter(Childfenlei_view view) {
        this.view = view;
        model=new ChildFenleiModel();
    }
    public void ChildData(){
        int cid = view.cid();
        Map<String,String> map=new HashMap<>();
        map.put("cid",cid+"");
        map.put("source","android");
        model.childdata(map, new OnNetLinsenter<ChildFenLeiBean>() {
            @Override
            public void ChengGong(ChildFenLeiBean bean) {
                view.childdata(bean.getData());
            }

            @Override
            public Void ShiBai(Exception e) {
                return null;
            }
        });
    }
}
