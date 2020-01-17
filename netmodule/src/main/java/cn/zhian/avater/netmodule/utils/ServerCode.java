package cn.zhian.avater.netmodule.utils;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-08 11:14
 * @Description:
 */
public class ServerCode {

    public static final int RESPONSE_SUCCESS = 0;//成功返回状态，对应，GET、POST、PUT、DEL

    public static final int RESPONSE_TOKEN_DENY = 1;//当前Token与账号不匹配
    public static final int RESPONSE_TOKEN_EXPIRED = 2;//Token 过期
    public static final int RESPONSE_TOKEN_INVALID = 3;//Token 无效
    public static final int RESPONSE_TOKEN_ENPTY = 4;//Token 为空

    public static final int RESPONSE_CREATE = 201;//成功创建
    public static final int RESPONSE_NOT_MODIFIED = 304;//HTTP缓存有效
    public static final int RESPONSE_BAD_REQUEST = 400;//请求格式错误
    public static final int RESPONSE_UNAUTHORIZED = 401;//未授权
    public static final int RESPONSE_FORBIDDEN = 403;//鉴权成功，但是该⽤户没有权限
    public static final int RESPONSE_NOT_FOUND = 404;//请求的资源不存在
    public static final int RESPONSE_METHID_NOT_ALLOT = 405;//该http⽅法不被允许
    public static final int RESPONSE_GONE = 410;//这个url对应的资源现在不可⽤
    public static final int RESPONSE_UNSUPPORTED_MEDIA_TYPE = 415;//请求类型错误
    public static final int RESPONSE_UNPROCESSABLE_ENTITY = 422;//校验错误时⽤
    public static final int RESPONSE_TOO_MANY_REQUEST = 429;//请求过多

    public static final int RESPONSE_SERVER_ERROR = 5;//服务器异常


}
