package com.mining.modle.utils;

import android.app.Activity;
import android.util.Log;

import com.mining.modle.model.BasicViewActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

/**
 * @author tianyh 
 * @Description:调用后台接口
 */
public class HttpServices2 {

	private BasicViewActivity currentView;

	public void  doPostHttps(Activity activity,List<String> list, String url) {
		currentView= (BasicViewActivity) activity;
		//组装请求参数
		try {
			OkHttpUtils
					.post()
					.url(url)
					.addParams("gson",StringUtils.getParams(list))
					.build()
					.execute(new StringCallback() {
					@Override
					public void onError(Call call, Exception e, int id) {
						Log.d("mainactivity", e.getMessage());
						setError("连接失败,请检查网络");
					}

						@Override
						public void onResponse(String response, int id) {
							Log.d("response", response);
							onSuccess(response);
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onSuccess(String response){
		currentView.onSuccess(response);
	}

	public void setError(String response){
		currentView.onErrors(response);
	}
}
