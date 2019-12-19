package cn.zhian.avater.iotproject.utils;

import android.app.Activity;
import android.os.Process;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 9:56
 * @Description:
 */
public class UIManagerUtils {

    private static UIManagerUtils instance;

    public static UIManagerUtils getInstance() {
        if (instance == null) {
            synchronized (UIManagerUtils.class) {
                if (instance == null) {
                    instance = new UIManagerUtils();
                }
            }
        }
        return instance;
    }

    private List<Activity> activityList = new ArrayList<>();

    private UIManagerUtils() {
    }


    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        if (activityList == null)
            activityList = new ArrayList<>();
        activityList.add(activity);
    }

    // 移除Activity
    public void removeActivity(Activity activity) {
        if (activityList != null)
            activityList.remove(activity);
    }

    // 遍历所有Activity并finish
    public void exitSystem() {
        for (Activity activity : activityList) {
            if (activity != null)
                activity.finish();
        }
        // 退出进程
        android.os.Process.killProcess(Process.myPid());
        System.exit(0);
    }
}
