package cn.zhian.avater.netmodule.mode.base;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-08 10:30
 * @Description:
 */
public class BaseResponse {
    public String seq;
    public int code;
    public String msg;

    @Override
    public String toString() {
        return "BaseResponse{" +
                "seq='" + seq + '\'' +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
