package com.mining.power;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.mining.R;
import com.mining.modle.base.BaseActivity;

import butterknife.OnClick;

/*算力大小*/
public class NounTranslationActivity extends BaseActivity {
    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_noun_translation;
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
