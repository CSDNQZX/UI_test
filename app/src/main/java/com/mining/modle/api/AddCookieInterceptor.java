package com.mining.modle.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by HJO on 2017/12/23.
 */


public class AddCookieInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder=chain.request().newBuilder();
         /*   接口请求时操作   */
        return chain.proceed(builder.build());

    }
}
