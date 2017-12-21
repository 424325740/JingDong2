package com.example.administrator.jingdong.model.IModel;

import com.example.administrator.jingdong.bean.ShowCharBean;
import com.example.administrator.jingdong.net.OnNetLinsenter;

import java.util.Map;

/**
 * 吴占彬
 * 2017/12/15
 */

public interface IShowCharModel {
    void showchar(Map<String,String> map, OnNetLinsenter<ShowCharBean> linsenter);
}
