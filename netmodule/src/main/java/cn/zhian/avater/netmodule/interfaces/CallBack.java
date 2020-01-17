package cn.zhian.avater.netmodule.interfaces;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-13 11:47
 * @Description:
 */
public interface CallBack {

    void onSuccess(String deviceName, String mac);

    void onFailed(String deviceName, String mac);

    void onTiemOut(String deviceName, String mac);

}
