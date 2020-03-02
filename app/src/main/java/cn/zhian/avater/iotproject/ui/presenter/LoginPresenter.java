package cn.zhian.avater.iotproject.ui.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.concurrent.TimeUnit;

import cn.zhian.avater.iotproject.Applications;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseView;
import cn.zhian.avater.iotproject.eventbus.WeChatLoginBus;
import cn.zhian.avater.iotproject.serverice.LoginService;
import cn.zhian.avater.iotproject.ui.interfaces.WeChatLoginCallBack;
import cn.zhian.avater.iotproject.ui.model.LoginModel;
import cn.zhian.avater.iotproject.ui.view.LoginView;
import cn.zhian.avater.iotproject.utils.BuglyHelp;
import cn.zhian.avater.iotproject.utils.DialogUtils;
import cn.zhian.avater.iotproject.utils.GeneralMethods;
import cn.zhian.avater.iotproject.utils.SystemUtil;
import cn.zhian.avater.netmodule.mode.requestBean.LoginHeaders;
import cn.zhian.avater.netmodule.mode.requestBean.LoginRequest;
import cn.zhian.avater.netmodule.utils.ServerRequestManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-20 14:13
 * @Description:
 */
public class LoginPresenter<V extends BaseView> implements BasePresenter<V>, WeChatLoginCallBack {

    private LoginView view;
    private LoginModel loginModel;
    private String seq;
    private Disposable disposable;
    private String phoneBrand;
    private String systemType;
    private String systemVersion;
    private String country;
    private String appVersion;


    public LoginPresenter() {
        loginModel = new LoginModel();
        EventBus.getDefault().register(this);
        phoneBrand = SystemUtil.getDeviceBrand() + "-" + SystemUtil.getSystemModel();
        systemType = "Android";
        systemVersion = SystemUtil.getSystemVersion();
        appVersion = SystemUtil.getAppVersion();
        country = "86";
    }

    @Subscribe
    public void weChatLoginState(WeChatLoginBus bus) {
        if (bus != null) {

        }
    }

    @Override
    public void onDestroy() {
        if (disposable != null) {
            disposable.dispose();
            disposable = null;
        }
        if (!TextUtils.isEmpty(seq)) {
            ServerRequestManager.INSTANCE.remove(seq);
        }
        view = null;
    }

    @Override
    public void attachView(BaseView view) {
        this.view = (LoginView) view;
    }


    public void getSmsCode(Context context, String phoneNumber, TextView textView) {
        if (null == view) {
            return;
        }
        if (TextUtils.isEmpty(phoneNumber)) {
            view.loginFailed(context.getResources().getString(R.string.login_input_phone));
            return;
        }
        boolean state = GeneralMethods.judgeChinePhoneNumber(phoneNumber);
        if (!state) {
            view.loginFailed(context.getResources().getString(R.string.login_phone_error));
            return;
        }
        if (!GeneralMethods.networkState(context)) {
            view.loginFailed(context.getResources().getString(R.string.login_network_error));
            return;
        }
        startRun(textView);
        view.showProgress();
        try {
            loginModel.getSmsCode(phoneNumber, code -> {
                if (view != null) {
                    if (code == 0) {
                        view.getSmsCode();
                    } else {
                        view.loginFailed("获取验证码失败，请重试！");
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            BuglyHelp.reportE(e, Thread.currentThread());
        }
    }

    /**
     * 60s 倒数计时
     */
    private void startRun(TextView textView) {
        final long times = 60;
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take((times - 1))
                .map(aLong -> times - aLong)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new io.reactivex.Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null) {
                            textView.setEnabled(true);
                            textView.setText("获取验证码");
                        }
                    }

                    @Override
                    public void onComplete() {
                        if (view != null) {
                            textView.setEnabled(true);
                            textView.setText("获取验证码");
                        }
                    }

                    @Override
                    public void onNext(Long aLong) {
                        textView.setEnabled(false);
                        if (view != null) {
                            textView.setText("重新获取" + aLong + "s");
                        }
                    }
                });

    }

    public void loginWithSmsCode(Context context, String phoneNumber, String code) {
        if (!GeneralMethods.networkState(context)) {
            view.loginFailed(context.getResources().getString(R.string.login_network_error));
            return;
        }
        if (TextUtils.isEmpty(phoneNumber)) {
            view.loginFailed(context.getResources().getString(R.string.login_input_phone));
            return;
        }
        if (TextUtils.isEmpty(code)) {
            view.loginFailed(context.getResources().getString(R.string.login_set_phone_check));
            return;
        }
        boolean state = GeneralMethods.judgeChinePhoneNumber(phoneNumber);
        if (!state) {
            view.loginFailed(context.getResources().getString(R.string.login_phone_error));
            return;
        }
        LoginRequest b = new LoginRequest(phoneNumber, code);
        seq = b.seq;
        view.showProgress();
        LoginHeaders headers = new LoginHeaders(phoneBrand, systemType, systemVersion, appVersion);
        loginModel.loginWithSmsCode(phoneNumber, code, callback -> {
            if (view != null) {
                if (callback == 0) {
                    view.loginSuccess();
                    if (context != null) {
                        Intent ser = new Intent(context, LoginService.class);
                        context.startService(ser);
                    }
                } else if (-1 == callback)
                    view.loginFailed("验证码或手机号码不匹配！");
                else
                    view.loginFailed("登陆失败");
            }
        }, headers);
    }

    public void loginWithWeChat(Context context) {
        IWXAPI iwxapi = WXAPIFactory.createWXAPI(context, Applications.WE_CHAT_C_K, true);
        iwxapi.registerApp(Applications.WE_CHAT_C_K);
        if (!iwxapi.isWXAppInstalled()) {
            loginFail();
        } else {
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
//            req.scope = "snsapi_login";//提示 scope参数错误，或者没有scope权限
            req.state = "wechat_sdk_微信登录";
            iwxapi.sendReq(req);
        }
    }

    @Override
    public void loginSuccess(int type, String token, String id, String secret) {

    }

    @Override
    public void loginFail() {
        if (disposable != null) {
            disposable.dispose();
            disposable = null;
        }
    }
}
