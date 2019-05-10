package com.mining.mine;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.mining.modle.adapter.CommissionRecordAdapter;
import com.mining.modle.adapter.ListAdapter;
import com.mining.modle.adapter.MessageBean;
import com.mining.modle.base.BaseActivity;
import com.mining.modle.waterdroplistview.view.WaterDropListView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.OnClick;

public class RecordWithdrawActivity extends BaseActivity implements WaterDropListView.IWaterDropListViewListener  {
    @BindView(R.id.title_text)
    TextView title_text;//标题
    private WaterDropListView waterDropListView;
    //自定义Adapter
    private ListAdapter listAdapter;
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
    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_record_withdraw;
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
    /*返回*/
    @OnClick(R.id.ic_reback) void news_btn() {
        this.finish();
    }

    /*初始化*/
    public void initView() {
        title_text.setText(getResources().getString(R.string.c3));
        listAdapter = new ListAdapter(this, R.layout.item_record_withdraw, initData());
        waterDropListView = (WaterDropListView) findViewById(R.id.waterdrop_listview);
        waterDropListView.setAdapter(listAdapter);
        waterDropListView.setWaterDropListViewListener(this);
        waterDropListView.setPullLoadEnable(true);
    }

    //装载数据
    private MessageBean[] initData() {
        msgArray = new MessageBean[6];
        msgArray[0] = new MessageBean("1563.32","审核中","16:48 03/11");
        msgArray[1] = new MessageBean("1563.32","已完成","16:48 03/11");
        msgArray[2] = new MessageBean("1563.32","已完成","16:48 03/11");
        msgArray[3] = new MessageBean("1563.32","审核失败","16:48 03/11");
        msgArray[4] = new MessageBean("1563.32","已完成","16:48 03/11");
        msgArray[5] = new MessageBean("1563.32","已完成","16:48 03/11");
        msgArray[5] = new MessageBean("1563.32","已完成","16:48 03/11");
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
