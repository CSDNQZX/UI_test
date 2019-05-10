package com.mining.modle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @author landptf
 * 公共的Adapter List适配器
 */
public abstract class AdapterM<T> extends BaseAdapter {

    private Context context;
    //为丰富程序功能，提供了两种常见的数据类型
    private List<T> dataList = null;//数据源List<T>
    private T[] dataArray = null;//数据源T[]
    //布局文件ID
    private int layoutId;

    private int mBR;

    private LayoutInflater mLayoutInflater;

    private int tag=0;

    /*int mselectPosistion=0;

    ListViewOnItmeClickListener mListViewOnItmeClickListener;
    ListViewOnBindItmeView mListViewOnBindItmeView;*/

    /**
     * 构造方法
     * @param context
     * @param layoutId
     * @param dataList
     */
    public AdapterM(Context context,int layoutId, List<T> dataList) {
        mLayoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.dataList = dataList;
        this.layoutId = layoutId;
        //mBR=br;
    }

    /**
     * 构造方法(与上一个只有数据源不同)
     * @param context
     * @param layoutId
     * @param dataArray
     */
    public AdapterM(Context context,int layoutId, T[] dataArray) {
        this.context = context;
        this.dataArray = dataArray;
        this.layoutId = layoutId;
    }
    public int getTag() {
        return tag;
    }

    public void setTag(int mtag) {
        this.tag = mtag;
    }
/*    public void setOnItmeClickListener(ListViewOnItmeClickListener listViewOnItmeClickListener){
        this.mListViewOnItmeClickListener=listViewOnItmeClickListener;
    }

    public void setOnBindItmeView(ListViewOnBindItmeView listViewOnBindItmeView){
        this.mListViewOnBindItmeView=listViewOnBindItmeView;
    }*/

    @Override
    public int getCount() {
        if (dataList != null) {
            return dataList.size();
        }else {
            return dataArray.length;
        }
    }
    @Override
    public T getItem(int position) {
        if (dataList != null) {
            return dataList.get(position);
        }else {
            return dataArray[position];
        }

    }
    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // final T model=dataArray[position];

        ViewHolderM holder = new ViewHolderM(context, convertView, parent,layoutId, position);
        convert(holder,getItem(position));

/*        ViewDataBinding binding=null ;
        if (convertView==null){
            convertView = mLayoutInflater.inflate(layoutId, parent,false);

            binding= DataBindingUtil.bind(convertView);

        }else{
            binding = DataBindingUtil.getBinding(convertView);

        }

        if (mListViewOnItmeClickListener!=null) {
            mListViewOnItmeClickListener.OnItemClick(model,position,tag);
        }
        //binding.setVariable(mBR,model);


        if (mListViewOnBindItmeView!=null){
            mListViewOnBindItmeView.OnBindItmeView( binding.getRoot(),model,position,mselectPosistion,tag);
        }
     //   return binding.getRoot();*/

        return holder.getConvertView();
    }
    /**
     * 需实现的抽象方法
     * @param holder
     * @param model
     */
    public abstract void convert(ViewHolderM holder, T model);

/*    public interface ListViewOnItmeClickListener{
        void OnItemClick(Object obejct, int position, int tag);
    }

    public interface ListViewOnBindItmeView{ //对itme中的布局进行操作
        void OnBindItmeView(View view, Object obejct, int position, int selectPosition, int tag);
    }*/

}