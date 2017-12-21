package com.example.administrator.jingdong.model.IModel;

import com.example.administrator.jingdong.bean.ShouYeBean;
import com.example.administrator.jingdong.net.OnNetLinsenter;

/**
 * 吴占彬
 * 2017/12/11
 */

public interface IShouYeModel {
    void shouyedata(OnNetLinsenter<ShouYeBean> linsenter);
}
