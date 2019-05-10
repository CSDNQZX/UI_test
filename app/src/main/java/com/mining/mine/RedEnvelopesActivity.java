package com.mining.mine;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.mining.MainActivity;
import com.mining.modle.adapter.ListAdapter;
import com.mining.modle.adapter.MessageBean;
import com.mining.modle.adapter.RedEnvelopesAdapter;
import com.mining.modle.base.BaseActivity;
import com.mining.modle.waterdroplistview.view.WaterDropListView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.OnClick;

public class RedEnvelopesActivity extends BaseActivity implements WaterDropListView.IWaterDropListViewListener {

    @BindView(R.id.title_text)
    TextView title_text;//标题

    private WaterDropListView waterDropListView;
    //自定义Adapter
    private RedEnvelopesAdapter listAdapter;
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
        return R.layout.activity_red_envelopes;
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
        title_text.setText(getResources().getString(R.string.money));
        listAdapter = new RedEnvelopesAdapter(this, R.layout.item_red_envelopes, initData());
        waterDropListView = (WaterDropListView) findViewById(R.id.waterdrop_listview);
        waterDropListView.setAdapter(listAdapter);
        waterDropListView.setWaterDropListViewListener(this);
        waterDropListView.setPullLoadEnable(true);
        waterDropListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                        RedEnvelopesActivity.this.finish();
                        Bundle b = new Bundle();
                        b.putString("home", "2");
                        startActivity(MainActivity.class,b);
                    } });
    }

    /*返回*/
    @OnClick(R.id.ic_reback) void news_btn() {
        this.finish();
        startActivity(MainActivity.class);
    }


    //装载数据
    private MessageBean[] initData() {
        msgArray = new MessageBean[2];
        msgArray[0] = new MessageBean("10","满100减10","2019.2.21 00：","00-2019.4.30 23：59");
        msgArray[1] = new MessageBean("100","满1000减100","2019.2.21 00：","00-2019.4.30 23：59");
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
