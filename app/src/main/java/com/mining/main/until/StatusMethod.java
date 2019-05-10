package com.mining.main.until;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;

/**
 * Created by david on 2016/10/21.
 */
public class StatusMethod {

    /**
     * 监听对话框里面的button点击事件
     */
    public static DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                	//RoomCleanApplication.getInstance().exit();
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;

            }
        }
    };

    public static void showExitDialog(Activity activity) {
        // 创建退出对话框
        AlertDialog isExit = new AlertDialog.Builder(activity).create();
        // 设置对话框标题
        isExit.setTitle("系统提示");
        // 设置对话框消息
        isExit.setMessage("确定要退出系统");
        // 添加选择按钮并注册监听
        isExit.setButton(Dialog.BUTTON_POSITIVE, "确定", listener);
        isExit.setButton(Dialog.BUTTON_NEGATIVE, "取消", listener);
        // 显示对话框
        isExit.show();
    }
}
