package com.mining.Login;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mining.R;
import com.mining.modle.base.BaseActivity;
import com.mining.modle.utils.MessageServices;
import com.mining.modle.utils.OKHttpUitls;
import com.mining.modle.utils.StringUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterNextActivity extends BaseActivity {
    @BindView(R.id.btn_login_ok)
    TextView login_btn;//登录
    @BindView(R.id.register_btn)
    TextView  register_btn;//注册
    @BindView(R.id.edt_mobile)
    EditText edt_mobile;//电话
    @BindView(R.id.invitation_code)
    EditText invitation_code;//邀请码
    @BindView(R.id.cancle_mobile)
    ImageView cancle_mobile;//手机号清除按钮
    @BindView(R.id.massage_code)
    EditText massage_code;//输入短信验证码
    @BindView(R.id.cancle_code)
    ImageView cancle_code;//邀请码清除按钮
    @BindView(R.id.btn_register_next)
    Button btn_register_next;//下一步按钮
    @BindView(R.id.send_massage_btn)
    TextView send_massage_btn;//发送验证码


    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_next_register;
    }
    /*注册页面*/
    @OnClick(R.id.btn_login_ok) void toLoginActivity() {
        startActivity(LoginActivity.class);
    }
    /*返回*/
    @OnClick(R.id.ic_reback) void news_btn() {
        this.finish();
        //startActivity(LoginActivity.class);
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

    /*注册页面*/
    @OnClick(R.id.register_btn) void toRegister() {
        startActivity(RegisterActivity.class);
    }
    /*取消电话号码*/
    @OnClick(R.id.cancle_mobile) void cancle_mobile() {
        edt_mobile.setText("");
        cancle_mobile.setVisibility(View.GONE);
    }
    /*取消密码*/
    @OnClick(R.id.cancle_code) void cancle_code() {;
        invitation_code.setText("");
        cancle_code.setVisibility(View.GONE);
    }
    /*点击下一步*/
    @OnClick(R.id.btn_register_next) void btn_register_next() {
        startActivity(RegisterActivity.class);
    }
    /*发送验证码*/
    @OnClick(R.id.send_massage_btn) void send_massage_btn() {

    }

    /*初始化*/
    public void initView() {
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
        invitation_code.addTextChangedListener(new TextWatcher() {
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
                cancle_code.setVisibility(View.VISIBLE);
            }
        });
    }
}
