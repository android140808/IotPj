package cn.zhian.avater.databasemodule.tables;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-21 9:30
 * @Description: 用户数据表
 */
public class AccountDB extends LitePalSupport {
    private int id;
    //唯一约束
    @Column(unique = true)
    private String phoneNumber;
    private String niceName;
    private String iconPath;
    private String token;

    public AccountDB() {
    }

    public AccountDB(String phoneNumber, String niceName, String iconPath, String token) {
        this.phoneNumber = phoneNumber;
        this.niceName = niceName;
        this.iconPath = iconPath;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
        return "AccountDB{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", niceName='" + niceName + '\'' +
                ", iconPath='" + iconPath + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
