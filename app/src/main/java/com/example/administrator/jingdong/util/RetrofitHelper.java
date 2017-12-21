package com.example.administrator.jingdong.util;

import com.example.administrator.jingdong.net.ContentURl;
import com.example.administrator.jingdong.net.ServiceApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 吴占彬
 * 2017/12/8
 */

public class RetrofitHelper {
    public static OkHttpClient okHttpClient;
    public static ServiceApi serviceApi;
    static {
        initOkHttpClient();
    }

    private static void initOkHttpClient() {
        if (okHttpClient==null){
            synchronized (RetrofitHelper.class){
                if (okHttpClient==null){
                    okHttpClient=new OkHttpClient.Builder()
//                            .addInterceptor(new LoginInterceptors())
                            .build();
                }
            }
        }
    }
    public static <T>T createrApi(Class<T> tClass,String url){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(tClass);
    }
    public static ServiceApi getServiceApi(){
        if (serviceApi==null){
            synchronized (RetrofitHelper.class){
                if (serviceApi==null){
                    serviceApi=createrApi(ServiceApi.class, ContentURl.Host);
                }
            }
        }
        return serviceApi;
    }
}
