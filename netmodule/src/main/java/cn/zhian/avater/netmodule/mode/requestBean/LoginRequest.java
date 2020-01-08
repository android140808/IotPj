package cn.zhian.avater.netmodule.mode.requestBean;

import cn.zhian.avater.netmodule.mode.base.BaseRequest;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-08 15:46
 * @Description:
 */
public class LoginRequest extends BaseRequest {
    public String phoneNumber;
    public String code;

    public LoginRequest(String phoneNumber, String code) {
        this.phoneNumber = phoneNumber;
        this.code = code;
    }
}
