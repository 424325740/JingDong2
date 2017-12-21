package com.example.administrator.jingdong.util;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 吴占彬
 * 2017/12/7
 */

public class LoginInterceptors implements Interceptor{
    @Override
    public Response intercept(Chain chain) throws IOException {

        //获取request
        Request request = chain.request();
        //判断当前的请求
        if (request.method().equals("POST")){
            //判断当前的请求Boby
            if (request.body() instanceof FormBody){
                //创建一个新的FromBoby
                FormBody.Builder bobyBuilder = new FormBody.Builder();
                //获取原先的boby
                FormBody body = (FormBody) request.body();
                //遍历boby
                for (int i = 0; i < body.size(); i++) {
                    //取出原先boby的数据  存入新的boby里
                    bobyBuilder.add(body.encodedName(i),body.encodedValue(i));
                }
                //添加制定的公共参数到新的boby里  把原先的boby给替换掉
                body=bobyBuilder.add("source","android").build();
                //获取新的request  取代原先的request
                request=request.newBuilder().post(body).build();
            }
        }
        //进行返回
        return chain.proceed(request);
    }
}
