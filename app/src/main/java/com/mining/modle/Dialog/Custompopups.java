package com.mining.modle.Dialog;

import android.app.Activity;
import android.app.Dialog;

import com.example.administrator.mining.R;
import com.mining.modle.utils.SystemConfig;

/**
 * Created by qzx on 2017/5/9.
 */

public class Custompopups {

    private static Dialog waitDialog;
    private static Activity content;

    //正在加载状态
    public static void beingLoaded(Activity activity) {
        new TimerDolog().Timerdolog();
        content=activity;
        waitDialog = new Dialog(activity, R.style.TRANSDIALOG);
        waitDialog.setContentView(R.layout.toask_prompt_layout);
        waitDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        waitDialog.setCancelable(false);
        waitDialog.setCanceledOnTouchOutside(true);
        waitDialog.show();
    }
    //取消正在加载
    public static void beingLoadedCancel() {
        if (waitDialog != null){
            waitDialog.cancel();
            SystemConfig.itimerstatu=false;
        }
    }
}