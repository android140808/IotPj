package cn.zhian.avater.netmodule;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.zhian.avater.netmodule.interfaces.Urls;
import cn.zhian.avater.netmodule.utils.ServerUtil;
import okhttp3.Cache;
import okhttp3.CacheControl;
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
                .baseUrl(Urls.HOST)                                                                 // 设置Host
                .build();
        urlServices = retrofit.create(UrlServices.class);
    }

    // 初始化OKHttpClient
    private void initOkHttpClient() {
        if (mOkHttpClient == null) {
            synchronized (ServerManager.class) {
//                Cache cache = new Cache(new File(ServerContext.INSTANCE.getContext().getCacheDir(), "HttpCache"), CACHE_SIZE);
                mOkHttpClient = new OkHttpClient.Builder()
//                        .cache(cache)                                                               // 设置缓存路径，缓存大小为10M
                        .retryOnConnectionFailure(true)                                             // 错误重连
//                        .addInterceptor(mNetworkCacheInterceptor2)                                  // 设置缓存策略
//                        .addNetworkInterceptor(mNetworkCacheInterceptor2)
                        .addInterceptor(httpLoggingInterceptor())                                   // 打印日志
//                        .addInterceptor(tokenAndSeqInterceptor())                                   // 设置应用拦截器，可用于设置公共参数，头信息，日志拦截等
                        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)                          // 设置连接超时为60秒
                        .readTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)                             // 设置读超时60秒
//                        .socketFactory(getSSLSocketFactory())
//                        .hostnameVerifier(getHostnameVerifier())
                        .build();
            }
        }
    }

    // 缓存策略2(无网读缓存 有网读网络)
    private Interceptor mNetworkCacheInterceptor2 = chain -> {
        Request request = chain.request();
        request = !ServerUtil.checkNetWork() ? request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build() : request;
        Response response = chain.proceed(request);
        String cacheControl = ServerUtil.checkNetWork() ? request.cacheControl().toString() : "public, only-if-cached, max-stale=" + CACHE_TIME;
        return response.newBuilder().header("Cache-Control", cacheControl).removeHeader("Pragma").build();
    };

    private HttpLoggingInterceptor httpLoggingInterceptor() {
        return new HttpLoggingInterceptor(message -> Log.d(TAG, message)).setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    public UrlServices getUrlServices() {
        return urlServices;
    }
}
