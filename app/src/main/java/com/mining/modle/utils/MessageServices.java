package com.mining.modle.utils;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.example.administrator.mining.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.MediaType;

/**
 * @author tianyh 
 * @Description:国际短信发送验证码
 */
public class MessageServices {
	public static void sendMessage(String mobile,String message) {
		//组装请求参数
		try {
			JSONObject map;
			map = new JSONObject();
			map.put("account", ServerURL.ACCOUNT);
			map.put("password", ServerURL.PASSWORD);
			map.put("senderId", ServerURL.SENDERID);
			map.put("msg", message);
			map.put("mobile", "86"+mobile);
			String params = map.toString();
			System.out.println("params:" + params);
			OkHttpUtils
					.postString()
					.url(ServerURL.SEND_MESSAGE_URL)
					.content(map.toString())
					.mediaType(MediaType.parse("application/json; charset=utf-8"))
					.build()
					.execute(new StringCallback() {
						@Override
						public void onError(Call call, Exception e, int id) {
							Log.d("mainactivity", e.getMessage());
						}

						@Override
						public void onResponse(String response, int id) {
							Log.d("mainactivity", response);
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void sendNotification(String message,Context context) {
		//获取NotificationManager实例
		NotificationManager notifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		//实例化NotificationCompat.Builde并设置相关属性
		NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
				//设置小图标
				.setSmallIcon(R.mipmap.u2401)
				//设置通知标题
				.setContentTitle("【GRINOK】向您推送了一条消息")
				//设置通知内容
				.setContentText(message);
		//设置通知时间，默认为系统发出通知的时间，通常不用设置
		//.setWhen(System.currentTimeMillis());
		//通过builder.build()方法生成Notification对象,并发送通知,id=1
		notifyManager.notify(1, builder.build());
	}

}
