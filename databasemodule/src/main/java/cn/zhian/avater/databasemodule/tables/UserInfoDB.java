package cn.zhian.avater.databasemodule.tables;

import org.litepal.crud.LitePalSupport;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-21 9:30
 * @Description:
 */
public class UserInfoDB extends LitePalSupport {
    private int id;
    private String phoneNumber;
    private String niceName;
    private String iconPath;

    public UserInfoDB() {
    }

    public UserInfoDB(String phoneNumber, String niceName, String iconPath) {
        this.phoneNumber = phoneNumber;
        this.niceName = niceName;
        this.iconPath = iconPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    @Override
    public String toString() {
        return "UserInfoDB{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", niceName='" + niceName + '\'' +
                ", iconPath='" + iconPath + '\'' +
                '}';
    }
}
