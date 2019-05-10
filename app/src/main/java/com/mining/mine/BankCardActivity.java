package com.mining.mine;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.mining.MainActivity;
import com.mining.modle.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class BankCardActivity extends BaseActivity {


    @BindView(R.id.title_text)
    TextView title_text;//标题
    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_bank_card;
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
        title_text.setText(getResources().getString(R.string.l));
    }

    /*返回*/
    @OnClick(R.id.ic_reback) void news_btn() {
        this.finish();
    }


    /*选择银行卡*/
    @OnClick(R.id.choose_id) void choose_id() {
        startActivity(ChoiceBankActivity.class);
    }
}
