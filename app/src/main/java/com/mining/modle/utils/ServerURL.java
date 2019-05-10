package com.mining.modle.utils;

/**
 * Created by zixin on 2019/4/20.
 */


public class ServerURL {



    //基类链接
    //public static final String BASE_URL = "http://zixin.ink:8080/mining/api/";
    public static final String BASE_URL = "http://192.168.137.1:8080/mining/api/";
    //发送短信验证码
    public static final String SEND_MESSAGE_URL = "http://intapi.253.com/send/json";
    //API账号，50位以内。必填
    public static final String ACCOUNT="I9462610";
    //API账号对应密钥，联系客服获取。必填
    public static final String PASSWORD="GRINOK2020";
    //用户收到短信之后显示的发件人，国内不支持自定义，国外支持，但是需要提前和运营商沟通注册，具体请与TIG对接人员确定。选填
    public static final String SENDERID = "";
    //登陆接口
    public static final String DO_LOGIN_URL = BASE_URL+"account";
    //登陆接口
    public static final String DO_REGISTER_URL = BASE_URL+"register";
    //修改密码
    public static final String DO_UPDATE_URL = BASE_URL+"updatePassword";
    //获取后台发布的算力列表
    public static final String GETPOWERDATE = BASE_URL+"getPowerList";
    //提交算力购买订单接口
    public static final String SUBMITORDER = BASE_URL+"submitOrder";
    //查看已购算力列表
    public static final String ALREADYBUYLIST = BASE_URL+"alreadyBuylist";
    //查询已购算力，查询订单状态
    public static final String GETAUDITDATE = BASE_URL+"getAuditData";
    //未按规定时间内付款需要加上剩余数量
    public static final String ADDSURPLUS = BASE_URL+"addSurplus";




}
