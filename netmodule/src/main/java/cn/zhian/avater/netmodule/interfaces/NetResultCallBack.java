package cn.zhian.avater.netmodule.interfaces;

import cn.zhian.avater.netmodule.mode.base.BaseResponse;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-08 10:26
 * @Description: 网络请求返回基类
 */
public interface NetResultCallBack<T extends BaseResponse> {
    /**
     * 请求成功返回的结果
     *
     * @param responseCode 响应码
     * @param response     响应体 泛型
     */
    void onSuccess(int responseCode, T response);

    /**
     * 请求失败
     *
     * @param responseCode 响应码
     */
    void onFail(int responseCode);
}
