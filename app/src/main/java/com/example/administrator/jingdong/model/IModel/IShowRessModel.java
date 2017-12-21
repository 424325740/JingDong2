package com.example.administrator.jingdong.model.IModel;

import com.example.administrator.jingdong.bean.ShowRessBean;
import com.example.administrator.jingdong.net.OnNetLinsenter;

import java.util.Map;

/**
 * 吴占彬
 * 2017/12/16
 */

public interface IShowRessModel {
    void showress(Map<String,String> map, OnNetLinsenter<ShowRessBean> linsenter);
}
