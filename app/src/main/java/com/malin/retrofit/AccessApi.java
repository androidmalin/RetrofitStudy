package com.malin.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

//步骤2：定义网络请求的接口类
public interface AccessApi {

    // 注解GET：采用Get方法发送网络请求
    // Retrofit把网络请求的URL分成了2部分：1部分baseurl放在创建Retrofit对象时设置；另一部分在网络请求接口设置（即这里）
    // 如果接口里的URL是一个完整的网址，那么放在创建Retrofit对象时设置的部分可以不设置
    @GET("openapi.do?keyfrom=Yanzhikai&key=2032414398&type=data&doctype=json&version=1.1&q=car")
    Call<JavaBean> getCall();
    // 返回类型为Call<*>，*是解析得到的数据类型，即JavaBean
}
