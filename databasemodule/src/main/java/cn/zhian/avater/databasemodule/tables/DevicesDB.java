package cn.zhian.avater.databasemodule.tables;

import org.litepal.crud.LitePalSupport;

/**
 * Date：2020/3/4
 * Author:Avater
 * Description:
 */
public class DevicesDB extends LitePalSupport {
    private int id;
    private String mobile;
    private int customerId;
    private long deviceId;//设备ID
    private int roomId;//所属房间ID
    private String deviceName;//设备名称
    private String picUrl;//设备图片地址

    public DevicesDB() {
    }

    public DevicesDB(String mobile, int customerId, long deviceId, int roomId, String deviceName) {
        this.mobile = mobile;
        this.customerId = customerId;
        this.deviceId = deviceId;
        this.roomId = roomId;
        this.deviceName = deviceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return "DevicesDB{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", customerId=" + customerId +
                ", deviceId=" + deviceId +
                ", roomId=" + roomId +
                ", deviceName='" + deviceName + '\'' +
                ", picUrl='" + picUrl + '\'' +
                '}';
    }
}
