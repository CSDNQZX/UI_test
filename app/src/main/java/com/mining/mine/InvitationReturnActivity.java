package com.mining.mine;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.mining.MainActivity;
import com.mining.modle.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class InvitationReturnActivity extends BaseActivity {

   // @BindView(R.id.title_text)
   // TextView title_text;//标题
    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_invitation_return;
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
        //title_text.setText(getResources().getString(R.string.updatepwd));
    }

    /*返回*/
    @OnClick(R.id.ic_reback) void news_btn() {
        this.finish();
        startActivity(MainActivity.class);
    }

    /*划转*/
    @OnClick(R.id.hz_id_a) void hz_id_a() {
        startActivity(TransferActivity.class);
    }
    @OnClick(R.id.hz_id_b) void hz_id_b() {
        startActivity(TransferActivity.class);
    }
    @OnClick(R.id.hz_id_c) void hz_id_c() {
        startActivity(TransferActivity.class);
    }
    @OnClick(R.id.hz_id_d) void hz_id_d() {
        startActivity(TransferActivity.class);
    }

    /*提现*/
    @OnClick(R.id.tx_id) void tx_id() {
        startActivity(CashWithdrawalActivity.class);
    }

    /*详情*/
    @OnClick(R.id.xq_id_a) void xq_id_a() {
        startActivity(CommissionRecordActivity.class);
    }
    @OnClick(R.id.xq_id_b) void xq_id_b() {
        startActivity(CommissionRecordActivity.class);
    }

    /*邀请返佣*/
    @OnClick(R.id.poster_id) void poster_id() {
        startActivity(PosterImageActivity.class);
    }
}
