package com.mining.modle.base;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.mining.R;

import butterknife.ButterKnife;

/**
 * Created by Auser on 2017/12/23.
 */

public abstract class BaseFragment extends Fragment {

    // 自身所属Activity实例
    protected Activity mContext;
    // 根视图实例
    protected View mRootView;

    @LayoutRes
    protected abstract int getLayoutResId();

    /**
     * 设置点击事件
     */
    protected abstract void setListener();

    /**
     * 初始化View
     */
    protected abstract void initViews(View view);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutResId() > 0) {
            View view = null;
            if (mRootView == null) {
                view = inflater.inflate(getLayoutResId(), container, false);
            }

            // 绑定控件
            if (mRootView == null) {
                mRootView = view;
                ButterKnife.bind(this,mRootView);
                // 初始化界面
                initViews( view);
                // 获取顶部导航栏实例
                initBar();
                // 设置监听器
                setListener();
            }
        }

        return mRootView;
    }

    protected void initBar() {

    }


    /**
     * [页面跳转,不带参数]
     * editors    zixin
     * @param clz
     */
    public void startFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.view_page_fragemnts,fragment);
        transaction.commit();

    }

    /**
     * [页面跳转,不带参数]
     * editors    zixin
     * @param clz
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(),clz));
        getActivity().finish();
    }

    /**
     * [页面跳转,带参数]
     * editors    zixin
     * @param clz
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * [简化Toast]
     * @param msg
     */
    protected void showToast(String msg){
        Toast.makeText(getActivity(),msg, Toast.LENGTH_SHORT).show();
    }


}
