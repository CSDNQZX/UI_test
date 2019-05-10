package com.mining.modle.api;

import com.mining.main.model.MainModel;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by HJO on 2017/12/23.
 */

public interface RetrofitSrevice {

    @GET("")
    Observable<MainModel> getMainData();



}
