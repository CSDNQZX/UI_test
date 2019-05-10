package com.mining.power;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.mining.modle.base.BaseActivity;

import butterknife.BindView;

public class BTCPaymentActivity extends BaseActivity {
    @BindView(R.id.title_text)
    TextView title_text;//标题
   /* @BindView(R.id.add_btn)
    TextView add_btn;//标题*/
    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_btc_payment;
    }
    /***
     * 相关 代码业务的处理
     * @param activity
     */
    @Override
    public void doBusiness(Activity activity) {
        setSteepStatusBar(true);
        initView();
    }
    /*初始化*/
    public void initView() {
        title_text.setText(getResources().getString(R.string.x6));
        //add_btn.setText(getResources().getString(R.string.s4));
    }
}
