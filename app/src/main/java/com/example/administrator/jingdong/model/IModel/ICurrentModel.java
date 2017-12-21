package com.example.administrator.jingdong.model.IModel;

import com.example.administrator.jingdong.bean.CurrentBean;
import com.example.administrator.jingdong.net.OnNetLinsenter;

import java.util.Map;

/**
 * 吴占彬
 * 2017/12/13
 */

public interface ICurrentModel {
    void currentdata(Map<String,String> map, OnNetLinsenter<CurrentBean> linsenter);
}
