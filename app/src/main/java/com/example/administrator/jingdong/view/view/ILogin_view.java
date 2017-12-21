package com.example.administrator.jingdong.view.view;

import com.example.administrator.jingdong.bean.LoginBean;
import com.example.administrator.jingdong.bean.RegisterBean;

/**
 * Created by Administrator on 2017/11/2.
 * 用于登录、注册
 */

public interface ILogin_view {
    void setBean(LoginBean bean);
    void setZhuce(RegisterBean bean);
    String getMobile();
    String getPassword();
}
