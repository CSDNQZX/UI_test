package com.mining.orepool;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.mining.R;
import com.mining.MainActivity;
import com.mining.modle.base.BaseActivity;

import butterknife.OnClick;

/*矿池介绍*/
public class IntroductionOrepondActivity extends BaseActivity {
    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_introduction_orepond;
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
        Bundle b = new Bundle();
        b.putString("home", "1");
        startActivity(MainActivity.class,b);
    }
    /*币种介绍*/
    @OnClick(R.id.js_id) void js_id() {
        startActivity(CurrencyIntroductionActivity.class);
    }

    @OnClick(R.id.kj_id) void kj_id() {
        startActivity(IntroductionMachineActivity.class);
    }


}
