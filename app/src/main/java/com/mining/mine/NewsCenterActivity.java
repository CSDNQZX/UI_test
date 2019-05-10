package com.mining.mine;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.administrator.mining.R;
import com.mining.MainActivity;
import com.mining.modle.adapter.ListAdapter;
import com.mining.modle.adapter.MessageBean;
import com.mining.modle.base.BaseActivity;
import com.mining.modle.waterdroplistview.view.WaterDropListView;

import butterknife.BindView;
import butterknife.OnClick;

public class NewsCenterActivity extends BaseActivity implements WaterDropListView.IWaterDropListViewListener  {
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
        return R.layout.activity_news_center;
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
        startActivity(MainActivity.class);
    }

    /*初始化*/
    public void initView() {
        title_text.setText(getResources().getString(R.string.u3));
        listAdapter = new ListAdapter(this, R.layout.item_messgae, initData());
        waterDropListView = (WaterDropListView) findViewById(R.id.waterdrop_listview);
        waterDropListView.setAdapter(listAdapter);
        waterDropListView.setWaterDropListViewListener(this);
        waterDropListView.setPullLoadEnable(true);
        waterDropListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                        startActivity(NewsDetailsActivity.class);
                    } });
    }

   //装载数据
    private MessageBean[] initData() {
        msgArray = new MessageBean[2];
        msgArray[0] = new MessageBean("关于钱包升级","2019-03-05 15:39:20","为了保证用户的绝对资金安全和提高警惕转账速度以提供更优质的服务，将3-15开始进行升级");
        msgArray[1] = new MessageBean("关于钱包升级","2019-03-05 15:39:20","为了保证用户的绝对资金安全和提高警惕转账速度以提供更优质的服务，将3-15开始进行升级");
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
