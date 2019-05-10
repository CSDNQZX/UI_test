package com.mining.modle.api;

import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by HJO on 2017/12/23.
 */


public class ApiNetManager{


    private static ApiNetManager apiNetManager;
    private static final int CONNEC_TIMEOUT = 60;
    private static final int READ_TIMEOUT = 30;
    public static ApiNetManager getInstence(){
        if (apiNetManager==null){
            synchronized (ApiNetManager.class){
                if (apiNetManager==null)
                    apiNetManager=new ApiNetManager();
            }
        }
        return apiNetManager;
    }


    public  <E> E  getRetrofitService(Class<E> rClass){
        //添加日志信息
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new CookiesInterceptor())
                .addInterceptor(new AddCookieInterceptor())
                .connectionPool(new ConnectionPool())
                .connectTimeout(CONNEC_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(rClass);
    }


}
