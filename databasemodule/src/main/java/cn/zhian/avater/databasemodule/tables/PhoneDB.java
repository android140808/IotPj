package cn.zhian.avater.databasemodule.tables;

import org.litepal.crud.LitePalSupport;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-21 9:28
 * @Description:
 */
public class PhoneDB extends LitePalSupport {
    private int id;
    private String phoneNumber;
    private String password;

    public PhoneDB() {
    }

    public PhoneDB(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PhoneDB{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
