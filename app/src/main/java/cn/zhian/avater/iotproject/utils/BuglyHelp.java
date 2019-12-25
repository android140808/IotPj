package cn.zhian.avater.iotproject.utils;

import com.tencent.bugly.crashreport.BuglyLog;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-23 16:16
 * @Description: 上报异常至bugly。为后面的Android机型适配考虑
 * @Description: .d .i .w .v .e 仅仅在发生异常的时候和reportE一起上报
 * @Description: reportE一定会上报
 */
public class BuglyHelp {
    public static void d(String tag, String msg) {
        BuglyLog.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        BuglyLog.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        BuglyLog.w(tag, msg);
    }

    public static void v(String tag, String msg) {
        BuglyLog.v(tag, msg);
    }

    public static void e(String tag, String msg) {
        BuglyLog.e(tag, msg);
    }

    public static void reportE(Throwable throwable, Thread thread) {
        CrashReport.postCatchedException(throwable, thread);
    }


}
