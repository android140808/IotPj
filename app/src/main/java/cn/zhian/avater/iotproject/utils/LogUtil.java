package cn.zhian.avater.iotproject.utils;

import android.Manifest;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import cn.zhian.avater.iotproject.Applications;
import pub.devrel.easypermissions.EasyPermissions;


/**
 * 日期：2020/1/07
 * 说明：日志打印类(所有的日志都用该类来管理)
 */

public class LogUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("MM月dd HH:mm:ss", Locale.CHINA);

    private static boolean isPrintfLog = true;                                                     // 是否打印日志
    private static boolean isWriteLog = false;                                                      // 是否写日志

    private static FileOutputStream outputStream;

    private static final int TYPE_INFO = 0;
    private static final int TYPE_WRITE = 1;
    private static final int TYPE_ERROR = 2;
    private static final int TYPE_VERBOSE = 3;

    static {
        if (EasyPermissions.hasPermissions(Applications.getPowerContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                String path = externalStorageDirectory.getAbsolutePath() + "/ZhiAn/";
                File directory = new File(path);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                File file = new File(new File(path), "log.txt");
                try {
                    outputStream = new FileOutputStream(file, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param isPrintfLog 是否打印日志
     * @param isWriteLog  是否写日志
     */
    public static void init(boolean isPrintfLog, boolean isWriteLog) {
        LogUtil.isPrintfLog = isPrintfLog;
        LogUtil.isWriteLog = isWriteLog;
    }


    private static void printf(String tag, String msg, int type) {
        if (isPrintfLog) {
            switch (type) {
                case TYPE_WRITE:
                    Log.w(tag, msg);
                    break;
                case TYPE_ERROR:
                    Log.e(tag, msg);
                    break;
                case TYPE_VERBOSE:
                    Log.v(tag, msg);
                    break;
                case TYPE_INFO:
                default:
                    Log.i(tag, msg);
                    break;
            }
        }
        if (isWriteLog) {
            String time = sdf.format(System.currentTimeMillis());
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                if (outputStream != null) {
                    String className = tag;
                    String content = "(" + time + ") : " + msg + "\r\n";
                    writeAndFlush(("*******" + className + "(" + time + ")*******\r\n").getBytes());
                    writeAndFlush(content.getBytes());
                }
            }
        }
    }

    private static boolean checkPermission() {
        if (EasyPermissions.hasPermissions(Applications.getPowerContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            return true;
        }
        Log.e("LogUtil", "暂时没有文件读写权限，不打印log");
        return false;
    }

    public static void i(String TAG, String msg) {
        if (!checkPermission()) {
            return;
        }
        printf(TAG, msg, TYPE_INFO);
    }

    public static void w(String TAG, String msg) {
        printf(TAG, msg, TYPE_WRITE);
    }

    public static void e(String TAG, String msg) {
        printf(TAG, msg, TYPE_ERROR);
    }

    public static void v(String TAG, String msg) {
        printf(TAG, msg, TYPE_VERBOSE);
    }

    public static void writeAndFlush(byte[] buf) {
        try {
            outputStream.write(buf);
            outputStream.flush();
        } catch (IOException e) {
        }
    }
}
