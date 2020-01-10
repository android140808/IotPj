package cn.zhian.avater.databasemodule;


import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;

import org.litepal.LitePal;

import java.util.List;

import cn.zhian.avater.databasemodule.tables.AccountDB;
import cn.zhian.avater.databasemodule.tables.MessageDB;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-09 9:47
 * @Description:
 */
public enum MDB {
    INSTANCE;
    private final static String TAG = MDB.class.getName();

    /**
     * 保存数据
     *
     * @param accountDB
     */
    public void saveAccount(AccountDB accountDB) {
        if (null == accountDB) {
            return;
        }
        boolean save = accountDB.save();
        Log.e("TAG", (save ? "保存成功" : "保存失败"));
        if (!save) {
            Log.e("TAG", "更新数据");
            ContentValues values = new ContentValues();
            values.put("niceName", accountDB.getNiceName());
            values.put("iconPath", accountDB.getIconPath());
            values.put("token", accountDB.getToken());
            updateAccount(values);
        }
    }

    /**
     * 获取指定账号信息
     *
     * @param phoneNumber
     * @return
     */
    public AccountDB getAccount(String phoneNumber) {
        if (TextUtils.isEmpty(phoneNumber)) {
            return null;
        }
        List<AccountDB> dbs = LitePal.where("phoneNumber = ? ", phoneNumber).find(AccountDB.class);
        if (null != dbs && dbs.size() > 0) {
            return dbs.get(0);
        }
        return null;
    }

    /**
     * 更新数据
     *
     * @param values
     */
    public void updateAccount(ContentValues values) {
        if (values == null) {
            return;
        }
        LitePal.updateAll(AccountDB.class, values);
    }

    /**
     * 删除所有的用户数据
     */
    public void deleteAllAcount() {
        LitePal.deleteAll(AccountDB.class);
    }

    public void saveMessage(List<MessageDB> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        LitePal.saveAll(list);
    }


    public List<MessageDB> getAllMessageUnReadType(String phoneNumber, int messageType) {
        if (TextUtils.isEmpty(phoneNumber)) {
            return null;
        }
        if (messageType < 1 || messageType > 3) {
            Log.e("TAG", "messageType is no exist!Please check!");
            return null;
        }
        List<MessageDB> messageDBS = LitePal.where("phoneNumber = ? and isRead = ? and messageType = ? ", phoneNumber, String.valueOf(-1), String.valueOf(messageType)).find(MessageDB.class);
        return messageDBS;
    }

    public void updateMessageDB(ContentValues values) {
        if (null == values) {
            return;
        }
        LitePal.updateAll(MessageDB.class, values);
    }

    public void deleteAllMessageDB() {
        LitePal.deleteAll(MessageDB.class);
    }
}
