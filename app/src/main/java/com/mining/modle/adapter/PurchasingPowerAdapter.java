package com.mining.modle.adapter;

import android.content.Context;

import com.example.administrator.mining.R;

/**
 * @author landptf
 * ListAdapter List适配器
 */
public class PurchasingPowerAdapter extends AdapterM<MessageBean>{

    public PurchasingPowerAdapter(Context context, int layoutId, MessageBean[] dataArray) {
        super(context, layoutId, dataArray);
    }

    @Override
    public void convert(ViewHolderM holder, MessageBean model) {
       // 为个控件绑定内容
        holder.setText(R.id.content_a, model.getContent_a());
        holder.setText(R.id.content_b, model.getContent_b());
        holder.setText(R.id.content_c, model.getContent_c());
        holder.setText(R.id.content_d, model.getContent_d());
        holder.setText(R.id.content_e, model.getContent_e());
        holder.setText(R.id.content_f, model.getContent_f());
        holder.setText(R.id.content_g, model.getContent_g());
        holder.setText(R.id.content_h, model.getContent_h());
        }

    /**自定义RecyclerView item的点击事件的点击事件*/
    interface OnItemClickListener {
        void OnItemClickListener(ViewHolderM holder, int position);
    }

}