package com.mining.power;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.mining.R;
import com.mining.modle.base.BaseFragment;
import com.mining.power.list.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by david on 2016/4/19.
 */
public class MainPowerPageFragment extends BaseFragment {
    private List<Fragment> fragmentList = new ArrayList<>();
    private FragmentAdapter adapter = null;
    private View fragmentView = null;

    @BindView(R.id.rg_type)    RadioGroup rg_type;
    @BindView(R.id.rb_download)    RadioButton rb_download;
    @BindView(R.id.rb_update)    RadioButton rb_update;
    @BindView(R.id.viewPager)
    ViewPager viewPager;


    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initViews(View view) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_main_updata, null);
        ButterKnife.bind(this,fragmentView);
        init();
        return fragmentView;
    }

    private void init() {
        rg_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_download)
                    viewPager.setCurrentItem(0);
                else
                    viewPager.setCurrentItem(1);
            }
        });
        rb_download.setChecked(true);
        fragmentList.clear();
        fragmentList.add(new CalculationPowerFragment());
        fragmentList.add(new PurchasingPowerFragment());
        adapter = new FragmentAdapter(getChildFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i==0)
                    rg_type.check(R.id.rb_download);
                else
                    rg_type.check(R.id.rb_update);
            }
            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
