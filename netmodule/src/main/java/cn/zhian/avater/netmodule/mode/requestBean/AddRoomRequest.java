package cn.zhian.avater.netmodule.mode.requestBean;


import cn.zhian.avater.netmodule.mode.base.BaseRequest;

/**
 * Date：2020/3/3
 * Author:Avater
 * Description:
 */
public class AddRoomRequest extends BaseRequest {
    private String name;
    private long customerId;
    private int chamIdentifier;

    public AddRoomRequest(String name, long customerId, int chamIdentifier) {
        this.name = name;
        this.customerId = customerId;
        this.chamIdentifier = chamIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public int getChamIdentifier() {
        return chamIdentifier;
    }

    public void setChamIdentifier(int chamIdentifier) {
        this.chamIdentifier = chamIdentifier;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
