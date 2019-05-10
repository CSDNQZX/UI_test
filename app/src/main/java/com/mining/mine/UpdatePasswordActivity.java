package com.mining.mine;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.mining.modle.adapter.SecuritySettingAdapter;
import com.mining.modle.base.BaseActivity;
import com.mining.modle.waterdroplistview.view.WaterDropListView;

import butterknife.BindView;
import butterknife.OnClick;


public class UpdatePasswordActivity extends BaseActivity {
    @BindView(R.id.title_text)
    TextView title_text;//标题
    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_update_password;
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
        title_text.setText(getResources().getString(R.string.updatepwd));
    }

    /*返回*/
    @OnClick(R.id.ic_reback) void news_btn() {
        this.finish();
    }
}
