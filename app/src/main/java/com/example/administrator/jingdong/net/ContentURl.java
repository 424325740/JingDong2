package com.example.administrator.jingdong.net;

/**
 * 吴占彬
 * 2017/12/8
 */

public interface ContentURl {
    /**
     * 请求头
     */
    String Host="https://www.zhaoapi.cn/";
    /**
     * 登录接口
     */
    String Login="user/login";
    /**
     * 注册接口
     */
    String Reg="user/reg";
    /**
     * 首页
     */
    String Shouye="ad/getAd";
    /**
     * 分类
     */
    String FenLei="product/getCatagory";
    /**
     * 子分类
     */
    String ChildFenlei="product/getProductCatagory";
    /**
     * 当前子分类下的列表
     */
    String CurrentChild="product/getProducts";
    /**
     * 商品详情
     */
    String XiangQing="product/getProductDetail";
    /**
     * 加入购物车
     */
    String AddChar="product/addCart";
    /**
     * 查询购物车
     */
    String ShowChar="product/getCarts";
    /**
     * 删除购物车
     */
    String delete="product/deleteCart";
    /**
     * 订单
     */
    String Dingdan="product/getOrders";
    /**
     * 添加地址
     */
    String AddRess="user/addAddr";
    /**
     * 查询地址
     */
    String ShowAddRess="user/getAddrs";
    /**
     * 搜索
     */
    String Sousuo="product/searchProducts";

}
