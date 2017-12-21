package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.bean.FenLeiBean;
import com.example.administrator.jingdong.model.FenLeiModel;
import com.example.administrator.jingdong.model.IModel.IFenLeiModel;
import com.example.administrator.jingdong.net.OnNetLinsenter;
import com.example.administrator.jingdong.view.view.IFenLei_view;

/**
 * 吴占彬
 * 2017/12/12
 */

public class FenLeiPresenter {
    private IFenLeiModel model;
    private IFenLei_view view;

    public FenLeiPresenter(IFenLei_view view) {
        this.view = view;
        model=new FenLeiModel();
    }
    public void data(){
        model.data(new OnNetLinsenter<FenLeiBean>() {
            @Override
            public void ChengGong(FenLeiBean fenLeiBean) {
                view.setcid(fenLeiBean.getData());
            }

            @Override
            public Void ShiBai(Exception e) {
                return null;
            }
        });
    };
}
