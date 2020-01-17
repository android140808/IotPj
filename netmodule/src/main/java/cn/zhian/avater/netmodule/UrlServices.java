package cn.zhian.avater.netmodule;

import cn.zhian.avater.netmodule.interfaces.Urls;
import cn.zhian.avater.netmodule.mode.requestBean.AllHostRequest;
import cn.zhian.avater.netmodule.mode.requestBean.LoginRequest;
import cn.zhian.avater.netmodule.mode.responseBean.AllHostResponse;
import cn.zhian.avater.netmodule.mode.responseBean.LoginResponse;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-20 15:56
 * @Description:
 */
public interface UrlServices {

    @POST(Urls.LOGIN_CODE)
    Observable<LoginResponse> Login(@Body LoginRequest request);

    @FormUrlEncoded
    @POST(Urls.GET_SMS_CODE)
    Observable<LoginResponse> getSmsCode(@Field("mobile") String phoneNumber);

    @POST(Urls.LOGIN_CODE)
    Observable<AllHostResponse> getAllHost(@Body AllHostRequest request);
}
