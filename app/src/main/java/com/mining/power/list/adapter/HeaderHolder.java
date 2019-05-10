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

public class HeaderHolder extends RecyclerView.ViewHolder {
    public ImageView img_currency;
    public TextView img_currency_text;
    public HeaderHolder(View itemView) {
        super(itemView);
        initView();
    }

    private void initView() {
        img_currency = (ImageView) itemView.findViewById(R.id.img_currency);
        img_currency_text = (TextView) itemView.findViewById(R.id.img_currency_text);
    }
}
