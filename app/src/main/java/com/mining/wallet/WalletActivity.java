package com.mining.wallet;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mining.R;
import com.mining.MainActivity;
import com.mining.mine.AlipayActivity;
import com.mining.mine.BankCardActivity;
import com.mining.mine.CashWithdrawalActivity;
import com.mining.mine.NewsDetailsActivity;
import com.mining.mine.PaymentMethodActivity;
import com.mining.mine.WeixinActivity;
import com.mining.modle.adapter.ListAdapter;
import com.mining.modle.adapter.MessageBean;
import com.mining.modle.adapter.WalletAdapter;
import com.mining.modle.base.BaseActivity;
import com.mining.modle.base.BaseFragment;
import com.mining.modle.waterdroplistview.view.WaterDropListView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;

public class WalletActivity extends BaseFragment implements WaterDropListView.IWaterDropListViewListener {
    @BindView(R.id.title_text)
    TextView title_text;//标题
    @BindView(R.id.ic_reback)
    ImageView ic_reback;//标题



    private PopupWindow window;

    private WaterDropListView waterDropListView;
    //自定义Adapter
    private WalletAdapter listAdapter;
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
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_wallet;
    }

    @Override
    protected void setListener() {


    }
    @Override
    protected void initViews(View view) {
        ic_reback.setVisibility(View.GONE);
        title_text.setText(getResources().getString(R.string.d5));
        listAdapter = new WalletAdapter(getActivity(), R.layout.item_wallet, initData());
        waterDropListView = (WaterDropListView) view.findViewById(R.id.waterdrop_listview);
        waterDropListView.setAdapter(listAdapter);
        waterDropListView.setWaterDropListViewListener(this);
        waterDropListView.setPullLoadEnable(true);
        waterDropListView.setOnItemClickListener(
            new AdapterView.OnItemClickListener(){
                public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                   // startActivity(NewsDetailsActivity.class);
                    //Log.e("---------1--------",""+position);
                    showPopwindow(position);
                } });
    }
    /**
     * 显示popupWindow
     */
    private void showPopwindow(final int position) {
        // 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_popwindow_layout_d, null);
        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()

         window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        window.setBackgroundDrawable(dw);


        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypopwindow_anim_style);
        // 在底部显示
        window.showAtLocation(getActivity().findViewById(R.id.add_btn),
                Gravity.BOTTOM, 0, 0);

        // 这里检验popWindow里的button是否可以点击
        Button first = (Button) view.findViewById(R.id.first);
        first.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(RechargeActivity.class);
            }
        });
        Button second = (Button) view.findViewById(R.id.second_wallet_id);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("position",String.valueOf(position));
                startActivity(WalletWithdrawalsActivity.class,b);
            }
        });
        Button third = (Button) view.findViewById(R.id.third);
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });
        //popWindow消失监听方法
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                System.out.println("popWindow消失");
            }
        });

    }


    //装载数据
    private MessageBean[] initData() {
        msgArray = new MessageBean[5];
        msgArray[0] = new MessageBean(R.mipmap.u26,"GRIN","$ 3.3964","+ 2.27%","11.8362","0.000000");
        msgArray[1] = new MessageBean(R.mipmap.u79,"BEAM","$ 0.944157","+ 2.30%","667.3481","0.000000");
        msgArray[2] = new MessageBean(R.mipmap.u50,"BTC","$ 5000","+ 15%","3.3456","0.000000");
        msgArray[3] = new MessageBean(R.mipmap.u54,"ETH","$ 167.51","+ 0.8%","9.123","0.000000");
        msgArray[4] = new MessageBean(R.mipmap.u80,"AE","$ 0.647703","+ $ 9.14","1212.2567","0.000000");
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
