package com.mining;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.mining.R;
import com.mining.modle.base.BaseActivity;
import com.mining.mine.PersonPageFragment;
import com.mining.orepool.OrepoolActivity;
import com.mining.power.MainPowerPageFragment;
import com.mining.wallet.WalletActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private PersonPageFragment homePageFragment;
    private OrepoolActivity orepoolActivity;
    private MainPowerPageFragment mainPageFragment;
    private WalletActivity walletActivity;

    /*图标*/
    @BindView(R.id.mian_home_image)
    ImageView mian_home_image;//矿池
    @BindView(R.id.mian_home_image1)
    ImageView mian_home_image1;//算力
    @BindView(R.id.mian_home_image2)
    ImageView mian_home_image2;//钱包
    @BindView(R.id.mian_home_image3)
    ImageView mian_home_image3;//我的
    /**
     *  配置布局文件
     * */
    @Override
    public int bindLayout() {
        return R.layout.activity_main_a;
    }
    /***
     * 相关 代码业务的处理
     * @param activity
     */
    @Override
    public void doBusiness(Activity activity) {
        setSteepStatusBar(true);
        initView();
    }
    protected void initView() {
        setDefaultFragment();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private  void setDefaultFragment(){
        Bundle b = getIntent().getExtras();
        if(b!=null){
            String home = b.getString("home");
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            if(home.equals("4")){
                mian_home_image.setImageResource(R.mipmap.update_d);//矿池
                mian_home_image1.setImageResource(R.mipmap.meassage);//算力
                mian_home_image2.setImageResource(R.mipmap.tj_d);//钱包
                mian_home_image3.setImageResource(R.mipmap.home_b);//我的
                homePageFragment=new PersonPageFragment();
                transaction.replace(R.id.view_page_fragemnts,homePageFragment);
            } if(home.equals("3")){
                mian_home_image.setImageResource(R.mipmap.update_d);//矿池
                mian_home_image1.setImageResource(R.mipmap.meassage);//算力
                mian_home_image2.setImageResource(R.mipmap.tj_b);//钱包
                mian_home_image3.setImageResource(R.mipmap.home);//我的
                walletActivity=new WalletActivity();
                transaction.replace(R.id.view_page_fragemnts,walletActivity);
            } if(home.equals("2")){
                mian_home_image.setImageResource(R.mipmap.update_d);//矿池
                mian_home_image1.setImageResource(R.mipmap.meassage_b);//算力
                mian_home_image2.setImageResource(R.mipmap.tj_d);//钱包
                mian_home_image3.setImageResource(R.mipmap.home);//我的
                mainPageFragment=new MainPowerPageFragment();
                transaction.replace(R.id.view_page_fragemnts,mainPageFragment);
            } if(home.equals("1")) {
                mian_home_image.setImageResource(R.mipmap.update_d);//矿池
                mian_home_image1.setImageResource(R.mipmap.meassage);//算力
                mian_home_image2.setImageResource(R.mipmap.tj_d);//钱包
                mian_home_image3.setImageResource(R.mipmap.home_b);//我的
                orepoolActivity=new OrepoolActivity();
                transaction.replace(R.id.view_page_fragemnts,orepoolActivity);
            }
            transaction.commit();
        }else{
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            homePageFragment=new PersonPageFragment();
            transaction.replace(R.id.view_page_fragemnts,homePageFragment);
            transaction.commit();
        }

    }



    //矿池   算力   钱包  我的
    @OnClick({R.id.mian_home_rela,R.id.mian_add_rela,R.id.mian_message_rela,R.id.mian_me_rela})
    public void onClick(View view){
        FragmentManager fm = getFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        //是否是搜索页面
        boolean  isseach=false;
        //首页
        switch (view.getId()){
            case R.id.mian_home_rela:
                if (orepoolActivity == null)
                {
                    orepoolActivity = new OrepoolActivity();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.view_page_fragemnts,orepoolActivity);
                // 事务提交
                transaction.commit();
                mian_home_image.setImageResource(R.mipmap.upate_b);//矿池
                mian_home_image1.setImageResource(R.mipmap.meassage);//算力
                mian_home_image2.setImageResource(R.mipmap.tj_d);//钱包
                mian_home_image3.setImageResource(R.mipmap.home);//我的
                break;
            case R.id.mian_add_rela:
                if (mainPageFragment == null)
                {
                    mainPageFragment = new MainPowerPageFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.view_page_fragemnts,mainPageFragment);
                // 事务提交
                transaction.commit();
                mian_home_image.setImageResource(R.mipmap.update_d);//矿池
                mian_home_image1.setImageResource(R.mipmap.meassage_b);//算力
                mian_home_image2.setImageResource(R.mipmap.tj_d);//钱包
                mian_home_image3.setImageResource(R.mipmap.home);//我的
                break;
            //我的最爱
            case R.id.mian_message_rela:
                if (walletActivity == null)
                {
                    walletActivity = new WalletActivity();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.view_page_fragemnts,walletActivity);
                // 事务提交
                transaction.commit();
                mian_home_image.setImageResource(R.mipmap.update_d);//矿池
                mian_home_image1.setImageResource(R.mipmap.meassage);//算力
                mian_home_image2.setImageResource(R.mipmap.tj_b);//钱包
                mian_home_image3.setImageResource(R.mipmap.home);//我的
                break;
            //个人主页
            case R.id.mian_me_rela:
                if (homePageFragment == null)
                {
                    homePageFragment = new PersonPageFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.view_page_fragemnts,homePageFragment);
                // 事务提交
                transaction.commit();
                mian_home_image.setImageResource(R.mipmap.update_d);//矿池
                mian_home_image1.setImageResource(R.mipmap.meassage);//算力
                mian_home_image2.setImageResource(R.mipmap.tj_d);//钱包
                mian_home_image3.setImageResource(R.mipmap.home_b);//我的
                break;
            default:
                break;
        }

    }
}
