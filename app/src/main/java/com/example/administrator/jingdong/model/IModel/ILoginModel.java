package com.example.administrator.jingdong.model.IModel;

import com.example.administrator.jingdong.bean.LoginBean;
import com.example.administrator.jingdong.net.OnNetLinsenter;

import java.util.Map;

/**
 * 吴占彬
 * 2017/12/8
 */

public interface ILoginModel {
    void Denglu(Map<String,String> map, OnNetLinsenter<LoginBean> linsenter);
}
