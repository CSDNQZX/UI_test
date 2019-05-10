package com.mining.modle.api;


import retrofit2.HttpException;
import rx.Subscriber;

/**
 * Created by HJO on 2017/12/23.
 */

public abstract class ApiNetCallBack <T> extends Subscriber<T> {

    public abstract void onSuccess(T response);
    

    public abstract void onError(String msg);

    public abstract void onFinish();

    @Override
    public void onCompleted() {
        onFinish();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            String msg = httpException.getMessage();

            if (code == 504) {
                msg = "网络不给力!";
            }
            if (code == 502 || code == 404) {
                msg = "服务器异常!";
            }
            onError(msg);
        } else {
            onError(e.getMessage());
        }
        onFinish();
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }


}
