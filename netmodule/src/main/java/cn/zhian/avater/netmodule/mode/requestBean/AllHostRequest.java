package cn.zhian.avater.netmodule.mode.requestBean;

import cn.zhian.avater.netmodule.mode.base.BaseRequest;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-14 14:41
 * @Description:
 */
public class AllHostRequest extends BaseRequest {
    public String hostName;
    public String hostId;

    public AllHostRequest(String hostName, String hostId) {
        this.hostName = hostName;
        this.hostId = hostId;
    }
}
