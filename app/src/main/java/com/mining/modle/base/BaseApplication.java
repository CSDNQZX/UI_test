package com.mining.modle.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.Stack;

/**
 * Created by Auser on 2017/12/23.
 */

public class BaseApplication extends Application {

    // Application实例
    public static BaseApplication application;
    // 所有正在运行的Activities的实例
    private Stack<Activity> activityStack = new Stack<Activity>();

    public static BaseApplication getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        //MobSDK.init(this);
    }

    public void registerActivity(Activity activity) {
        activityStack.push(activity);
    }

    public void unregisterActivity(Activity activity) {
        activityStack.remove(activity);
    }

    public void finishAllActivities() {
        try {
            // 因为如果用activityStack去迭代finish Activity，在Activity onDestroy时，又会对activityStack进行删除操作，
            // 这时就会报ConcurrentModificationException异常，即在集合迭代时是不允许对集合进行删除或者添加操作，
            // 所以要复制一个集合，对这个复制集合进行迭代操作。
            Stack<Activity> cloneActivityStack = (Stack<Activity>) activityStack.clone();
            for (Activity activity : cloneActivityStack) {
                try {
                    if (null != activity && !activity.isFinishing()) {
                        // 不要finish的动画
                        ((BaseActivity2) activity).finishActivity();
                    }
                } catch (ClassCastException e) {
                    /* 打印异常信息 */
                    e.printStackTrace();
                    // 按正常的方法finish掉Activity
                    activity.finish();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    
    public static Context getMyApplicationContext(){
        return application.getApplicationContext();
    }

    /**
     * 获取当前APP版本号
     * @return
     */
    public static int getMyApplicationVersion(){
        try {
            PackageInfo info=getMyApplicationContext().getPackageManager().getPackageInfo(getMyApplicationContext().getPackageName(),0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return 1;
    }

}
