package com.mining.mine;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.administrator.mining.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mining.MainActivity;
import com.mining.modle.adapter.MessageBean;
import com.mining.modle.adapter.PurchasingPowerAdapter;
import com.mining.modle.model.BasicViewActivity;
import com.mining.modle.utils.HttpServices;
import com.mining.modle.utils.ServerURL;
import com.mining.modle.utils.StringUtils;
import com.mining.modle.waterdroplistview.view.WaterDropListView;
import com.mining.power.PurchasedDetailsActivity;
import com.mining.power.list.entity.ConfirmDataSet;
import com.mining.power.list.entity.Purchasingpower;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.OnClick;

/*购买记录*/
public class PurchaseHistoryActivity extends BasicViewActivity implements WaterDropListView.IWaterDropListViewListener{
  /*  @BindView(R.id.title_text)
    TextView title_text;//标题
    @BindView(R.id.add_btn)
    TextView add_btn;//标题*/

    private WaterDropListView waterDropListView;
    //自定义Adapter
    private PurchasingPowerAdapter listAdapter;
    //数据源实体,这里用数组作为示例，大家也可以选择使用List作为数据源
    private MessageBean[] msgArray;
    //网络请求获取的数据
    private List<Purchasingpower> list;


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

 /*返回*/
/* @OnClick(R.id.ic_reback) void news_btn() {
  this.finish();
 }*/
  /*  *//*挖矿收益*//*
    @OnClick(R.id.add_btn) void add_btn() {
        startActivity(MiningProfitActivity.class);
    }*/

    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_purchasing_power;
    }
    /***
     * 相关 代码业务的处理
     * @param activity
     */
    @Override
    public void doBusiness(Activity activity) {
        List<String> list = new ArrayList<String>();
        //list.add("mobile"+StringUtils.getParamValue(mobile));
        list.add("ctype"+ StringUtils.getParamValue("1638943"));
        new HttpServices().doPostHttps(PurchaseHistoryActivity.this,list, ServerURL.ALREADYBUYLIST);
        setSteepStatusBar(true);
        //initViews();
    }
    /*充值记录*/
/*    @OnClick(R.id.btn_a) void btn_a() {
        Bundle b = new Bundle();
        b.putString("home", "2");
        startActivity(MainActivity.class,b);
    }*/
    private void initViews() {
        listAdapter = new PurchasingPowerAdapter(this, R.layout.item_purchasing_power, initData(list));
        waterDropListView = findViewById(R.id.waterdrop_listview);
        waterDropListView.setAdapter(listAdapter);
        waterDropListView.setWaterDropListViewListener(this);
        waterDropListView.setPullLoadEnable(true);
        waterDropListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                        /*已购买算力*/
                        startActivity(PurchasedDetailsActivity.class);
                    } });

    }
    //装载数据
    private MessageBean[] initData(List<Purchasingpower> list) {
        if(list!=null&&list.size()>0){
            int num=list.size();
            int i=0;
            msgArray = new MessageBean[num];
            for(Purchasingpower p:list){
                msgArray[i] = new MessageBean(""+p.getCprice(),""+p.getState()+"",""+p.getCpower(),""+p.getReleaseTime(),""+p.getReferenceYields(),""+p.getEndReleaseTime()+"",""+p.getCpower(),""+p.getReferenceYields());
                i=i+1;
            }
        }
       /* msgArray[0] = new MessageBean("GRIN-29-180天","购买成功","10  graph (10份)","2019-04-05","23.99%","2019-07-05","4.25 GRIN","0.0236 GRIN");
        msgArray[1] = new MessageBean("GRIN-29-360天","已过期","10  graph (10份)","2019-04-05","23.99%","2019-07-05","4.25 GRIN","0.0236 GRIN");
        msgArray[2] = new MessageBean("GRIN-29-360天","购买成功","10  graph (10份)","2019-04-05","23.99%","2019-07-05","4.25 GRIN","0.0236 GRIN");
        msgArray[3] = new MessageBean("GRIN-29-180天","购买失败","10  graph (10份)","2019-04-05","23.99%","2019-07-05","4.25 GRIN","0.0236 GRIN");
        msgArray[4] = new MessageBean("GRIN-29-180天","购买成功","10  graph (10份)","2019-04-05","23.99%","2019-07-05","4.25 GRIN","0.0236 GRIN");
        msgArray[5] = new MessageBean("GRIN-29-180天","购买成功","10  graph (10份)","2019-04-05","23.99%","2019-07-05","4.25 GRIN","0.0236 GRIN");*/
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


    /**
     * 登录成功
     * */
    public void onSuccess(String result){
        ConfirmDataSet dataSet = new Gson().fromJson(result, new TypeToken<ConfirmDataSet>(){}.getType());
        if(dataSet!=null&dataSet.getState()==1){
            list=dataSet.getObject();
            //Purchasingpower p=list.get(0);
            //initData(dataSet.getObject());
            initViews();
        } if(dataSet!=null&dataSet.getState()==0){
            showToast(dataSet.getMessage());
        }
    }

    public void onErrors(String error){
        showToast(error);
    }
}
