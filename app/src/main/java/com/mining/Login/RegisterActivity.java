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
import android.widget.Toast;

import com.example.administrator.mining.R;
import com.google.gson.Gson;
import com.mining.modle.base.BaseActivity;
import com.mining.modle.entity.DataSet;
import com.mining.modle.model.BasicViewActivity;
import com.mining.modle.utils.ServerURL;
import com.mining.modle.utils.HttpServices;
import com.mining.modle.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.title_text)
    TextView title_text;//标题
    @BindView(R.id.set_pwd)
    EditText set_pwd;//设置密码
    @BindView(R.id.cancle_setpwd)
    ImageView cancle_setpwd;//取消设置密码
    @BindView(R.id.edit_pwd_again)
    EditText edit_pwd_again;//请再次输入密码
    @BindView(R.id.edit_pwd_cancle)
    ImageView edit_pwd_cancle;//取消再次输入密码
    @BindView(R.id.btn_login_ok)
    Button btn_login_ok;//取消再次输入密码

    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_register;
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
    /*取消设置密码*/
    @OnClick(R.id.cancle_setpwd) void cancle_mobile() {
        set_pwd.setText("");
        cancle_setpwd.setVisibility(View.GONE);
    }
    /*取消再次输入密码*/
    @OnClick(R.id.edit_pwd_cancle) void edit_pwd_cancle() {
        edit_pwd_again.setText("");
        edit_pwd_cancle.setVisibility(View.GONE);
    }
    /*返回登陆*/
    @OnClick(R.id.login_btn) void login_btn() {
        //this.finish();
        startActivity(LoginActivity.class);
    }
    /*返回*/
    @OnClick(R.id.ic_reback) void news_btn() {
        this.finish();
    }
    /*点击注册*/
    @OnClick(R.id.btn_login_ok) void btn_login_ok() {
        startActivity(LoginActivity.class);
    }

    /*初始化*/
    public void initView() {
        title_text.setText("用户注册");
        set_pwd.addTextChangedListener(new TextWatcher() {
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
                cancle_setpwd.setVisibility(View.VISIBLE);
            }
        });
        edit_pwd_again.addTextChangedListener(new TextWatcher() {
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
                edit_pwd_cancle.setVisibility(View.VISIBLE);
            }
        });
    }
}
