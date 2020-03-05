package cn.zhian.avater.netmodule.mode.requestBean;

import cn.zhian.avater.netmodule.mode.base.BaseRequest;

/**
 * Date：2020/3/3
 * Author:Avater
 * Description:
 */
public class DelRoomOrDeviceRequest extends BaseRequest {
    private long id;

    public DelRoomOrDeviceRequest(long id) {
        this.id = id;
    }

    public DelRoomOrDeviceRequest() {
    }

    @Override
    public String toString() {
        return "DelRoomOrDeviceRequest{" +
                "id=" + id +
                ", seq='" + seq + '\'' +
                ", versionNo='" + versionNo + '\'' +
                ", clientType='" + clientType + '\'' +
                ", customerCode='" + customerCode + '\'' +
                '}';
    }
}
