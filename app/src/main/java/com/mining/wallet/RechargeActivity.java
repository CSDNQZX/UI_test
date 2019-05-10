package com.mining.wallet;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.mining.MainActivity;
import com.mining.mine.PersonCenterActivity;
import com.mining.modle.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class RechargeActivity extends BaseActivity {
    @BindView(R.id.title_text)
    TextView title_text;//标题
    @BindView(R.id.add_btn)
    TextView add_btn;//标题
    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_recharge;
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
        title_text.setText(getResources().getString(R.string.a5));
        add_btn.setText(getResources().getString(R.string.s4));
    }

    /*充值记录*/
    @OnClick(R.id.add_btn) void btn_login_ok() {
        startActivity(RechargeRecordActivity.class);
    }

    /*返回*/
    @OnClick(R.id.ic_reback) void news_btn() {
        Bundle b = new Bundle();
        b.putString("home", "3");
        startActivity(MainActivity.class,b);
    }
}
