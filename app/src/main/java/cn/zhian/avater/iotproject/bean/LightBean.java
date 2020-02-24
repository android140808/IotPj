package cn.zhian.avater.iotproject.bean;

/**
 * @Author: wangweida
 * @CreateDate: 2020-02-24 9:51
 * @Description:
 */
public class LightBean {
    private int id;//设备编号
    private boolean switchState;//开关状态
    private boolean selectState;//选中状态
    private String lightName;//开关别名
    private int hour;
    private int minute;
    private int second;


    public LightBean() {
    }

    public LightBean(int id, boolean switchState, boolean selectState, String lightName, int hour, int minute, int second) {
        this.id = id;
        this.switchState = switchState;
        this.selectState = selectState;
        this.lightName = lightName;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSwitchState() {
        return switchState;
    }

    public void setSwitchState(boolean switchState) {
        this.switchState = switchState;
    }

    public boolean isSelectState() {
        return selectState;
    }

    public void setSelectState(boolean selectState) {
        this.selectState = selectState;
    }

    public String getLightName() {
        return lightName;
    }

    public void setLightName(String lightName) {
        this.lightName = lightName;
    }

    @Override
    public String toString() {
        return "LightBean{" +
                "id=" + id +
                ", switchState=" + switchState +
                ", selectState=" + selectState +
                ", lightName='" + lightName + '\'' +
                '}';
    }
}
