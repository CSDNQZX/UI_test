package com.mining.power;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.administrator.mining.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mining.MainActivity;
import com.mining.mine.MiningProfitActivity;
import com.mining.modle.adapter.MessageBean;
import com.mining.modle.adapter.PurchasingPowerAdapter;
import com.mining.modle.base.BaseFragment;
import com.mining.modle.entity.DataSet;
import com.mining.modle.model.BasicViewActivity;
import com.mining.modle.utils.HttpServices;
import com.mining.modle.utils.ServerURL;
import com.mining.modle.utils.StringUtils;
import com.mining.modle.waterdroplistview.view.WaterDropListView;
import com.mining.power.list.entity.ConfirmDataSet;
import com.mining.power.list.entity.DataSet2;
import com.mining.power.list.entity.PurchaseAudit;
import com.mining.power.list.entity.Purchasingpower;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.OnClick;
import okhttp3.Call;

/**
 * Created by david on 2019/5/5.
 * 已购算力
 * 处于购买审核中的
 */
public class PurchasingPowerFragment extends BaseFragment implements WaterDropListView.IWaterDropListViewListener{
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
    private List<PurchaseAudit> list;


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

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_update;
    }

    @Override
    protected void setListener() {

    }

    /*初始化*/
    @Override
    protected void initViews(View view) {
        sendRequestWithHttpURLConnection();
    }


    private void sendRequestWithHttpURLConnection() {
        final  List<String> list = new ArrayList<String>();
        list.add("puser"+ StringUtils.getParamValue("zhangsna"));
        //开启线程来发起网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpUtils.post().addParams("gson",StringUtils.getParams(list)).url(ServerURL.GETAUDITDATE).build().execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("mainactivity", e.getMessage());
                        //setError("连接失败,请检查网络");
                    }
                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("response", response);
                        showResponse(response);
                    }
                });
            }
        }).start();
    }
    private void initViews() {
        listAdapter = new PurchasingPowerAdapter(getActivity(), R.layout.item_purchase_audit, initData(list));
        waterDropListView = getActivity().findViewById(R.id.waterdrop_listview);
        waterDropListView.setAdapter(listAdapter);
        waterDropListView.setWaterDropListViewListener(this);
        waterDropListView.setPullLoadEnable(true);
        waterDropListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                       /* PurchaseAudit p=list.get(position);
                        Bundle b = new Bundle();
                        b.putSerializable("bundle_" , p);
                        startActivity(PurchasedDetailsActivity.class,b);*/
                    } });

    }
    //装载数据
    private MessageBean[] initData(List<PurchaseAudit> list) {
        if(list!=null&&list.size()>0){
            int num=list.size();
            int i=0;
            msgArray = new MessageBean[num];
            for(PurchaseAudit p:list){
                msgArray[i] = new MessageBean(""+StringUtils.getCurrencyName(p.getCurrency()),""+StringUtils.getStatu(p.getRemark())+"",
                        ""+p.getPower()+StringUtils.getDanwei(p.getCurrency()),""+StringUtils.getPayType(p.getPaytype()),
                        ""+p.getPaynumber(),""+p.getPayMoney()+"",
                        ""+StringUtils.ispay(p.getState()),""+StringUtils.getTime(p.getCreateTime()));
                i=i+1;
            }
        }
            return msgArray;
    }
    @Override
    public void onRefresh() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                list=null;
                sendRequestWithHttpURLConnection();
                handler.sendEmptyMessage(1);
            }
        });

    }

    @Override
    public void onLoadMore() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                list=null;
                sendRequestWithHttpURLConnection();
                handler.sendEmptyMessage(2);
            }
        });
    }
    //获取数据成功
    public void showResponse(String result){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        DataSet dataSet =gson.fromJson(result, new TypeToken<DataSet>(){}.getType());
        if(dataSet!=null&dataSet.getState()==1){
            list=dataSet.getBlist();
            if(list!=null){
                initViews();
            }
        } if(dataSet!=null&dataSet.getState()==0){
            showToast(dataSet.getMessage());
        }
    }

}
