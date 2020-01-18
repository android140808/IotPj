package cn.zhian.avater.netmodule.mode.requestBean;

import cn.zhian.avater.netmodule.mode.base.BaseRequest;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-08 15:46
 * @Description:
 */
public class LoginRequest extends BaseRequest {
    public String mobile;
    public String smsValidCode;

    public LoginRequest(String mobile, String smsValidCode) {
        this.mobile = mobile;
        this.smsValidCode = smsValidCode;
    }
}
