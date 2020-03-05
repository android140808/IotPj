package cn.zhian.avater.databasemodule.tables;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

/**
 * Date：2020/3/4
 * Author:Avater
 * Description:
 */
public class RoomDB extends LitePalSupport {
    private int id;
    private String mobile;
    private long customerId;
    private String roomName;
    @Column(unique = true)//唯一性约束
    private long roomId;
    private int deviceCount;
    private int chamIdentifier;//本地图片ID编号

    private String sensor;//传感器
    private String switchOffOn;//灯光开关
    private String electtical;//家电

    public RoomDB() {
    }

    public RoomDB(String mobile, long customerId, String roomName, int deviceCount, int chamIdentifier, long roomId) {
        this.mobile = mobile;
        this.customerId = customerId;
        this.roomName = roomName;
        this.deviceCount = deviceCount;
        this.chamIdentifier = chamIdentifier;
        this.roomId = roomId;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getSwitchOffOn() {
        return switchOffOn;
    }

    public void setSwitchOffOn(String switchOffOn) {
        this.switchOffOn = switchOffOn;
    }

    public String getElecttical() {
        return electtical;
    }

    public void setElecttical(String electtical) {
        this.electtical = electtical;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public int getChamIdentifier() {
        return chamIdentifier;
    }

    public void setChamIdentifier(int chamIdentifier) {
        this.chamIdentifier = chamIdentifier;
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

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(int deviceCount) {
        this.deviceCount = deviceCount;
    }


    @Override
    public String toString() {
        return "RoomDB{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", customerId=" + customerId +
                ", roomName='" + roomName + '\'' +
                ", roomId=" + roomId +
                ", deviceCount=" + deviceCount +
                ", chamIdentifier=" + chamIdentifier +
                ", sensor='" + sensor + '\'' +
                ", switchOffOn='" + switchOffOn + '\'' +
                ", electtical='" + electtical + '\'' +
                '}';
    }
}
