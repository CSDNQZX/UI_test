package com.mining.power;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.mining.modle.base.BaseActivity;

import butterknife.BindView;

public class BankCardPaymentActivity extends BaseActivity {
    @BindView(R.id.title_text)
    TextView title_text;//标题
    @BindView(R.id.ic_reback)
    ImageView ic_reback;//标题
  /*  @BindView(R.id.add_btn)
    TextView add_btn;//标题*/

    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_bank_card_payment;
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
       // ic_reback.setVisibility(View.GONE);
        title_text.setText(getResources().getString(R.string.x6));
       /* add_btn.setVisibility(View.GONE);*/
    }
}
