package cn.zhian.avater.netmodule.mode.responseBean;

import cn.zhian.avater.netmodule.mode.base.BaseResponse;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-08 16:00
 * @Description:
 */
public class LoginResponse extends BaseResponse {

    public DataBean data;

    public static class DataBean {
        public String token;
    }
//    public String accessToken;

}
