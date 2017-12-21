package com.example.administrator.jingdong.model.IModel;

import com.example.administrator.jingdong.bean.RegisterBean;
import com.example.administrator.jingdong.net.OnNetLinsenter;

import java.util.Map;

/**
 * 吴占彬
 * 2017/12/8
 */

public interface IReginModel {
    void Zhuce(Map<String, String> map, OnNetLinsenter<RegisterBean> linsenter);
}
