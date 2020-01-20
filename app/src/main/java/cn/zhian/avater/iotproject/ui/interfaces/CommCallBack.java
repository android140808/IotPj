package cn.zhian.avater.iotproject.ui.interfaces;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-20 8:47
 * @Description:
 */
public interface CommCallBack {
    /**
     * @param code >=0 success ,<0 failed
     */
    void onCallBack(int code);
}
