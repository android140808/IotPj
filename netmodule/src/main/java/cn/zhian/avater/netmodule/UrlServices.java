package cn.zhian.avater.netmodule;

import cn.zhian.avater.netmodule.interfaces.Urls;
import cn.zhian.avater.netmodule.mode.requestBean.AllHostRequest;
import cn.zhian.avater.netmodule.mode.requestBean.LoginRequest;
import cn.zhian.avater.netmodule.mode.responseBean.AllHostResponse;
import cn.zhian.avater.netmodule.mode.responseBean.LoginResponse;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
    Observable<LoginResponse> logout(@Body LoginRequest request);

    @GET(Urls.USERINFO)
    Observable<LoginResponse> getUserInfo();

    @POST(Urls.SMS_SEND)
    Observable<AllHostResponse> getAllHost(@Body AllHostRequest request);
}
