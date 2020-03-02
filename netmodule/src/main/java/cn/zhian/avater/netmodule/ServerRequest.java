package cn.zhian.avater.netmodule;

import cn.zhian.avater.netmodule.interfaces.NetResultCallBack;
import cn.zhian.avater.netmodule.mode.base.BaseResponse;
import cn.zhian.avater.netmodule.mode.requestBean.AccountRequest;
import cn.zhian.avater.netmodule.mode.requestBean.AllHostRequest;
import cn.zhian.avater.netmodule.mode.requestBean.LoginHeaders;
import cn.zhian.avater.netmodule.mode.requestBean.LoginRequest;
import cn.zhian.avater.netmodule.mode.responseBean.AccountResponse;
import cn.zhian.avater.netmodule.mode.responseBean.CommMessageResponse;
import cn.zhian.avater.netmodule.utils.ServerCode;
import cn.zhian.avater.netmodule.utils.ServerRequestManager;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-08 10:14
 * @Description: 网络请求入口
 */
public enum ServerRequest {
    INSTANCE;

    /*--------------------------------------------------------基本配置-------------------------------------------------------*/
    private static final String TAG = ServerRequest.class.getName();
    private UrlServices urlServices;

    ServerRequest() {
        urlServices = ServerManager.getInstance().getUrlServices();
    }

    // 使用rxJava处理响应结果
    private void rxJavaProCallBack(String seq, Observable observable, NetResultCallBack callBack) {
        rxJavaProCallBack(seq, observable, false, callBack);
    }

    private void rxJavaProCallBack(String seq, Observable observable, boolean isSync, NetResultCallBack callBack) {
        ServerRequestManager.INSTANCE.add(
                seq,
                observable
                        .subscribeOn(isSync ? Schedulers.immediate() : Schedulers.io())
                        .observeOn(isSync ? Schedulers.immediate() : AndroidSchedulers.mainThread())
                        .subscribe(responseSuccessObserver(callBack), responseFailObserver(callBack))
        );
    }

    private Action1<BaseResponse> responseSuccessObserver(final NetResultCallBack callBack) {
        return (base) -> {
            if (null != base) {
                int code = base.code;
                ServerRequestManager.INSTANCE.remove(base.seq);
                try {
                    switch (code) {
                        case ServerCode.RESPONSE_SUCCESS:
                            callBack.onSuccess(code, base);
                            break;
                        case ServerCode.RESPONSE_TOKEN_DENY:
                        case ServerCode.RESPONSE_TOKEN_EXPIRED:
                        case ServerCode.RESPONSE_TOKEN_INVALID:
                        case ServerCode.RESPONSE_TOKEN_ENPTY:
                            callBack.onFail(ServerCode.RESPONSE_TOKEN_INVALID);
                            break;
                        case ServerCode.RESPONSE_SERVER_ERROR:
                            callBack.onFail(ServerCode.RESPONSE_SERVER_ERROR);
                            break;

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private Action1<Throwable> responseFailObserver(final NetResultCallBack callBack) {
        return throwable -> callBack.onFail(ServerCode.RESPONSE_SERVER_ERROR);
    }

    // 取消指定请求
    public void cancelRequest(String seq) {
        ServerRequestManager.INSTANCE.cancelRequest(seq);
    }

    // 取消所有请求
    public void cancelAllRequest() {
        ServerRequestManager.INSTANCE.cancelAllRequest();
    }

    /*--------------------------------------------------------基本配置-------------------------------------------------------*/


    /*--------------------------------------------------------业务逻辑-------------------------------------------------------------*/

    /**
     * 短信验证码登录
     *
     * @param loginRequest
     * @param callBack
     */
    public void loginWithSmsCode(LoginRequest loginRequest, NetResultCallBack callBack, LoginHeaders headers) {
        rxJavaProCallBack(
                loginRequest.seq,
                urlServices.loginWithSmsCode(loginRequest, headers.country, headers.phoneBrand, headers.systemType, headers.systemVersion, headers.appVersion),
                callBack
        );
    }

    /**
     * 账号密码登录
     *
     * @param loginRequest
     * @param callBack
     */
    public void loginWithPassword(LoginRequest loginRequest, NetResultCallBack callBack) {
        rxJavaProCallBack(
                loginRequest.seq,
                urlServices.loginWithPassword(loginRequest),
                callBack
        );
    }


    public void logout(NetResultCallBack callBack) {
        rxJavaProCallBack(
                "",
                urlServices.logout(),
                callBack
        );
    }

    /**
     * 获取短信验证码
     *
     * @param loginRequest
     * @param callBack
     */
    public void getSmsCode(LoginRequest loginRequest, NetResultCallBack<BaseResponse> callBack) {
        rxJavaProCallBack(loginRequest.seq, urlServices.getSmsCode(loginRequest), false, callBack);
    }

    /**
     * 获取用户信息
     *
     * @param callBack
     */
    public void getUserInfo(NetResultCallBack<AccountResponse> callBack) {
        rxJavaProCallBack("请求用户信息", urlServices.getUserInfo(), callBack);
    }

    /**
     * 获取安防消息
     *
     * @param currentPage
     * @param pageSize
     * @param callBack
     */
    public void getMessageSecurity(int currentPage, int pageSize, NetResultCallBack<CommMessageResponse> callBack) {
        rxJavaProCallBack("", urlServices.getMessageSecurity(currentPage, pageSize), false, callBack);
    }

    /**
     * 设置安防消息的状态
     *
     * @param id
     * @param action
     * @param callBack
     */
    public void setMessageSecurityState(int id, String action, NetResultCallBack<BaseResponse> callBack) {
        rxJavaProCallBack("", urlServices.setMessageSecurityState(id, action), false, callBack);
    }

    /**
     * 获取推送消息
     *
     * @param currentPage
     * @param pageSize
     * @param callBack
     */
    public void getMessagePush(int currentPage, int pageSize, NetResultCallBack<CommMessageResponse> callBack) {
        rxJavaProCallBack("", urlServices.getMessagePush(currentPage, pageSize), false, callBack);
    }

    /**
     * 设置推送消息的状态
     *
     * @param id
     * @param action
     * @param callBack
     */
    public void setMessagePushState(int id, String action, NetResultCallBack<BaseResponse> callBack) {
        rxJavaProCallBack("", urlServices.setMessagePushState(id, action), false, callBack);
    }

    /**
     * 获取环境消息
     *
     * @param currentPage
     * @param pageSize
     * @param callBack
     */
    public void getMessageEnvironment(int currentPage, int pageSize, NetResultCallBack<CommMessageResponse> callBack) {
        rxJavaProCallBack("", urlServices.getMessageEnvironment(currentPage, pageSize), false, callBack);
    }

    /**
     * 设置环境消息状态
     *
     * @param id
     * @param action
     * @param callBack
     */
    public void setMessageEnvironmentState(int id, String action, NetResultCallBack<BaseResponse> callBack) {
        rxJavaProCallBack("", urlServices.setMessageEnvironmentState(id, action), false, callBack);
    }

    public void getAllHost(AllHostRequest allHostRequest, NetResultCallBack callBack) {

    }

    public void edidPerson(AccountRequest request, NetResultCallBack<BaseResponse> callBack) {
        rxJavaProCallBack("编辑个人信息", urlServices.editPerson(request), callBack);
    }


}
