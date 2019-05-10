package com.mining.power;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.google.gson.Gson;
import com.mining.MainActivity;
import com.mining.modle.base.BaseActivity;
import com.mining.modle.utils.SystemConfig;
import com.mining.modle.entity.DataSet;
import com.mining.modle.model.BasicViewActivity;
import com.mining.modle.utils.HttpServices;
import com.mining.modle.utils.ServerURL;
import com.mining.modle.utils.StringUtils;
import com.mining.power.list.entity.DataSet2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PayActivity extends BaseActivity {
    @BindView(R.id.title_text)
    TextView title_text;//标题

    @BindView(R.id.time_colse_text)
    TextView time_colse_text;//定时器


   /* @BindView(R.id.add_btn)
    TextView add_btn;//标题*/

    @BindView(R.id.a_text)
    TextView a_text;//微信
    @BindView(R.id.b_text)
    TextView b_text;//支付宝
    @BindView(R.id.c_text)
    TextView c_text;//银联
   // @BindView(R.id.d_text)
   // TextView d_text;//比特币

    @BindView(R.id.linearLayout_weixin_id)
    LinearLayout linearLayout_weixin_id;//微信
    @BindView(R.id.linearLayout_alipay_id)
    LinearLayout linearLayout_alipay_id;//支付宝
    @BindView(R.id.linearLayout_bank_id)
    LinearLayout linearLayout_bank_id;//银行卡

    @BindView(R.id.img_choose_weixin)
    ImageView img_choose_weixin;//微信
    @BindView(R.id.img_choose_alipay)
    ImageView img_choose_alipay;//支付宝
    @BindView(R.id.img_choose_bank)
    ImageView img_choose_bank;//银行卡

    private int payType=0;//1(微信) 2(支付宝) 3(银行卡)

    private String numprice="";
    //前一个页面传过来的对象
    private DataSet2.ObjectBean.TagInfoListBean  ca;

    //private int recLen = 900;
    //private TextView txtView;

    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_pay;
    }
    /***
     *
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
        payType = 1;//默认是微信支付
    }


        /*返回*/
        @OnClick(R.id.ic_reback)
        void news_btn() {
            this.finish();
        }

        /*微信*/
        @OnClick(R.id.linearLayout_weixin_id)
        void weixin_btn() {
            img_choose_weixin.setVisibility(View.VISIBLE);
            img_choose_alipay.setVisibility(View.INVISIBLE);
            img_choose_bank.setVisibility(View.INVISIBLE);
            payType = 1;
        }

        /*支付宝*/
        @OnClick(R.id.linearLayout_alipay_id)
        void alipay_btn() {
            img_choose_weixin.setVisibility(View.INVISIBLE);
            img_choose_alipay.setVisibility(View.VISIBLE);
            img_choose_bank.setVisibility(View.INVISIBLE);
            payType = 2;
        }

        /*银行卡*/
        @OnClick(R.id.linearLayout_bank_id)
        void bank_btn() {
            img_choose_weixin.setVisibility(View.INVISIBLE);
            img_choose_alipay.setVisibility(View.INVISIBLE);
            img_choose_bank.setVisibility(View.VISIBLE);
            payType = 3;
        }
        /*立即支付*/
        @OnClick(R.id.btn_login_ok)
        void btn_login_ok() {
            startActivity(PaymentActivity.class);
        }

}
