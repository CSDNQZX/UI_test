package com.mining.modle.base;
import com.mining.modle.api.ApiNetManager;
import com.mining.modle.api.RetrofitSrevice;

import java.lang.ref.WeakReference;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by Auser on 2017/12/23.
 */

public abstract class BasePresenter<V extends IBaseView> {

    public  WeakReference<V> mViewRef;
    private CompositeSubscription mCompositeSubscription;

    public BasePresenter() {

    }

    protected V getView() {
        return mViewRef.get();
    }

    // 进行绑定
    void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }



    protected RetrofitSrevice getRetrofitSrevice(){
        return  ApiNetManager.getInstence().getRetrofitService( RetrofitSrevice.class);
    }



    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    //解绑
    void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
        }
        onUnsubscribe();
    }

    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }


}
