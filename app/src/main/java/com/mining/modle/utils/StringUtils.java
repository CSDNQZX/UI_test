package com.mining.modle.utils;

import android.app.NotificationManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;

import com.alibaba.fastjson.JSONObject;
import com.example.administrator.mining.R;

import java.io.BufferedReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.sql.Clob;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    //获得字符串，如果字符串为空，那么设置默认值
    public static String getString(String temp, String defaultValue) {
        return temp == null ? defaultValue : temp;
    }

    public static String getString(Object obj) {
        return getString(obj, null);
    }

    // 添加
    public static String getString(Object obj, String dateFormat) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Clob) {
            Clob clob = (Clob) obj;
            return StringUtils.getString(clob);
        } else if (obj instanceof Timestamp) {
            if (StringUtils.isNotEmpty(dateFormat)) {
                return new SimpleDateFormat(dateFormat).format((Timestamp) obj);
            }
        }
        return obj.toString();
    }

    // 将clob转换成String
    public static String getString(Clob clob) {
        if (clob == null)
            return null;
        try {
            BufferedReader in = new BufferedReader(clob.getCharacterStream());
            StringWriter out = new StringWriter();
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            return out.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static boolean getBoolean(String temp) {
        temp = getString(temp, "");
        if ("true".equalsIgnoreCase(temp)) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equalsIgnoreCase(str);
    }

    public static boolean isNotEmpty(String str) {
        return str != null && !"".equalsIgnoreCase(str);
    }

    public static int getInt(String temp, int defaultValue) {
        int out = 0;
        try {
            out = Integer.parseInt(temp);
        } catch (Exception ex) {
            out = defaultValue;
        }
        return out;
    }

    /**
     * 得到double数据
     *
     * @param values String
     */
    public static double getDouble(String values, double defaultValue) {
        double thisDouble = 0;
        try {
            values = values == null ? "" : values;
            values = "".equals(values) ? "0" : values;
            thisDouble = new BigDecimal(values).doubleValue();
        } catch (Exception ex) {
            thisDouble = defaultValue;
        }
        return thisDouble;
    }

    // 获得一个字符串中包含另外一个字符串的个数
    public static int getNum(String base, String place) {
        int returnNum = 0;
        int placenum = place.length();
        while (base.indexOf(place) != -1) {
            returnNum++;
            int num = base.indexOf(place);
            base = base.substring(num + placenum, base.length());
        }
        return returnNum;
    }

    // 将时间字符串构造成Timestamp类型的数据
    public static Timestamp getTimestamp(String invalue) {
        if (invalue.lastIndexOf(":") != -1) {
            if (invalue.lastIndexOf(".") == -1) {
                if (invalue.length() == "yyyy-MM-dd HH:mm".length()) // 如果是年月日时分
                {
                    invalue = invalue + ":00.0";
                } else if (invalue.length() == "HH:mm:ss".length())// 如果是时分秒
                {
                    invalue = "1970-01-01 " + invalue + ".0";
                } else {
                    invalue = invalue + ".0";
                }
            }
        } else {
            if (invalue.length() > "yyyy-MM".length())// 年月日
            {
                invalue = invalue + " 00:00:00.0";
            } else
            // 年月
            {
                invalue = invalue + "-01 00:00:00.0";
            }
        }
        invalue = invalue.replace("/", "-"); // 如果包含"/"则把"/"替换成"-"
        //-------------------------- 处理非法日期串 如 1998-8-1中的月数和天数（excel中的日期通常会有这种情况）-------------------------
        StringBuffer sbf = new StringBuffer();
        String[] timestampArrs = invalue.split(" ");
        if (timestampArrs != null && timestampArrs.length > 0) {
            String[] timeDayStr = timestampArrs[0].split("-");
            if (timeDayStr != null && timeDayStr.length > 0) {
                sbf.append(timeDayStr[0]); // 追加年份
                for (int i = 1, count = timeDayStr.length; i < count; i++) {// 处理月份和天 如8-1,如果数字小于10，则补零
                    String dayStr = timeDayStr[i];
                    dayStr = dayStr.length() >= 2 ? dayStr : "0" + dayStr;
                    sbf.append("-" + dayStr);
                }
            }
            if (StringUtils.isNotEmpty(timestampArrs[1])) {// 时分秒
                sbf.append(" " + timestampArrs[1]);
            }
        }
        // -----------------------------------------------------------------------------
        return Timestamp.valueOf(sbf.toString());
    }

    // 将列表转换成字符串，根绝设置判断是否增加前后缀
    public static String getListString(List<String> list, boolean isProfix) {
        String[] strs = list.toArray(new String[list.size()]);
        return getListString(strs, isProfix);
    }

    public static String getListString(String[] strs, boolean isProfix) {
        StringBuffer sbf = new StringBuffer();
        for (int i = 0, count = strs.length; i < count; i++) {
            if (isProfix) {
                sbf.append("'");
            }
            sbf.append(strs[i]);
            if (isProfix) {
                sbf.append("'");
            }
            if (i < count - 1) {
                sbf.append(",");
            }
        }
        return sbf.toString();
    }

    public static boolean isMobileNO(String mobileNums) {
        /**
         * 判断字符串是否符合手机号码格式
         * 移动号段: 134,135,136,137,138,139,147,150,151,152,157,158,159,170,178,182,183,184,187,188
         * 联通号段: 130,131,132,145,155,156,170,171,175,176,185,186
         * 电信号段: 133,149,153,170,173,177,180,181,189
         * @param str
         * @return 待检测的字符串
         */
        String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";// "[1]"代表下一位为数字可以是几，"[0-9]"代表可以为0-9中的一个，"[5,7,9]"表示可以是5,7,9中的任意一位,[^4]表示除4以外的任何一个,\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobileNums))
            return false;
        else
            return mobileNums.matches(telRegex);
    }

    /**
     * 随机生成四位小数手机验证码
     **/
    public static int randomMobileCode() {
        return (int) (Math.random() * 8999) + 1000;
    }

    /**
     * 利用正则表达式判断字符串是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /*将一个字符串转成整型*/
    public static int strToInteger(String str) {
        return Integer.parseInt(str);
    }

    /*将一个字符串长度是否在6-16位数之间*/
    public static boolean countString(String str) {
        return str.length() > 6 && str.length() < 16;
    }

    /*将一个字符串是否一样*/
    public static boolean equleStr(String str1, String str2) {
        return str1.equals(str2);
    }

    public static String getIPAddress(Context context) {
        NetworkInfo info = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
                try {
                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }

            } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ipAddress = intIP2StringIP(wifiInfo.getIpAddress());//得到IPV4地址
                return ipAddress;
            }
        } else {
            //当前无网络连接,请在设置中打开网络
        }
        return null;
    }

    /**
     * 将得到的int类型的IP转换为String类型
     *
     * @param ip
     * @return
     */
    public static String intIP2StringIP(int ip) {
        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                (ip >> 24 & 0xFF);
    }

    /***
     * 将封装好的value返回
     * */
    public static String getParamValue(String value) {
        String v = value != null ? value : "";
        return ":" + v;
    }

    /***
     * 将封装好的list
     * */
