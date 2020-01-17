package cn.zhian.avater.iotproject.serverice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-13 9:50
 * @Description: 监听网络状态
 */
public class NetStateService extends Service {


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
