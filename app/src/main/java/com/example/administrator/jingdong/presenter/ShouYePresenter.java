package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.bean.ShouYeBean;
import com.example.administrator.jingdong.model.IModel.IShouYeModel;
import com.example.administrator.jingdong.model.ShouyeModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.view.view.Shouye_view;

/**
 * 吴占彬
 * 2017/12/11
 */

public class ShouYePresenter {
    private IShouYeModel model;
    private Shouye_view view;

    public ShouYePresenter(Shouye_view view) {
        this.view = view;
        model=new ShouyeModel();
    }
    public void Data(){
        model.shouyedata(new OnNetLinsenter<ShouYeBean>() {
            @Override
            public void ChengGong(ShouYeBean shouYeBean) {
                if (shouYeBean.getCode().equals("0")){
                    view.Data(shouYeBean);
                }
            }

            @Override
            public Void ShiBai(Exception e) {
                return null;
            }
        });
    }
}