/*	public static String getParamList(List<String> list) {
        //String v=":"+value!=null?value:"";
		String[] newStr =  list.toArray(new String[1]);
		return v;
	}*/


    /**
     * 将一个数组转成字符串
     * 用于传值
     */
    public static String getParams(List<String> list) {
        if (list != null) {
            String[] arrayData = list.toArray(new String[1]);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < arrayData.length; i++) {
                stringBuilder.append(arrayData[i]);
                if (i < arrayData.length - 1) {
                    stringBuilder.append(",");
                }
            }
            return stringBuilder.toString();
        }
        return null;
    }

    /**
     * 获取名字
     * */
    public static String getCurrencyName(String currency) {
        String name = "";
        if(currency.equals("1")){
            name="GRIN";
        }if(currency.equals("2")){
            name="AE";
        }if(currency.equals("3")){
            name="BEAM";
        }if(currency.equals("4")){
            name="BTC";
        }if(currency.equals("5")){
            name="ETCH";
        }
        return name;
    }

    /**
     * 获取名字
     * */
    public static String getDanwei(String currency) {
        String name = "";
        if(currency.equals("1")){
            name=" grin/份";
        }if(currency.equals("2")){
            name=" grin/份";
        }if(currency.equals("3")){
            name=" graph/份";
        }if(currency.equals("4")){
            name=" grin/份";
        }if(currency.equals("5")){
            name=" grin/份";
        }
        return name;
    }

    public static String getStatu(String str) {
        String name = "";
        if(str.equals("1")){
            name="审核中";
        }if(str.equals("2")){
            name="已通过";
        }if(str.equals("3")){
            name="已驳回";
        }
        return name;
    }

    /**
     * 获取图片
     * */
    public static int getImage(String currency) {
        int image=0;
        if(currency.equals("GRIN")){
            image=R.mipmap.u26;
        }if(currency.equals("AE")){
            image=R.mipmap.u80;
        }if(currency.equals("BEAM")){
            image=R.mipmap.u79;
        }if(currency.equals("BTC")){
            image=R.mipmap.u50;
        }if(currency.equals("ETCH")){
            image=R.mipmap.u54;
        }
        return image;
    }
    /**
     * 获取图片
     * */
    public static String getdayTime(String currency,String daytime) {
        String str="";
        if(currency.equals("1")){
            str="GRIN-29 -"+daytime+"天";
        }if(currency.equals("2")){
            str="AE -"+daytime+"天";
        }if(currency.equals("3")){
            str="BEAM -"+daytime+"天";
        }if(currency.equals("4")){
            str="BTC -"+daytime+"天";
        }if(currency.equals("5")){
            str=" ETCH-"+daytime+"天";
    }
        return str;
    }
    /**
     * 计算总价格
     *
     * */
    public static BigDecimal getNumPrices(String editvalue,String power_price) {
        BigDecimal bigDecimal=null;
        BigDecimal bigDecima2=null;
        BigDecimal bigDecima=null;
        if(!(editvalue==null&&editvalue.equals(""))&&!(power_price==null&&power_price.equals(""))){
            bigDecimal=new BigDecimal(editvalue);//份数
            bigDecima2 = new BigDecimal(power_price);//单价
            return bigDecimal.multiply(bigDecima2);
        } else {
            return new BigDecimal("0.00");
        }
    }

    /**
     * 获取当前系统时间
     * 格式yy-MM-dd HH:mm:ss
     *
     * */
    public static String getDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //Date或者String转化为时间戳
        SimpleDateFormat format =  new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        return format.format(calendar.getTime());
    }


    /**
     * 获取当前系统时间
     * */
    public static String getDateMd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //Date或者String转化为时间戳
        SimpleDateFormat format =  new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return format.format(calendar.getTime());
    }


    /**
     * 获取当前系统时间并+1天
     * */
    public static String getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +1);//+1今天的时间加一天
        //Date或者String转化为时间戳
        SimpleDateFormat format =  new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        return format.format(calendar.getTime());
    }

    public static String getTime(Date time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  formatter.format(time);
    }

    /**
     * 挖矿到期时间
     * */
    public static String getDueTime(Date date,int NumDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +(NumDay+1));//+NumDay为挖矿的到期时间
        //Date或者String转化为时间戳
        SimpleDateFormat format =  new SimpleDateFormat("YYyy-MM-dd HH:mm:ss");
        return format.format(calendar.getTime());
    }

    /**
     * 支付方式
     * */
    public static String getPayType(String paytype) {
        String name="";
        if(paytype.equals("1")){
            name="微信支付";
        }if(paytype.equals("2")){
            name="支付宝支付";
        }if(paytype.equals("3")){
            name="银行卡支付";
        }
        return name;
    }

    /**
     * 支付方式
     * */
    public static String ispay(String state) {
        String name="";
        if(state.equals("1")){
            name="已支付";
        }if(state.equals("0")){
            name="未支付";
        }if(state.equals("2")){
            name="已过期";
        }
        return name;
    }

    /**
     * 付款显示的二维码
     * */
    public static int getPayImgbody(String paytype) {
        int image=0;
        if(paytype.equals("1")){
            //微信支付
            image=R.mipmap.u662;
        }if(paytype.equals("2")){
            //支付宝支付
            image=R.mipmap.u663;
        }if(paytype.equals("3")){
            image=R.mipmap.u664;
        }
        return image;
    }


    /**
     * 付款显示的二维码
     * */
    public static int getPayImghead(String paytype) {
        int image=0;
        if(paytype.equals("1")){
            //微信支付
            image=R.mipmap.u575;
        }if(paytype.equals("2")){
            //支付宝支付
            image=R.mipmap.u576;
        }if(paytype.equals("3")){
            image=R.mipmap.u577;
        }
        return image;
    }


    /***
     *  手机短信验证码
     * */
   /* public static String get(int type,String str) {
        String message="";
        switch (){}

        return image;
    }*/





}
