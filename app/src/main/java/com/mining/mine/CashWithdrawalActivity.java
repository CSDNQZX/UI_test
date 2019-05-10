package com.mining.mine;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.mining.modle.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/*提现*/
public class CashWithdrawalActivity extends BaseActivity {
    @BindView(R.id.title_text)
    TextView title_text;//标题
    @BindView(R.id.add_btn)
    TextView add_btn;//标题
    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_cash_withdrawal;
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
    }

    /*返回*/
    @OnClick(R.id.ic_reback) void news_btn() {
        this.finish();
    }

    /*提现记录*/
    @OnClick(R.id.add_btn) void add_btn() {
        startActivity(RecordWithdrawActivity.class);
    }
    /*添加选择按钮事件*/
    @OnClick(R.id.right_goto) void right_goto() {
        showPopwindow();
    }

    /*提现记录*/
  /*  @OnClick(R.id.add_btn) void add_btn() {
        startActivity(WithdrawalsRecordActivity.class);
    }*/
    /**
     * 显示popupWindow
     */
    private void showPopwindow() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_popwindow_layout_c, null);


        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()

        PopupWindow window = new PopupWindow(view,
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
        window.showAtLocation(CashWithdrawalActivity.this.findViewById(R.id.right_goto),
                Gravity.BOTTOM, 0, 0);

        // 这里检验popWindow里的button是否可以点击
        Button use_new_card = (Button) view.findViewById(R.id.use_new_card);
        use_new_card.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(BankCardActivity.class);
            }
        });
        /*Button second = (Button) view.findViewById(R.id.second);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(WeixinActivity.class);
            }
        });
        Button third = (Button) view.findViewById(R.id.third);
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(BankCardActivity.class);
            }
        });*/
        //popWindow消失监听方法
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                System.out.println("popWindow消失");
            }
        });

    }
}
