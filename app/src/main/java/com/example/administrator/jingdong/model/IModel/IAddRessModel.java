package com.example.administrator.jingdong.model.IModel;

import com.example.administrator.jingdong.bean.AddRessBean;
import com.example.administrator.jingdong.net.OnNetLinsenter;

import java.util.Map;

/**
 * 吴占彬
 * 2017/12/16
 */

public interface IAddRessModel {
    void address(Map<String,String> map, OnNetLinsenter<AddRessBean> linsenter);
}
