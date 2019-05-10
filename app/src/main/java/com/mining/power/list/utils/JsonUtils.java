package com.mining.power.list.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.mining.power.list.entity.HotelEntity;

/**
 * Created by yushuangping on 2018/8/23.
 */

public class JsonUtils {

    public static HotelEntity analysisJsonFile(Context context, String fileName){
        String content = FileUtils.readJsonFile(context,fileName);
        Gson gson = new Gson();
        HotelEntity entity = gson.fromJson(content, HotelEntity.class);
        return  entity;

    }
}
