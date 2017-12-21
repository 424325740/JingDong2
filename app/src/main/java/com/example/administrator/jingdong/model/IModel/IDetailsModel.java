package com.example.administrator.jingdong.model.IModel;

import com.example.administrator.jingdong.bean.DetailsBean;
import com.example.administrator.jingdong.net.OnNetLinsenter;

import java.util.Map;

/**
 * 吴占彬
 * 2017/12/13
 */

public interface IDetailsModel {
    void Detailsdata(Map<String,String> map, OnNetLinsenter<DetailsBean> linsenter);
}
