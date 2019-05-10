package com.mining.modle.base;

import android.os.Bundle;
import android.view.View;

/**
 * Created by Auser on 2017/12/23.
 */

public abstract class MvpFragment<V extends IBaseView, P extends BasePresenter<V>>
        extends BaseFragment implements IBaseView {

    protected P mPresenter;

    protected abstract P createPresenter();

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        mPresenter = createPresenter();
//        try {
//            mPresenter.attachView((V) this);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        super.onCreate(savedInstanceState);
//    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mPresenter = createPresenter();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

}
