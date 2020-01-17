package cn.zhian.avater.iotproject.ui.interfaces;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-14 18:12
 * @Description:
 */
public interface WeChatLoginCallBack {
    void loginSuccess(int type, String token, String id, String secret);

    void loginFail();
}
