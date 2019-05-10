package com.mining.modle.Dialog;

import android.os.Handler;
import android.os.Message;

import com.mining.modle.utils.SystemConfig;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by qzx on 2017/8/29.
 */

public class TimerDolog {
    private  Timer timer = new Timer();
    Handler handler=null;
    TimerTask task = null;
    public  void  Timerdolog(){
        SystemConfig.itimerstatu=true;
        handler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 1) {
                    SystemConfig.itimer++;
                    if(SystemConfig.itimer==10){
                        Custompopups.beingLoadedCancel();//取消正在加载
                        SystemConfig.itimerstatu=false;
                        timer.cancel();
                    }
                }
                super.handleMessage(msg);
            };
        };
        task = new TimerTask() {

            @Override
            public void run() {
                // 需要做的事:发送消息
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
            }
        };
        if(SystemConfig.itimerstatu==true){
            timer.schedule(task, 1000, 1000); // 1s后执行task,经过1s再次执行
        }else{
            timer.cancel();
        }

    }
/*    //取消正在加载
    public  void TimerdologCancel() {
        if (timer != null) timer.cancel();
    }*/
}
