package cn.zhian.avater.netmodule;

import java.util.List;

import cn.zhian.avater.netmodule.interfaces.Urls;
import cn.zhian.avater.netmodule.mode.base.BaseResponse;
import cn.zhian.avater.netmodule.mode.requestBean.AccountRequest;
import cn.zhian.avater.netmodule.mode.requestBean.AddDeviceRequest;
import cn.zhian.avater.netmodule.mode.requestBean.AllHostRequest;
import cn.zhian.avater.netmodule.mode.requestBean.DelRoomOrDeviceRequest;
import cn.zhian.avater.netmodule.mode.requestBean.GetAllRoomAndDevicesRequest;
import cn.zhian.avater.netmodule.mode.requestBean.GetRoomDataRequest;
import cn.zhian.avater.netmodule.mode.requestBean.LoginRequest;
import cn.zhian.avater.netmodule.mode.requestBean.SearchDeviceRequest;
import cn.zhian.avater.netmodule.mode.responseBean.AccountResponse;
import cn.zhian.avater.netmodule.mode.responseBean.AllHostResponse;
import cn.zhian.avater.netmodule.mode.responseBean.AllRoomAndDevicesResponse;
import cn.zhian.avater.netmodule.mode.responseBean.CommMessageResponse;
import cn.zhian.avater.netmodule.mode.responseBean.GetAllRoomAndDevicesResponse;
import cn.zhian.avater.netmodule.mode.responseBean.LoginResponse;
import cn.zhian.avater.netmodule.mode.responseBean.SearchDeviceResponse;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
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
    Observable<LoginResponse> loginWithSmsCode(@Body LoginRequest request,
                                               @Header("country") String country,
                                               @Header("phoneBrand") String phoneBrand,
                                               @Header("systemType") String systemType,
                                               @Header("systemVersion") String systemVersion,
                                               @Header("appVersion") String appVersion);

    @POST(Urls.LOGIN_PASSWORD)
    Observable<LoginResponse> loginWithPassword(@Body LoginRequest request);

    @GET(Urls.LOGOUT)
    Observable<LoginResponse> logout();

    @GET(Urls.USERINFO)
    Observable<AccountResponse> getUserInfo();

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

    @PATCH(Urls.USERINFO_EDIT)
    Observable<BaseResponse> editPerson(@Body AccountRequest request);


    @Multipart
    @POST(Urls.CONTROL_ADD_ROOM)
    Observable<BaseResponse> addRoom(@Part MultipartBody.Part imagePart, @Part("name") String name, @Part("customerId") long customerId);

    @Multipart
    @POST(Urls.CONTROL_ADD_ROOM)
    Observable<BaseResponse> addRoom1(@Part List<MultipartBody.Part> list);


    @POST(Urls.CONTROL_GET_ALL_ROOM)
    Observable<GetAllRoomAndDevicesResponse> getAllRoomsAndDevices(@Body GetAllRoomAndDevicesRequest request);

    @HTTP(method = "DELETE", path = Urls.CONTROL_DEL_ROOM, hasBody = true)
    Observable<BaseResponse> delRoom(@Body DelRoomOrDeviceRequest request);

    @POST(Urls.CONTROL_ADD_DEVICE)
    Observable<BaseResponse> addDevice(@Body AddDeviceRequest request);

    @POST(Urls.CONTROL_ROOM_DEVICES)
    Observable<BaseResponse> getRoomData(@Body GetRoomDataRequest request);

    @HTTP(method = "DELETE", path = Urls.CONTROL_DEL_DEVICE, hasBody = true)
    Observable<BaseResponse> delDevice(@Body DelRoomOrDeviceRequest request);

    @GET(Urls.CONTROL_ALL_LIST_DEVICE)
    Observable<AllRoomAndDevicesResponse> getAllProducts();

    @POST(Urls.CONTROL_SEARCH_DEVICE)
    Observable<SearchDeviceResponse> searchDevice(@Body SearchDeviceRequest name);


}
