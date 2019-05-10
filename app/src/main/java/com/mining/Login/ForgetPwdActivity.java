package com.mining.Login;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.mining.modle.base.BaseActivity;
import com.mining.modle.utils.StringUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class ForgetPwdActivity extends BaseActivity {
    @BindView(R.id.title_text)
    TextView title_text;//标题
    @BindView(R.id.edt_mobile)
    EditText edt_mobile;//电话
    @BindView(R.id.cancle_mobile)
    ImageView cancle_mobile;//手机号清除按钮
    @BindView(R.id.btn_next)
    Button btn_next;//下一步按钮



    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_forget_pwd;
    }
    /***
     * 相关 代码业务的处理
     * @param
     */

      /*点击下一步*/
    @OnClick(R.id.btn_next) void btn_next() {;
        startActivity(SendVerificationActivity.class);
    }

     /*取消电话号码*/
    @OnClick(R.id.cancle_mobile) void cancle_mobile() {
        edt_mobile.setText("");
        cancle_mobile.setVisibility(View.GONE);
    }
    /*返回*/
    @OnClick(R.id.ic_reback) void news_btn() {
        this.finish();
        //startActivity(LoginActivity.class);
    }

    @Override
    public void doBusiness(Activity activity) {
        setSteepStatusBar(true);
        initView();
    }
    /*初始化*/
    public void initView() {
        title_text.setText(getResources().getString(R.string.forget_password));
        edt_mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //text  输入框中改变前的字符串信息
                //start 输入框中改变前的字符串的起始位置
                //count 输入框中改变前后的字符串改变数量一般为0
                //after 输入框中改变后的字符串与起始位置的偏移量
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                //text  输入框中改变后的字符串信息
                //start 输入框中改变后的字符串的起始位置
                //before 输入框中改变前的字符串的位置 默认为0
                //count 输入框中改变后的一共输入字符串的数量
            }
            @Override
            public void afterTextChanged(Editable s) {
                //edit  输入结束呈现在输入框中的信息
                //所以我要实现的功能放到此处执行即可。
                cancle_mobile.setVisibility(View.VISIBLE);
            }
        });
    }
}
