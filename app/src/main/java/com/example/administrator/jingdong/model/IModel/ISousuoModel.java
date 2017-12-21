package com.example.administrator.jingdong.model.IModel;

import com.example.administrator.jingdong.bean.SousuoBean;
import com.example.administrator.jingdong.net.OnNetLinsenter;

import java.util.Map;

/**
 * 吴占彬
 * 2017/12/18
 */

public interface ISousuoModel {
    void sousuo(Map<String,String> map, OnNetLinsenter<SousuoBean> linsenter);
}
