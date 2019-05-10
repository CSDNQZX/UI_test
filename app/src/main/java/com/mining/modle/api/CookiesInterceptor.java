package com.mining.modle.api;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;


/**
 * Created by HJO on 2017/12/23.
 */

public class CookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

           Response CookieRespone= null;
        try {
            CookieRespone = chain.proceed(chain.request());
            if (! CookieRespone.headers("Set-Cookie").isEmpty()){
                String cookie =  CookieRespone.header("Set-Cookie").substring(0,CookieRespone.header("Set-Cookie").indexOf(";"));
                String url= CookieRespone.request().url().toString();


                Log.e("cookie","cookie="+cookie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return CookieRespone;
    }


}


