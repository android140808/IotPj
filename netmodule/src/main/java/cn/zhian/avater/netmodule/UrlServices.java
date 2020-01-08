package cn.zhian.avater.netmodule;

import cn.zhian.avater.netmodule.interfaces.Urls;
import cn.zhian.avater.netmodule.mode.requestBean.LoginRequest;
import cn.zhian.avater.netmodule.mode.responseBean.LoginResponse;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-20 15:56
 * @Description:
 */
public interface UrlServices {
    @POST(Urls.LOGIN)
    Observable<LoginResponse> Login(LoginRequest request);
}
