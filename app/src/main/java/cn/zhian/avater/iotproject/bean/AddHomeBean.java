package cn.zhian.avater.iotproject.bean;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-26 11:55
 * @Description:
 */
public class AddHomeBean {
    private int iconId;
    private String name;
    private boolean isSelect = false;
    private int roomId;

    public AddHomeBean() {
    }


    public AddHomeBean(int iconId, String name, int roomId) {
        this.iconId = iconId;
        this.name = name;
        this.roomId = roomId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public void setName(String name) {
        this.name = name;
    }

}
