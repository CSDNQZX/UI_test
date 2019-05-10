package com.mining.power.list.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.mining.modle.entity.DataSet;
import com.mining.modle.utils.StringUtils;
import com.mining.power.list.entity.CalculationPower;
import com.mining.power.list.entity.DataSet2;
import com.mining.power.list.entity.HotelEntity;
import com.mining.power.list.utils.HotelUtils;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yushuangping on 2018/8/23.
 */

public class HotelEntityAdapter extends SectionedRecyclerViewAdapter<HeaderHolder, DescHolder, RecyclerView.ViewHolder> {


    public List<DataSet2.ObjectBean>  allTagList;
    private Context mContext;
    private LayoutInflater mInflater;


    private SparseBooleanArray mBooleanMap;//记录下哪个section是被打开的

    public HotelEntityAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mBooleanMap = new SparseBooleanArray();
    }

    public void setData(List<DataSet2.ObjectBean> list) {
        this.allTagList = list;
        for(int i=0;i<allTagList.size();i++){
            mBooleanMap.put(i, true);
        }
        notifyDataSetChanged();
    }

    /**
     * 一共有多少个section需要展示， 返回值是我们最外称list的大小，在我们的示例图中，
     * 对应的为热门品牌—商业区—热门景点 等，对应的数据是我们的allTagList
     *
     * @Override
     */

    protected int getSectionCount() {
        return HotelUtils.isEmpty(allTagList) ? 0 : allTagList.size();
    }

    /**
     * 来展示content内容区域，返回值是我们需要展示多少内容，在本例中，我们超过8条数据只展示8条，
     * 点击展开后就会展示全部数据，逻辑就在这里控制。 对应数据结构为tagInfoList
     *
     * @param section
     * @return
     */
    @Override
    protected int getItemCountForSection(int section) {
        List<DataSet2.ObjectBean.TagInfoListBean> list=(List)allTagList.get(section).getTagInfoList();
        int  count =list.size();

        if (count >= 1 && !mBooleanMap.get(section)) {
            count = 0;
        }
        if (section==0&&mBooleanMap.get(section)){
            List<DataSet2.ObjectBean.TagInfoListBean> listzz=(List)allTagList.get(section).getTagInfoList();
            count =listzz.size();
        }
        return HotelUtils.isEmpty(list) ? 0 : count;
    }

    //是否有footer布局

    /**
     * 判断是否需要底部footer布局，在该例中，我们并不需要显示footer，所以默认返回false就可以，
     * 如果你对应的section需要展示footer布局，那么就在对应的section返回true就行了
     *
     * @param section
     * @return
     */
    @Override
    protected boolean hasFooterInSection(int section) {
        return false;
    }

    @Override
    protected HeaderHolder onCreateSectionHeaderViewHolder(ViewGroup parent, int viewType) {
        return new HeaderHolder(mInflater.inflate(R.layout.hotel_title_item, parent, false));
    }


    @Override
    protected RecyclerView.ViewHolder onCreateSectionFooterViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    protected DescHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        return new DescHolder(mInflater.inflate(R.layout.hotel_desc_item, parent, false));
    }


    @Override
    protected void onBindSectionHeaderViewHolder(final HeaderHolder holder, final int section) {
      /*  holder.openView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isOpen = mBooleanMap.get(section);
               // String text = isOpen ? "展开" : "关闭";
                mBooleanMap.put(section, !isOpen);
               // holder.openView.setText(text);
                notifyDataSetChanged();
            }
        });*/

        DataSet2.ObjectBean bean=allTagList.get(section);
        holder.img_currency.setImageResource(StringUtils.getImage(bean.getTagsName()));
        holder.img_currency_text.setText(bean.getTagsName());
        //holder.openView.setText(mBooleanMap.get(section) ? "关闭" : "展开");//true显示关闭字段，false显示展开字段
    }


    @Override
    protected void onBindSectionFooterViewHolder(RecyclerView.ViewHolder holder, int section) {

    }

    /**
     * 这里有一个section和position ，有些人可能会弄混
     * section是区域，也就是我们最外层的index，position是每个section对应的内容数据的position
     *
     * @param holder
     * @param section
     * @param position
     */
    @Override
    protected void onBindItemViewHolder(final DescHolder holder, final int section, final int position) {
        //Log.e("=====AAA===", "section=" + section + ",position=" + position);
        List<DataSet2.ObjectBean.TagInfoListBean> list=(List)allTagList.get(section).getTagInfoList();
        DataSet2.ObjectBean.TagInfoListBean ca=list.get(position);
        holder.type_time_text.setText(StringUtils.getdayTime(ca.getCurrency(),ca.getCperiod()));
        if(ca.getState().equals("1")){
            //认购中
            holder.img_yhj.setBackgroundResource(R.mipmap.u430);
            holder.img_rx.setBackgroundResource(R.mipmap.u78);
            holder.text_rx.setText("热销");
        }if(ca.getState().equals("2")){
            //预售
            holder.img_yhj.setVisibility(View.INVISIBLE);
            holder.img_rx.setBackgroundResource(R.mipmap.u420);
            holder.text_rx.setText("预售");
        }if(ca.getState().equals("3")){
            //已售尽
        }

        holder.power_price.setText("￥"+ca.getCprice());
        holder.danwei_text.setText(StringUtils.getDanwei(ca.getCurrency()));
        holder.cpower_text.setText(ca.getCpower()+StringUtils.getDanwei(ca.getCurrency()));
        holder.surplus_text.setText(ca.getSurplus()+"份");
        holder.reference_yields.setText(ca.getReferenceYields()+"%");//参考年收益率
        holder.day_yield_text.setText(ca.getDayYield());//预计日产出
        holder.release_time_text.setText(ca.getReleaseTime());

        holder.layout_a_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(section, position,holder);

            }
        });

    }




    private OnItemClickListener onItemClickListener;

    public void setOnItemClick(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int section, int position,DescHolder holder);
    }
}
