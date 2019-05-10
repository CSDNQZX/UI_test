package com.mining.power.list.adapter;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zixin on 2016/4/19.
 */
public class FragmentAdapter extends MyPageAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();
    public FragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        fragmentList = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return i>=0 && i<fragmentList.size()?fragmentList.get(i):null;
    }
    @Override
    public int getCount() {
        return fragmentList!=null?fragmentList.size():0;
    }
}
