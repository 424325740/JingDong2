package com.example.administrator.jingdong.model.IModel;

import com.example.administrator.jingdong.bean.FenLeiBean;
import com.example.administrator.jingdong.net.OnNetLinsenter;

/**
 * 吴占彬
 * 2017/12/12
 */

public interface IFenLeiModel {
    void data(OnNetLinsenter<FenLeiBean> linsenter);
}
