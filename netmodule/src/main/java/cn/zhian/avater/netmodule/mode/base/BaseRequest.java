package cn.zhian.avater.netmodule.mode.base;

import cn.zhian.avater.netmodule.BuildConfig;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-08 11:36
 * @Description:
 */
public class BaseRequest {
    public String seq;
    public String versionNo;//
    public String clientType = "Android";
    public String customerCode;//

    public BaseRequest() {
        seq = String.valueOf(System.currentTimeMillis());
        versionNo = BuildConfig.VERSION_NAME;
        customerCode = "奥园";//后期指定
    }

    @Override
    public String toString() {
        return "BaseRequest{" +
                "seq='" + seq + '\'' +
                ", versionNo='" + versionNo + '\'' +
                ", clientType='" + clientType + '\'' +
                ", customerCode='" + customerCode + '\'' +
                '}';
    }
}
