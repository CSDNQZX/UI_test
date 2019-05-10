package com.mining.power;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.google.gson.Gson;
import com.mining.MainActivity;
import com.mining.modle.Dialog.Custompopups;
import com.mining.modle.base.BaseActivity;
import com.mining.modle.utils.SystemConfig;
import com.mining.modle.entity.DataSet;
import com.mining.modle.model.BasicViewActivity;
import com.mining.modle.utils.HttpServices;
import com.mining.modle.utils.ServerURL;
import com.mining.modle.utils.StringUtils;
import com.mining.power.list.entity.DataSet2;
import com.mining.power.list.entity.OrderCodeFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ConfirmPurchaseActivity  extends BaseActivity {
    @BindView(R.id.a_text)
    TextView a_text;//挖矿币种
    @BindView(R.id.b_text)
    TextView b_text;//购买天数
    @BindView(R.id.c_text)
    TextView c_text;//购买份数
    @BindView(R.id.d_text)
    TextView d_text;//购买算力
    @BindView(R.id.e_text)
    TextView e_text;//挖币时间
    @BindView(R.id.f_text)
    TextView f_text;//到期时间
    @BindView(R.id.g_text)
    TextView g_text;//电费
    @BindView(R.id.h_text)
    TextView h_text;//机位费
    @BindView(R.id.i_text)
    TextView i_text;//上架费
    @BindView(R.id.j_text)
    TextView j_text;//维修费
    @BindView(R.id.k_text)
    TextView k_text;//算力价格
    @BindView(R.id.l_text)
    TextView l_text;//共需支付

    //前一个页面传过来的对象
    private DataSet2.ObjectBean.TagInfoListBean  ca;

    //当前页面总金额
    private String Numprice;
    //购买份数
    private String editvalue;


    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_confirm_purchase;
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
        initdata();
    }

    private void initdata() {

    }

    /*点击取消按钮*/
    @OnClick(R.id.btn_login_cancle) void btn_login_cancle() {
        this.finish();
    }
    /*点击提交订单按钮*/
    @OnClick(R.id.btn_login_ok)
    void btn_login_ok() {
        startActivity(PayActivity.class);
    }


}
