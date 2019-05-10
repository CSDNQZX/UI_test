/*******************************************************************************
 * 项目 ：  邮轮通 Android App
 * 客户 ：  泛网科技
 * 文件 ：  MainFragmentPager.java
 * 作者 ：  firstmet@swtech.xyz
 * 日期 ：  15-8-28 下午4:59
 * 版权 ：  Copyright  www.vonechina.com Inc. 2015 All Rights Reserved.
 * 描述 ：  App框架的FragmentPager适配器
 ******************************************************************************/

package com.mining.main.until;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainFragmentPager extends FragmentPagerAdapter {

    private ArrayList<Fragment> listfragment;

    public MainFragmentPager(FragmentManager fm) {
        // TODO Auto-generated constructor stub
        super(fm);

    }

    public MainFragmentPager(FragmentManager fm, ArrayList<Fragment> list, Context context) {
        super(fm);
        this.listfragment = list;

    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        switch (arg0) {
            case 0:

                break;

            default:
                break;
        }
        return listfragment.get(arg0);
    }

    @Override
    public int getCount() {
        return listfragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}