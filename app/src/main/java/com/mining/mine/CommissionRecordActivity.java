package com.mining.mine;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import com.example.administrator.mining.R;
import com.mining.modle.Dialog.CustomPopWindow;
import com.mining.modle.adapter.CommissionRecordAdapter;
import com.mining.modle.adapter.MessageBean;
import com.mining.modle.base.BaseActivity;
import com.mining.modle.waterdroplistview.view.WaterDropListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.OnClick;

/*
* 佣金记录
* */
public class CommissionRecordActivity extends BaseActivity implements WaterDropListView.IWaterDropListViewListener  {
    //选币
    @BindView(R.id.layout_id)
    LinearLayout layout_id;

    private WaterDropListView waterDropListView;
    //自定义Adapter
    private CommissionRecordAdapter listAdapter;
    //数据源实体,这里用数组作为示例，大家也可以选择使用List作为数据源
    private MessageBean[] msgArray;

    private CustomPopWindow mPopWindow;
    //定义以及初始化数据
    private GridView gridView;
    private List<Map<String,Object>> dataList;
    private int[] icon={R.mipmap.u26,R.mipmap.u50,R.mipmap.u79,R.mipmap.u80};
    private String[] iconName={"GRIN","BTC","ETH","BEAM"};
    private SimpleAdapter adapter;


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
        return R.layout.activity_commission_record;
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


    /*获取其他币种弹窗*/
    @OnClick(R.id.layout_id) void layout_id() {
        //调用弹窗方法
        touchOutsideDontDisMiss();
    }

    /*初始化*/
    public void initView() {
        listAdapter = new CommissionRecordAdapter(this, R.layout.item_commission_record, initData());
        waterDropListView = (WaterDropListView) findViewById(R.id.waterdrop_listview);
        waterDropListView.setAdapter(listAdapter);
        waterDropListView.setWaterDropListViewListener(this);
        waterDropListView.setPullLoadEnable(true);
    }

    //装载数据
    private MessageBean[] initData() {
        msgArray = new MessageBean[4];
        msgArray[0] = new MessageBean("62poa","Jubg","0.00725445","16:48 03/11");
        msgArray[1] = new MessageBean("62poa","Jubg","0.00725445","16:48 03/11");
        msgArray[2] = new MessageBean("62poa","Jubg","0.00725445","16:48 03/11");
        msgArray[3] = new MessageBean("62poa","Jubg","0.00725445","16:48 03/11");
        return msgArray;
    }

    /**
     * 点击 PopupWindow
     */
    private void touchOutsideDontDisMiss(){

        View view = LayoutInflater.from(this).inflate(R.layout.dialog_commission_record,null);
        //实例化gridView
        gridView=(GridView)view.findViewById(R.id.gridView);
        dataList=new ArrayList<>();
        adapter=new SimpleAdapter(this,getData(),R.layout.item_dialog_commission_record,new String[]{"image","text"},
                new int[]{R.id.image,R.id.text});
        gridView.setAdapter(adapter);
       // gridView.setOnItemClickListener(this);

       // View.OnClickListener listener = new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
       //         Log.e("FK","onClick.....");
       //         mPopWindow.dissmiss();
       //     }
       // };
        //view.findViewById(R.id.close_pop).setOnClickListener(listener);
        mPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(view)
                .enableOutsideTouchableDissmiss(true)// 设置点击PopupWindow之外的地方，popWindow不关闭，如果不设置这个属性或者为true，则关闭
                .create();

        mPopWindow.showAsDropDown(layout_id,0,10);
    }

    //装载数据
    private List<Map<String,Object>> getData(){
        for(int i=0;i<icon.length;i++){
            Map<String,Object>map=new HashMap<>();
            map.put("image",icon[i]);
            map.put("text",iconName[i]);
            dataList.add(map);
        }
        return dataList;
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
