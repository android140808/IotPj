package cn.zhian.avater.iotproject.bean;

import android.graphics.Bitmap;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-25 17:08
 * @Description:
 */
public class RightBean {
    private Bitmap bitmap;
    private String deviceName;

    public RightBean() {
    }

    public RightBean(Bitmap bitmap, String deviceName) {
        this.bitmap = bitmap;
        this.deviceName = deviceName;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public String toString() {
        return "RightBean{" +
                "bitmap=" + bitmap +
                ", deviceName='" + deviceName + '\'' +
                '}';
    }
}
