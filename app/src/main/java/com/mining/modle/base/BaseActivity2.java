package com.mining.modle.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Auser on 2017/12/23.
 */

public abstract class BaseActivity2 extends AppCompatActivity {
    // 上下文
    protected Context mContext;
    // application实例
    private BaseApplication application;
    private View mRootView;

    @LayoutRes
    protected abstract int getLayoutResId();

    /**
     * 设置点击事件
     */
    protected abstract void setListener();

    /**
     * 初始化View
     */
    protected abstract void initViews();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 获取自身上下文
        // 获取Application实例
        application = BaseApplication.getApplication();
        // 注册Activity
        application.registerActivity(this);
        mContext = this;
        mRootView = findViewById(android.R.id.content);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        initViews();
        //setListener();
        //initViews();
        // 获取顶部导航栏实例
        initBar();
        // 设置监听器
        setListener();
    }

    /**
     * [页面跳转,不带参数]
     * editors    zixin
     * @param clz
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(BaseActivity2.this,clz));
        //finish();
    }

    /**
     * [携带数据的页面跳转]
     *
     * @param clz
     * @param bundle
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * [含有Bundle通过Class打开编辑界面]
     *
     * @param cls
     * @param bundle
     * @param requestCode
     */
    public void startActivityForResult(Class<?> cls, Bundle bundle,int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 反注册Activity
        application.unregisterActivity(this);
    }

    protected void initBar() {

    }

    public void finishActivity() {
        super.finish();
    }

    public Context getmContext() {
        return mContext;
    }
}
