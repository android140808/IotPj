package cn.zhian.avater.netmodule.mode.requestBean;

/**
 * Date：2020/2/29
 * Author:Avater
 * Description:
 */
public class LoginHeaders {
    public String country = "86";
    public String phoneBrand;
    public String systemType;
    public String systemVersion;
    public String appVersion;

    public LoginHeaders() {
    }

    public LoginHeaders(String phoneBrand, String systemType, String systemVersion, String appVersion) {
        this.phoneBrand = phoneBrand;
        this.systemType = systemType;
        this.systemVersion = systemVersion;
        this.appVersion = appVersion;
    }
}
