package com.mining.mine;

import android.view.View;
import android.widget.LinearLayout;
import com.example.administrator.mining.R;
import com.mining.Login.LoginActivity;
import com.mining.modle.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonPageFragment extends BaseFragment{
    @BindView(R.id.news_btn)
    LinearLayout news_btn;//消息按钮

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_main_home_page;
    }

    @Override
    protected void setListener() {


    }
    @Override
    protected void initViews(View view) {

    }


    /*消息页面*/

    @OnClick(R.id.news_btn) void news_btn() {
        startActivity(NewsCenterActivity.class);
    }

    /*安全设置*/
    @OnClick(R.id.save_set) void save_set() {
        startActivity(SecuritySettingActivity.class);
    }

    /*个人主页*/
    @OnClick(R.id.phone_number) void phone_number() {
        startActivity(PersonCenterActivity.class);
    }

    /*收款方式*/
    @OnClick(R.id.payment_method) void payment_method() {
        startActivity(PaymentMethodActivity.class);
    }
    /*红包**/
    @OnClick(R.id.red_id) void red_id() {
        startActivity(RedEnvelopesActivity.class);
    }
    /*邀请返佣**/
    @OnClick(R.id.inva_money) void inva_money() {
        startActivity(InvitationReturnActivity.class);
    }
    /*提交工单**/
    @OnClick(R.id.tj_gd_id) void tj_gd_id() {
        startActivity(SubmitWorkActivity.class);
    }
    /*已购算力*/
    @OnClick(R.id.yg_sl_id) void yg_sl_id() {
        startActivity(PurchaseHistoryActivity.class);
    }
    /*挖矿收益*/
    @OnClick(R.id.wk_sy_id) void wk_sy_id() {
        startActivity(MiningProfitActivity.class);
    }
    /*关于我们**/
    @OnClick(R.id.about_us_id) void about_us_id() {
        startActivity(AboutUsActivity.class);
    }
    /*退出登录**/
    @OnClick(R.id.btn_login_ok) void btn_login_ok() {
        startActivity(LoginActivity.class);
    }






}
