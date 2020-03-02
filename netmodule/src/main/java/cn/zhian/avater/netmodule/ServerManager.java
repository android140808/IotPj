package cn.zhian.avater.netmodule;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import cn.zhian.avater.netmodule.interfaces.Urls;
import cn.zhian.avater.netmodule.mode.PhoneInfo;
import cn.zhian.avater.netmodule.utils.LogUtil;
import cn.zhian.avater.netmodule.utils.ServerUtil;
import cn.zhian.avater.netmodule.utils.SystemInfoUtil;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 11:25
 * @Description:
 */
public class ServerManager {
    private static ServerManager manager;
    private static String TAG = ServerManager.class.getSimpleName();
    private UrlServices urlServices;
    private OkHttpClient mOkHttpClient;
    private final int CACHE_TIME = 60 * 60 * 24 * 7;                                                // 缓存时间(7天)
    private final int CACHE_SIZE = 1024 * 1024 * 10;                                                // 缓存大小为10M
    private final int CONNECT_TIMEOUT = 60;                                                         // 连接超时60秒


    public static ServerManager getInstance() {
        if (manager == null) {
            synchronized (ServerManager.class) {
                if (manager == null) {
                    manager = new ServerManager();
                }
            }
        }
        return manager;
    }

    private ServerManager() {
        initOkHttpClient();
        initRetrofit();
    }


    // 初始化Retrofit
    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())                                 // 支持Gson
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())                           // 支持RxJava
                .baseUrl("http://" + Urls.HOST)                                                                 // 设置Host
                .build();
        urlServices = retrofit.create(UrlServices.class);
    }

    // 初始化OKHttpClient
    private void initOkHttpClient() {
        if (mOkHttpClient == null) {
            synchronized (ServerManager.class) {
                mOkHttpClient = new OkHttpClient.Builder()
                        .retryOnConnectionFailure(true)                                             // 错误重连
                        .addInterceptor(httpLoggingInterceptor())                                   // 打印日志
                        .addInterceptor(tokenAndSeqInterceptor())                                   // 设置应用拦截器，可用于设置公共参数，头信息，日志拦截等
                        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)                          // 设置连接超时为60秒
                        .readTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)                             // 设置读超时60秒
//                        .socketFactory(getSSLSocketFactory())
//                        .hostnameVerifier(getHostnameVerifier())
                        .build();
            }
        }
    }

    /**
     * 添加公共请求Headers
     *
     * @return
     */
    private Interceptor tokenAndSeqInterceptor() {
        ServerVal.accessToken = TextUtils.isEmpty(ServerVal.accessToken) ? "" : ServerVal.accessToken;
        LogUtil.i(TAG, "当前请求的token ： " + ServerVal.accessToken);
        return chain -> {
            Headers headers = chain.request().headers();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                Log.d(TAG, headers.name(i));
            }
            Request.Builder builder = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("access_token", ServerVal.accessToken);
            Request request = builder.build();
            return chain.proceed(request);
        };
    }

    private HttpLoggingInterceptor httpLoggingInterceptor() {
        return new HttpLoggingInterceptor(message -> Log.d(TAG, message)).setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    public UrlServices getUrlServices() {
        return urlServices;
    }

    private String getEncodeHeader(String value) {
        if (value == null) return "null";
        String newValue = value.replace("\n", "");
        for (int i = 0, length = newValue.length(); i < length; i++) {
            char c = newValue.charAt(i);
            if (c <= '\u001f' || c >= '\u007f') {
                try {
                    return URLEncoder.encode(newValue, "UTF-8");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return "Unknow";
    }
}
