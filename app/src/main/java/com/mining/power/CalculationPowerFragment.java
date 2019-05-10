package com.mining.power;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.administrator.mining.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mining.mine.MiningProfitActivity;
import com.mining.modle.base.BaseFragment;
import com.mining.modle.entity.DataSet;
import com.mining.modle.model.BasicViewFragment;
import com.mining.modle.utils.ServerURL;
import com.mining.modle.utils.StringUtils;
import com.mining.modle.waterdroplistview.view.WaterDropListView;
import com.mining.orepool.IntroductionOrepondActivity;
import com.mining.power.list.adapter.DescHolder;
import com.mining.power.list.adapter.HotelEntityAdapter;
import com.mining.power.list.entity.DataSet2;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

/***
 * 算力列表
 *
 * */
public class CalculationPowerFragment extends BaseFragment{
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private HotelEntityAdapter mAdapter;


    /*初始化*/
    public void initView() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_calculation_power;
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initViews(View view) {

    }

}
