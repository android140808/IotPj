package cn.zhian.avater.iotproject.bean;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-18 17:55
 * @Description:
 */
public class ControlBean {
    private int deviceTotalCount;
    private String roomType;
    private int roomResId;
    private String security;
    private int securityCount;
    private String light;
    private int lightCount;
    private String environment;
    private int environmentCount;

    public ControlBean() {
    }

    public ControlBean(int deviceTotalCount, String roomType, int resId, String security, int securityCount, String light, int lightCount, String environment, int environmentCount) {
        this.deviceTotalCount = deviceTotalCount;
        this.roomType = roomType;
        roomResId = resId;
        this.security = security;
        this.securityCount = securityCount;
        this.light = light;
        this.lightCount = lightCount;
        this.environment = environment;
        this.environmentCount = environmentCount;
    }

    public int getDeviceTotalCount() {
        return deviceTotalCount;
    }

    public void setDeviceTotalCount(int deviceTotalCount) {
        this.deviceTotalCount = deviceTotalCount;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public int getSecurityCount() {
        return securityCount;
    }

    public void setSecurityCount(int securityCount) {
        this.securityCount = securityCount;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public int getLightCount() {
        return lightCount;
    }

    public void setLightCount(int lightCount) {
        this.lightCount = lightCount;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public int getEnvironmentCount() {
        return environmentCount;
    }

    public void setEnvironmentCount(int environmentCount) {
        this.environmentCount = environmentCount;
    }

    public int getRoomResId() {
        return roomResId;
    }

    public void setRoomResId(int roomResId) {
        this.roomResId = roomResId;
    }

    @Override
    public String toString() {
        return "ControlBean{" +
                "deviceTotalCount=" + deviceTotalCount +
                ", roomType='" + roomType + '\'' +
                ", roomResId=" + roomResId +
                ", security='" + security + '\'' +
                ", securityCount=" + securityCount +
                ", light='" + light + '\'' +
                ", lightCount=" + lightCount +
                ", environment='" + environment + '\'' +
                ", environmentCount=" + environmentCount +
                '}';
    }
}
