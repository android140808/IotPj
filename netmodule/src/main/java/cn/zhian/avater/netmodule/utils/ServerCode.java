package cn.zhian.avater.netmodule.utils;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-08 11:14
 * @Description:
 */
public class ServerCode {

    public static final int RESPONSE_SUCCESS = 0;

    public static final int RESPONSE_TOKEN_DENY = 1;//当前Token与账号不匹配
    public static final int RESPONSE_TOKEN_EXPIRED = 2;//Token 过期
    public static final int RESPONSE_TOKEN_INVALID = 3;//Token 无效
    public static final int RESPONSE_TOKEN_ENPTY = 4;//Token 为空

    public static final int RESPONSE_SERVER_ERROR = 5;//服务器异常


}
