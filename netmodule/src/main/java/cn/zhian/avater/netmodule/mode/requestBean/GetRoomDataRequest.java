package cn.zhian.avater.netmodule.mode.requestBean;

import cn.zhian.avater.netmodule.mode.base.BaseRequest;

/**
 * Date：2020/3/3
 * Author:Avater
 * Description:
 */
public class GetRoomDataRequest extends BaseRequest {
    private long id;//房间ID

    public GetRoomDataRequest(long id) {
        this.id = id;
    }

    public GetRoomDataRequest() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GetRoomDataRequest{" +
                "id=" + id +
                ", seq='" + seq + '\'' +
                ", versionNo='" + versionNo + '\'' +
                ", clientType='" + clientType + '\'' +
                ", customerCode='" + customerCode + '\'' +
                '}';
    }
}
