package cn.zhian.avater.netmodule.interfaces;

import cn.zhian.avater.netmodule.BuildConfig;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-08 14:24
 * @Description: 网络请求借口
 */
public interface Urls {
    String HOST = BuildConfig.HOST_NAME;
    String HOST_LANS = BuildConfig.LANS;

    String GET_SMS_CODE = "/api/v1/oauth/login/sendSms";
    String LOGIN_CODE = "api/v1/oauth/login";
    String LOGIN_WECHAT = "api/v1/oauth/login/weChat";
    String LOGOUT = "api/v1/oauth/logout";


}
