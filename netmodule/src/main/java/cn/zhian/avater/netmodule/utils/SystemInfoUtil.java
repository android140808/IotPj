package cn.zhian.avater.netmodule.utils;

import android.content.Context;
import android.os.Build;

import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;

import cn.zhian.avater.netmodule.mode.PhoneInfo;


/**
 * Author: Avater
 * Time: 2019/3/21 10:26
 * Description: 系统工具类
 */
public class SystemInfoUtil {

    public static PhoneInfo getPhoneInfo(Context context) {
        PhoneInfo phoneInfo = new PhoneInfo();
        String phoneBrand = Build.BRAND + " " + Build.MODEL;
        String systemType = "android";
        String systemVersion = Build.VERSION.RELEASE;
        String cpuInfo;
        if (Build.VERSION.SDK_INT >= 21)
            cpuInfo = Arrays.toString(Build.SUPPORTED_ABIS);
        else
            cpuInfo = Build.CPU_ABI;
        String appName = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
        String appVersion = "Unknow";
        try {
            appVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        String country = Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry().toLowerCase();
        String timeZone = TimeZone.getDefault().getDisplayName(false, TimeZone.SHORT, Locale.ENGLISH);
        try {
            if (timeZone.contains("+")) {
                timeZone = Integer.valueOf(timeZone.split("\\+")[1].split(":")[0]).toString();
            } else if (timeZone.contains("-")) {
                timeZone = Integer.valueOf(timeZone.split("-")[1].split(":")[0]).toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String phoneImei = "Unknow";//暂时不用
       /* TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager != null) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    phoneImei = telephonyManager.getImei();
                    if (TextUtils.isEmpty(phoneImei)) {
                        phoneImei = telephonyManager.getMeid();
                    }
                } else
                    phoneImei = telephonyManager.getDeviceId();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        phoneInfo.setPhoneBrand(phoneBrand);
        phoneInfo.setSystemType(systemType);
        phoneInfo.setSystemVersion(systemVersion);
        phoneInfo.setCpuInfo(cpuInfo);
        phoneInfo.setAppName(appName);
        phoneInfo.setAppVersion(appVersion);
        phoneInfo.setCountry(country);
        phoneInfo.setTimeZone(timeZone);
        phoneInfo.setPhoneImei(phoneImei);
        return phoneInfo;
    }
}
