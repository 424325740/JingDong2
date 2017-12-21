package com.example.administrator.jingdong.net;

import com.example.administrator.jingdong.bean.AddCharBean;
import com.example.administrator.jingdong.bean.AddRessBean;
import com.example.administrator.jingdong.bean.ChildFenLeiBean;
import com.example.administrator.jingdong.bean.CurrentBean;
import com.example.administrator.jingdong.bean.DeleteBean;
import com.example.administrator.jingdong.bean.DetailsBean;
import com.example.administrator.jingdong.bean.FenLeiBean;
import com.example.administrator.jingdong.bean.LoginBean;
import com.example.administrator.jingdong.bean.RegisterBean;
import com.example.administrator.jingdong.bean.ShouYeBean;
import com.example.administrator.jingdong.bean.ShowRessBean;
import com.example.administrator.jingdong.bean.ShowCharBean;
import com.example.administrator.jingdong.bean.SousuoBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * 吴占彬
 * 2017/12/8
 */

public interface ServiceApi {
    /**
     * 登录
     * @param map
     * @return
     */
    @POST(ContentURl.Login)
    Observable<LoginBean> loginBean(@QueryMap Map<String,String> map);

    /**
     * 注册
     * @param map
     * @return
     */
    @POST(ContentURl.Reg)
    Observable<RegisterBean> reg(@QueryMap Map<String,String> map);
    /**
     * 首页
     */
    @GET(ContentURl.Shouye)
    Observable<ShouYeBean> shouye();
    /**
     * 分类
     */
    @POST(ContentURl.FenLei)
    Observable<FenLeiBean> fenLeiBean();
    /**
     * 子分类
     */
    @POST(ContentURl.ChildFenlei)
    Observable<ChildFenLeiBean> childfenlei(@QueryMap Map<String,String> map);
    /**
     * 当前子分类下的接口
     */
    @POST(ContentURl.CurrentChild)
    Observable<CurrentBean> currentbean(@QueryMap Map<String,String> map);
    /**
     * 详情接口
     */
    @POST(ContentURl.XiangQing)
    Observable<DetailsBean> xiangqing(@QueryMap Map<String,String> map);
    /**
     * 添加购物车接口
     */
    @POST(ContentURl.AddChar)
    Observable<AddCharBean> addCharBean(@QueryMap Map<String,String> map);
    /**
     * 查询购物车
     */
    @POST(ContentURl.ShowChar)
    Observable<ShowCharBean> showCharBean(@QueryMap Map<String,String> map);
    /**
     * 删除购物车
     */
    @POST(ContentURl.delete)
    Observable<DeleteBean> delete(@QueryMap Map<String,String> map);
    /**
     * 添加地址
     */
    @POST(ContentURl.AddRess)
    Observable<AddRessBean> addRessBean(@QueryMap Map<String,String> map);
    /**
     * 查询地址
     */
    @POST(ContentURl.ShowAddRess)
    Observable<ShowRessBean> showAddress(@QueryMap Map<String,String> map);
    /**
     * 搜索
     */
    @POST(ContentURl.Sousuo)
    Observable<SousuoBean> sousuobean(@QueryMap Map<String,String> map);
}
