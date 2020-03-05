package cn.zhian.avater.iotproject.serverice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import cn.zhian.avater.databasemodule.MDB;
import cn.zhian.avater.databasemodule.tables.AccountDB;
import cn.zhian.avater.netmodule.ServerRequest;
import cn.zhian.avater.netmodule.interfaces.NetResultCallBack;
import cn.zhian.avater.netmodule.mode.responseBean.AccountResponse;

/**
 * Date：2020/3/2
 * Author:Avater
 * Description:  登录时，去获取主页所有的数据
 */
public class LoginService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ServerRequest.INSTANCE.getUserInfo(new NetResultCallBack<AccountResponse>() {
            @Override
            public void onSuccess(int responseCode, AccountResponse baseResponse) {
                AccountResponse.DataBean bean = baseResponse.getData();
                String avatar = bean.getAvatar();
                long createdTime = bean.getCreatedTime();
                String email = bean.getEmail();
                boolean enabled = bean.isEnabled();
                String gatewayIp = bean.getGatewayIp();
                long accountId = bean.getCustomerId();
                boolean isLocked = bean.isIsLocked();
                String lastLoginIp = bean.getLastLoginIp();
                long lastLoginTime = bean.getLastLoginTime();
                int loginCount = bean.getLoginCount();
                String loginDevices = bean.getLoginDevices();
                String mobile = bean.getMobile();
                String nickname = bean.getNickname();
                String username = bean.getUsername();
                String weChat = bean.getWeChat();
                String weChatUnionId = bean.getWeChatUnionId();
                long updatedTime = bean.getUpdatedTime();
                AccountDB db = new AccountDB(avatar, createdTime, email, enabled, gatewayIp,
                        accountId, isLocked, lastLoginIp, lastLoginTime, loginCount,
                        loginDevices, mobile, nickname, updatedTime, username, weChat, weChatUnionId);
                MDB.INSTANCE.saveAccount(db);
            }

            @Override
            public void onFail(int responseCode) {
            }
        });
    }
}
