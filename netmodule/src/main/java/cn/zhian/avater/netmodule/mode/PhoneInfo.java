package cn.zhian.avater.netmodule.mode;

/**
 * Author: Avater
 * Time: 2019/3/21 12:51
 * Description: 手机信息
 */
public class PhoneInfo {
    private String phoneBrand;
    private String systemType;
    private String systemVersion;
    private String cpuInfo = "";
    private String appName = "";
    private String appVersion = "";
    private String country;
    private String timeZone;
    private String phoneImei = "";

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public void setPhoneBrand(String phoneBrand) {
        this.phoneBrand = phoneBrand;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getCpuInfo() {
        return cpuInfo;
    }

    public void setCpuInfo(String cpuInfo) {
        this.cpuInfo = cpuInfo;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getPhoneImei() {
        return phoneImei;
    }

    public void setPhoneImei(String phoneImei) {
        this.phoneImei = phoneImei;
    }

    @Override
    public String toString() {
        return "PhoneInfo{" +
                "phoneBrand='" + phoneBrand + '\'' +
                ", systemType='" + systemType + '\'' +
                ", systemVersion='" + systemVersion + '\'' +
                ", cpuInfo='" + cpuInfo + '\'' +
                ", appName='" + appName + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", country='" + country + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", phoneImei='" + phoneImei + '\'' +
                '}';
    }
}
