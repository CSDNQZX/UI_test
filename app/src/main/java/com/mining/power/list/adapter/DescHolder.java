package com.mining.power.list.adapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mining.R;

import butterknife.BindView;

/**
 * Created by yushuangping on 2018/8/23.
 */

public class DescHolder extends RecyclerView.ViewHolder {
    public LinearLayout layout_a_id;
    public TextView type_time_text;
    public LinearLayout img_yhj;
    public LinearLayout img_rx;
    public TextView text_rx;
    public TextView power_price;
    public TextView danwei_text;
    public TextView cpower_text;
    public TextView surplus_text;
    public TextView reference_yields;
    public TextView day_yield_text;
    public TextView release_time_text;

    public DescHolder(View itemView) {
        super(itemView);
        initView();
    }
    private void initView() {
        layout_a_id=(LinearLayout) itemView.findViewById(R.id.layout_a_id);//最外面那一层布局
        type_time_text = (TextView) itemView.findViewById(R.id.type_time_text);//GRIN-29-180天
        img_yhj = (LinearLayout) itemView.findViewById(R.id.img_yhj);//图片优惠劵
        img_rx = (LinearLayout) itemView.findViewById(R.id.img_rx);//热销
        text_rx = (TextView) itemView.findViewById(R.id.text_rx);//热销文字
        power_price = (TextView) itemView.findViewById(R.id.power_price);//价格
        reference_yields = (TextView) itemView.findViewById(R.id.reference_yields);//理论收益率
        day_yield_text=(TextView) itemView.findViewById(R.id.day_yield_texts);//日理论产量
        danwei_text = (TextView) itemView.findViewById(R.id.danwei_text);//单位
        cpower_text = (TextView) itemView.findViewById(R.id.cpower_text);//1 graph/份
        surplus_text = (TextView) itemView.findViewById(R.id.surplus_text);//20份
        release_time_text = (TextView) itemView.findViewById(R.id.release_time_text);//2019-04-05
    }
}
