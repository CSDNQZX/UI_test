package com.mining.mine;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.mining.MainActivity;
import com.mining.modle.adapter.ListAdapter;
import com.mining.modle.adapter.MessageBean;
import com.mining.modle.adapter.SecuritySettingAdapter;
import com.mining.modle.base.BaseActivity;
import com.mining.modle.waterdroplistview.view.WaterDropListView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.OnClick;

public class SecuritySettingActivity extends BaseActivity implements WaterDropListView.IWaterDropListViewListener  {
    @BindView(R.id.title_text)
    TextView title_text;//标题
    private WaterDropListView waterDropListView;
    //自定义Adapter
    private SecuritySettingAdapter listAdapter;
    //数据源实体,这里用数组作为示例，大家也可以选择使用List作为数据源
    private MessageBean[] msgArray;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    waterDropListView.stopRefresh();
                    break;
                case 2:
                    waterDropListView.stopLoadMore();
                    break;
            }
        }
    };
    /*安全设置*/
    @OnClick(R.id.upadte_pwd) void upadte_pwd() {
        startActivity(UpdatePasswordActivity.class);
    }
    /*实名认证*/
    @OnClick(R.id.real_name) void real_name() {
        startActivity(CertificationActivity.class);
    }
    /*返回*/
    @OnClick(R.id.ic_reback) void news_btn() {
        this.finish();
        startActivity(MainActivity.class);
    }


    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_security_setting;
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
        title_text.setText(getResources().getString(R.string.save_set));
        listAdapter = new SecuritySettingAdapter(this, R.layout.item_loginhistory, initData());
        waterDropListView = (WaterDropListView) findViewById(R.id.waterdrop_listview);
        waterDropListView.setAdapter(listAdapter);
        waterDropListView.setWaterDropListViewListener(this);
        waterDropListView.setPullLoadEnable(true);
    }

    //装载数据
    private MessageBean[] initData() {
        msgArray = new MessageBean[2];
        msgArray[0] = new MessageBean("2019-03-05 15:39:20","119.123.40.111","ShenZheng China","iphone8");
        msgArray[1] = new MessageBean("2019-03-05 15:39:20","119.123.40.111","ShenZheng China","iphone8");
        return msgArray;
    }
    @Override
    public void onRefresh() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    handler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void onLoadMore() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    handler.sendEmptyMessage(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
