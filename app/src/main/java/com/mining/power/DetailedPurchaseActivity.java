package com.mining.power;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.mining.MainActivity;
import com.mining.mine.NewsDetailsActivity;
import com.mining.modle.Dialog.CustomPopWindow;
import com.mining.modle.base.BaseActivity;
import com.mining.orepool.IntroductionMachineActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class DetailedPurchaseActivity extends BaseActivity implements ViewPager.OnPageChangeListener{
    @BindView(R.id.title_text)
    TextView title_text;//标题
    @BindView(R.id.ll_point_container)
    LinearLayout ll_point_container;//标题
    @BindView(R.id.viewpager)
    ViewPager viewPager;//标题
    private int[] imageResIds;
    private ArrayList<ImageView> imageViewList;
    private int previousSelectedPosition = 0;
    boolean isRunning = false;

    private CustomPopWindow mPopWindow;
    //定义以及初始化数据
    private GridView gridView;
    private List<Map<String,Object>> dataList;
    /*  private int[] icon={R.mipmap.u26,R.mipmap.u50,R.mipmap.u79,R.mipmap.u80,R.mipmap.u80};
      private String[] iconName={"GRIN","BTC","ETH","BEAM","AE"};*/
    private String[] iconName={"￥ 87.9 / 份","1 graph / s / 份","4.25 GRIN","2019-04-05","2019-07-05","0.00 元","0.00 元","0.00 元","0.00 元"};
    private String[] icon={"算力价格","算力大小","理论总产量","到期时间","挖币时间","电费","机位费","上架费","维修费"};

    private SimpleAdapter adapter;

    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_detailed_purchase;
    }
    /***
     * 相关 代码业务的处理
     * @param activity
     */
    @Override
    public void doBusiness(Activity activity) {
        setSteepStatusBar(true);
        // 初始化布局 View视图
        initViews();
        // Model数据
        initData();
        // Controller 控制器
        initAdapter();
        // 开启轮询
        new Thread() {
            public void run() {
                isRunning = true;
                while (isRunning) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 往下跳一位
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                        }
                    });
                }
            }

            ;
        }.start();

        //调用弹窗方法
        touchOutsideDontDisMiss();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        isRunning = false;
    }

    private void initViews() {
        title_text.setText(getResources().getString(R.string.w5));
        viewPager.setOnPageChangeListener(this);// 设置页面更新监听
    }

    /**
     * 初始化要显示的数据
     */
    private void initData() {
        // 图片资源id数组
        imageResIds = new int[]{R.mipmap.u241, R.mipmap.u245};
        // 初始化要展示的5个ImageView
        imageViewList = new ArrayList<ImageView>();
        ImageView imageView;
        View pointView;
        LinearLayout.LayoutParams layoutParams;
        for (int i = 0; i < imageResIds.length; i++) {
            // 初始化要显示的图片对象
            imageView = new ImageView(this);
            imageView.setBackgroundResource(imageResIds[i]);
            imageViewList.add(imageView);

            // 加小白点, 指示器
            pointView = new View(this);
            pointView.setBackgroundResource(R.mipmap.u242);
            layoutParams = new LinearLayout.LayoutParams(5, 5);
            if (i != 0)
                layoutParams.leftMargin = 10;
            // 设置默认所有都不可用
            pointView.setEnabled(false);
            ll_point_container.addView(pointView, layoutParams);
        }
    }

    private void initAdapter() {
        ll_point_container.getChildAt(0).setEnabled(true);
        previousSelectedPosition = 0;

        // 设置适配器
        viewPager.setAdapter(new DetailedPurchaseActivity.MyAdapter());

        // 默认设置到中间的某个位置
        int pos = Integer.MAX_VALUE / 2 - (Integer.MAX_VALUE / 2 % imageViewList.size());
        viewPager.setCurrentItem(5000000); // 设置到某个位置
    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        // 3. 指定复用的判断逻辑, 固定写法
        @Override
        public boolean isViewFromObject(View view, Object object) {
            // 当划到新的条目, 又返回来, view是否可以被复用.
            // 返回判断规则
            return view == object;
        }

        // 1. 返回要显示的条目内容, 创建条目
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            System.out.println("instantiateItem初始化: " + position);
            int newPosition = position % imageViewList.size();
            ImageView imageView = imageViewList.get(newPosition);
            // a. 把View对象添加到container中
            container.removeView(imageView);
            container.addView(imageView);
            // b. 把View对象返回给框架, 适配器
            return imageView; // 必须重写, 否则报异常
        }

        // 2. 销毁条目
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // object 要销毁的对象
            // System.out.println("destroyItem销毁: " + position);
            // container.removeView((View) object);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels) {
        // 滚动时调用
    }

    @Override
    public void onPageSelected(int position) {
        // 新的条目被选中时调用
        System.out.println("onPageSelected: " + position);
        int newPosition = position % imageViewList.size();
        // 把之前的禁用, 把最新的启用, 更新指示器
        ll_point_container.getChildAt(previousSelectedPosition).setEnabled(false);
        ll_point_container.getChildAt(newPosition).setEnabled(true);
        // 记录之前的位置
        previousSelectedPosition = newPosition;

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        // 滚动状态变化时调用

    }

    /**
     * 点击 PopupWindow
     */
    private void touchOutsideDontDisMiss(){

        View view = LayoutInflater.from(this).inflate(R.layout.activity_detailed_purchase,null);
        //实例化gridView
        gridView=(GridView)findViewById(R.id.gridView);
        dataList=new ArrayList<>();
        adapter=new SimpleAdapter(this,getData(),R.layout.item_detailed_purchase,new String[]{"image","text"},
                new int[]{R.id.image,R.id.text});
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                        startActivity(NounTranslationActivity.class);
                    } });
        // gridView.setOnItemClickListener(this);

        // View.OnClickListener listener = new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //         Log.e("FK","onClick.....");
        //         mPopWindow.dissmiss();
        //     }
        // };
        //view.findViewById(R.id.close_pop).setOnClickListener(listener);
      /*  mPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(view)
                .enableOutsideTouchableDissmiss(true)// 设置点击PopupWindow之外的地方，popWindow不关闭，如果不设置这个属性或者为true，则关闭
                .create();

        mPopWindow.showAsDropDown(layout_id,0,10);*/
    }

    //装载数据
    private List<Map<String,Object>> getData(){
        for(int i=0;i<icon.length;i++){
            Map<String,Object>map=new HashMap<>();
            map.put("image",icon[i]);
            map.put("text",iconName[i]);
            dataList.add(map);
        }
        return dataList;
    }

    /*返回*/
    @OnClick(R.id.ic_reback) void news_btn() {
        this.finish();
        Bundle b = new Bundle();
        b.putString("home", "2");
        startActivity(MainActivity.class,b);
    }
    /*点击购买按钮*/
    @OnClick(R.id.btn_buy) void btn_buy() {
        startActivity(ConfirmPurchaseActivity.class);
    }

}
