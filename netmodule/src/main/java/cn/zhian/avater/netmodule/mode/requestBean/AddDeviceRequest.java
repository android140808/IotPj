package cn.zhian.avater.netmodule.mode.requestBean;

import cn.zhian.avater.netmodule.mode.base.BaseRequest;

/**
 * Date：2020/3/3
 * Author:Avater
 * Description:
 */
public class AddDeviceRequest extends BaseRequest {
    private long chamberId;//房间ID
    private long customerId;//用户id
    private long productId;//产品id
    private String productNick;//产品昵称
    private long isHome;//是否主页 101主页 102非主页

    public AddDeviceRequest(long chamberId, long customerId, long productId, String productNick, long isHome) {
        this.chamberId = chamberId;
        this.customerId = customerId;
        this.productId = productId;
        this.productNick = productNick;
        this.isHome = isHome;
    }

    public AddDeviceRequest() {
    }

    public long getChamberId() {
        return chamberId;
    }

    public void setChamberId(long chamberId) {
        this.chamberId = chamberId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductNick() {
        return productNick;
    }

    public void setProductNick(String productNick) {
        this.productNick = productNick;
    }

    public long getIsHome() {
        return isHome;
    }

    public void setIsHome(long isHome) {
        this.isHome = isHome;
    }

    @Override
    public String toString() {
        return "AddDeviceRequest{" +
                "chamberId=" + chamberId +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", productNick='" + productNick + '\'' +
                ", isHome=" + isHome +
                ", seq='" + seq + '\'' +
                ", versionNo='" + versionNo + '\'' +
                ", clientType='" + clientType + '\'' +
                ", customerCode='" + customerCode + '\'' +
                '}';
    }
}
