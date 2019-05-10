package com.mining.mine;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.mining.MainActivity;
import com.mining.modle.adapter.MessageBean;
import com.mining.modle.adapter.RedEnvelopesAdapter;
import com.mining.modle.base.BaseActivity;
import com.mining.modle.waterdroplistview.view.WaterDropListView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.OnClick;

public class WorkOrderActivity extends BaseActivity implements WaterDropListView.IWaterDropListViewListener {

    @BindView(R.id.btn_a)
    Button btn_a;//标题
    @BindView(R.id.btn_b)
    Button btn_b;//标题

    private WaterDropListView waterDropListView;
    //自定义Adapter
    private RedEnvelopesAdapter listAdapter;
    //数据源实体,这里用数组作为示例，大家也可以选择使用List作为数据源
    private MessageBean[] msgArray;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
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
     * 配置布局文件
     */
    @Override
    public int bindLayout() {
        return R.layout.activity_work_order;
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
        btn_a.setText(getResources().getString(R.string.m3));
        btn_b.setText(getResources().getString(R.string.n3));
       // title_text.setText(getResources().getString(R.string.money));
        listAdapter = new RedEnvelopesAdapter(this, R.layout.item_work_order, initData());
        waterDropListView = (WaterDropListView) findViewById(R.id.waterdrop_listview);
        waterDropListView.setAdapter(listAdapter);
        waterDropListView.setWaterDropListViewListener(this);
        waterDropListView.setPullLoadEnable(true);
    }

    //装载数据
    private MessageBean[] initData() {
        msgArray = new MessageBean[1];
        msgArray[0] = new MessageBean("怎么提升挖矿算力", "处理中", "16:48 03/11", "已经用了你们平台矿机已经很久了，想了解一下怎么能快速提高挖矿算力，增加收益。");
       // msgArray[1] = new MessageBean("100", "满1000减100", "2019.2.21 00：", "00-2019.4.30 23：59");
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
