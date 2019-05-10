package com.mining.orepool;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.mining.R;
import com.mining.MainActivity;
import com.mining.modle.base.BaseActivity;

import butterknife.OnClick;

public class CurrencyIntroductionActivity extends BaseActivity {
    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_currency_introduction;
    }
    /***
     * 相关 代码业务的处理
     * @param activity
     */
    @Override
    public void doBusiness(Activity activity) {
        setSteepStatusBar(true);
    }

    /*返回*/
    @OnClick(R.id.ic_reback) void news_btn() {
        this.finish();
    }
}
