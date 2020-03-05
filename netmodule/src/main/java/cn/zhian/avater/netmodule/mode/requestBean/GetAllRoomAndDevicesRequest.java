package cn.zhian.avater.netmodule.mode.requestBean;

import cn.zhian.avater.netmodule.mode.base.BaseRequest;

/**
 * Date：2020/3/3
 * Author:Avater
 * Description:
 */
public class GetAllRoomAndDevicesRequest extends BaseRequest {
    private long customerId;

    public GetAllRoomAndDevicesRequest(long customerId) {
        this.customerId = customerId;
    }

    public GetAllRoomAndDevicesRequest() {
    }

    @Override
    public String toString() {
        return "GetAllRoomAndDevicesRequest{" +
                "customerId=" + customerId +
                ", seq='" + seq + '\'' +
                ", versionNo='" + versionNo + '\'' +
                ", clientType='" + clientType + '\'' +
                ", customerCode='" + customerCode + '\'' +
                '}';
    }
}
