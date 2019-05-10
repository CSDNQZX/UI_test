package com.mining.Login;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.google.gson.Gson;
import com.mining.MainActivity;
import com.mining.modle.base.BaseActivity;
import com.mining.modle.entity.DataSet;
import com.mining.modle.model.BasicViewActivity;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by Zixin on 2019/3/19.
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.btn_login_ok) TextView login_btn;//登录
    @BindView(R.id.register_btn) TextView  register_btn;//注册
    @BindView(R.id.edt_mobile)   EditText edt_mobile;//电话
    @BindView(R.id.edt_pwd)   EditText edt_pwd;//密码
    @BindView(R.id.cancle_mobile)   ImageView cancle_mobile;//手机号清除按钮
    @BindView(R.id.cancle_pwd)   ImageView cancle_pwd;//手机号密码

    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_login;
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
    @OnClick(R.id.register_btn) void toRegisterNext() {
        startActivity(RegisterNextActivity.class);
    }
    /*忘记密码*/
    @OnClick(R.id.forget_pwd) void ForgetPwd() {
        startActivity(ForgetPwdActivity.class);
    }
    /*取消电话号码*/
    @OnClick(R.id.cancle_mobile) void cancle_mobile() {
        edt_mobile.setText("");
        cancle_mobile.setVisibility(View.GONE);
    }
    /*取消密码*/
    @OnClick(R.id.cancle_pwd) void cancle_pwd() {;
        edt_pwd.setText("");
        cancle_pwd.setVisibility(View.GONE);
    }
    /*登录*/
    @OnClick(R.id.btn_login_ok) void login_btn() {
        Bundle b = new Bundle();
        b.putString("home", "4");
        startActivity(MainActivity.class,b);
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
        edt_pwd.addTextChangedListener(new TextWatcher() {
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
                cancle_pwd.setVisibility(View.VISIBLE);
            }
        });
    }
}

