package com.mining.wallet;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.mining.MainActivity;
import com.mining.modle.adapter.ListAdapter;
import com.mining.modle.adapter.MessageBean;
import com.mining.modle.base.BaseActivity;
import com.mining.modle.waterdroplistview.view.WaterDropListView;

import butterknife.BindView;
import butterknife.OnClick;

/*钱包提现*/
public class WalletWithdrawalsActivity extends BaseActivity {
    @BindView(R.id.title_text)
    TextView title_text;//标题
    @BindView(R.id.add_btn)
    TextView add_btn;//提现记录
    @BindView(R.id.imgae_type_id)
    ImageView imgae_type_id;//logo
    @BindView(R.id.imgae_text_id)
    TextView imgae_text_id;//币种
    @BindView(R.id.has_number_id)
    TextView has_number_id;//可提现数量
    //选币
    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_wallet_withdrawals;
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
        title_text.setText(getResources().getString(R.string.g2));
        add_btn.setText(getResources().getString(R.string.b3));
        Bundle b = getIntent().getExtras();
        if(b!=null){
            String home = b.getString("position");
            if(home.equals("1")){
                imgae_type_id.setImageResource(R.mipmap.u26);
                imgae_text_id.setText("GRIN");
                has_number_id.setText("11.8362");
            }if(home.equals("2")){
                imgae_type_id.setImageResource(R.mipmap.u79);
                imgae_text_id.setText("BEAM");
                has_number_id.setText("667.3481");
            }if(home.equals("3")){
                imgae_type_id.setImageResource(R.mipmap.u50);
                imgae_text_id.setText("BTC");
                has_number_id.setText("3.3456");
            }if(home.equals("4")){
                imgae_type_id.setImageResource(R.mipmap.u54);
                imgae_text_id.setText("ETH");
                has_number_id.setText("9.123");
            }if(home.equals("5")){
                imgae_type_id.setImageResource(R.mipmap.u80);
                imgae_text_id.setText("AE");
                has_number_id.setText("1212.2567");
            }
        }


    }
    /*返回*/
    @OnClick(R.id.ic_reback) void news_btn() {
        Bundle b = new Bundle();
        b.putString("home", "3");
        startActivity(MainActivity.class,b);
    }
    /*提现记录*/
    @OnClick(R.id.add_btn) void add_btn() {
        startActivity(WithdrawalsRecordActivity.class);
    }
}
