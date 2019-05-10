package com.mining.modle.base;

/**
 * Created by Auser on 2017/12/23.
 */

public interface IBaseView {

    void showRefresh();
    void getDataSuccess(Object response);
    void getDataFail(String msg);
    void finishRefresh();

}
