package cn.zhian.avater.iotproject.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-08 9:28
 * @Description: 通用方法
 */
public class GeneralMethods {

    public static boolean existApps(long mExistTimes) {
        if ((System.currentTimeMillis() - mExistTimes) > 2000) {
            return false;
        } else {
            UIManagerUtils.getInstance().exitSystem();
            return true;
        }
    }

    public static boolean networkState(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null) {
            return info.isAvailable();
        }
        return false;
    }

    public static boolean judgeChinePhoneNumber(String str) {
        String regExp = "^((13[0-9])|(15[^4])|(166)|(17[0-8])|(18[0-9])|(19[8-9])|(147,145))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}

