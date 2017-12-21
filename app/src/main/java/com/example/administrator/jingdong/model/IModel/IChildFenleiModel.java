package com.example.administrator.jingdong.model.IModel;

import com.example.administrator.jingdong.bean.ChildFenLeiBean;
import com.example.administrator.jingdong.net.OnNetLinsenter;

import java.util.Map;

/**
 * 吴占彬
 * 2017/12/13
 */

public interface IChildFenleiModel {
    void childdata(Map<String,String> map,OnNetLinsenter<ChildFenLeiBean> linsenter);
}
