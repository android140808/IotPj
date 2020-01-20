package cn.zhian.avater.iotproject.ui.model;

import cn.zhian.avater.databasemodule.MDB;
import cn.zhian.avater.iotproject.base.BaseModel;
import cn.zhian.avater.iotproject.ui.interfaces.CommCallBack;
import cn.zhian.avater.netmodule.ServerRequest;
import cn.zhian.avater.netmodule.interfaces.NetResultCallBack;
import cn.zhian.avater.netmodule.mode.base.BaseResponse;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-19 8:36
 * @Description:
 */
public class SettingModel implements BaseModel {

    public void logout(CommCallBack callBack) {
        ServerRequest.INSTANCE.logout(new NetResultCallBack() {
            @Override
            public void onSuccess(int responseCode, BaseResponse baseResponse) {
                callBack.onCallBack(1);
                MDB.INSTANCE.setToken("");
                MDB.INSTANCE.setCurrentPhoneNumber("");
            }

            @Override
            public void onFail(int responseCode) {
                callBack.onCallBack(1);
                MDB.INSTANCE.setToken("");
                MDB.INSTANCE.setCurrentPhoneNumber("");
            }
        });
    }
}
