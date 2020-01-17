package cn.zhian.avater.iotproject.eventbus;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-15 10:14
 * @Description:
 */
public class WeChatLoginBus {
    public WXBaseRespEntity respEntity;
    public String msg;

    public WeChatLoginBus(WXBaseRespEntity respEntity, String msg) {
        this.respEntity = respEntity;
        this.msg = msg;
    }
}
