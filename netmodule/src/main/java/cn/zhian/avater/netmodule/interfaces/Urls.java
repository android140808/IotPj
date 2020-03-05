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

    String SMS_SEND = "/api/v1/login/sendSms";
    String LOGIN_PASSWORD = "api/v1/login";
    //    String LOGIN_SMS = "api/v1/login/sms";
    String LOGIN_SMS = "api/v1/login/mobile";
    String LOGIN_WECHAT = "api/v1/login/weChat";
    String LOGOUT = "api/v1/logout";

    String USERINFO = "api/v1/user/info";
    String USERINFO_EDIT = "api/v1/user/info/edit";
    String PASSWORD_SEND_SMS = "api/v1/user/pwd/sendSms";
    String PASSWORD_SET = "api/v1/user/pwd/set";
    String PASSWORD_UPDATE = "api/v1/user/pwd/update";
    String REFRESH_TOKEN = "api/v1/user/token/refresh";

    String MESSAGE_SECURITY = "api/v1/securityMessages";
    String MESSAGE_SECURITY_STATE = "api/v1/securityMessage";
    String MESSAGE_PUSH = "api/v1/pushMessages";
    String MESSAGE_PUSH_STATE = "api/v1/pushMessage";
    String MESSAGE_ENVIRONMENT = "api/v1/environmentMessages";
    String MESSAGE_ENVIRONMENT_STATE = "api/v1/environmentMessage";

    String CONTROL_ADD_ROOM = "api/v1/organization/chamber";
    String CONTROL_GET_ALL_ROOM = "api/v1/organization/customer_id";
    String CONTROL_DEL_ROOM = "api/v1/organization/chamber";
    String CONTROL_ADD_DEVICE = "api/v1/organization/device";
    String CONTROL_DEL_DEVICE = "api/v1/organization/device_id";
    String CONTROL_ROOM_DEVICES = "api/v1/organization/chamber_id";
    String CONTROL_ALL_LIST_DEVICE = "api/v1/organization/device_list";
    String CONTROL_SEARCH_DEVICE = "api/v1/organization/device_name";


}
