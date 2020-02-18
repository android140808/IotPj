package cn.zhian.avater.netmodule;

import cn.zhian.avater.netmodule.interfaces.Urls;
import cn.zhian.avater.netmodule.mode.base.BaseResponse;
import cn.zhian.avater.netmodule.mode.requestBean.AllHostRequest;
import cn.zhian.avater.netmodule.mode.requestBean.LoginRequest;
import cn.zhian.avater.netmodule.mode.responseBean.AllHostResponse;
import cn.zhian.avater.netmodule.mode.responseBean.CommMessageResponse;
import cn.zhian.avater.netmodule.mode.responseBean.LoginResponse;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-20 15:56
 * @Description:
 */
public interface UrlServices {

    @POST(Urls.SMS_SEND)
    Observable<LoginResponse> getSmsCode(@Body LoginRequest phoneNumber);

    @POST(Urls.LOGIN_SMS)
    Observable<LoginResponse> loginWithSmsCode(@Body LoginRequest request);

    @POST(Urls.LOGIN_PASSWORD)
    Observable<LoginResponse> loginWithPassword(@Body LoginRequest request);

    @POST(Urls.LOGOUT)
    Observable<LoginResponse> logout();

    @GET(Urls.USERINFO)
    Observable<LoginResponse> getUserInfo();

    @POST(Urls.SMS_SEND)
    Observable<AllHostResponse> getAllHost(@Body AllHostRequest request);

    @GET(Urls.MESSAGE_SECURITY)
    Observable<CommMessageResponse> getMessageSecurity(@Query("currentPage") int currentPage, @Query("pageSize") int pageSize);

    @PATCH(Urls.MESSAGE_SECURITY_STATE + "/{id}/{action}/update")
    Observable<BaseResponse> setMessageSecurityState(@Path("id") int id, @Path("action") String action);

    @GET(Urls.MESSAGE_PUSH)
    Observable<CommMessageResponse> getMessagePush(@Query("currentPage") int currentPage, @Query("pageSize") int pageSize);

    @PATCH(Urls.MESSAGE_PUSH_STATE + "/{id}/{action}/update")
    Observable<BaseResponse> setMessagePushState(@Path("id") int id, @Path("action") String action);

    @GET(Urls.MESSAGE_ENVIRONMENT)
    Observable<CommMessageResponse> getMessageEnvironment(@Query("currentPage") int currentPage, @Query("pageSize") int pageSize);

    @PATCH(Urls.MESSAGE_ENVIRONMENT_STATE + "/{id}/{action}/update")
    Observable<BaseResponse> setMessageEnvironmentState(@Path("id") int id, @Path("action") String action);

}
