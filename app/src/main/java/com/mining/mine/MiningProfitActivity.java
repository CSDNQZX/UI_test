package com.mining.mine;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.mining.MainActivity;
import com.mining.modle.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/*挖矿收益*/
public class MiningProfitActivity extends BaseActivity {
    @BindView(R.id.title_text)
    TextView title_text;//标题

    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_mining_profit;
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
        title_text.setText(getResources().getString(R.string.s7));
    }
    /*返回*/
    @OnClick(R.id.ic_reback) void news_btn() {
        this.finish();
        Bundle b = new Bundle();
        b.putString("home", "2");
        startActivity(MainActivity.class,b);
    }
}
