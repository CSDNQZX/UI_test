package com.mining.modle.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Auser on 2017/12/23.
 */

public abstract class MvpActivity<V extends IBaseView, P extends BasePresenter<V>> extends BaseActivity2 implements IBaseView {

    protected P mPresenter;

    protected abstract P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        try {
            mPresenter.attachView((V) this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
