package cn.zhian.avater.iotproject.utils;

import android.Manifest;
import android.content.Context;
import android.util.Log;

import com.yanzhenjie.permission.AndPermission;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-19 10:37
 * @Description: 权限申请管理工具类
 */
public class PermissionUtils {
    private static PermissionUtils INSTANCE;

    public static PermissionUtils getInstance() {
        if (INSTANCE == null) {
            synchronized (PermissionUtils.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PermissionUtils();
                }
            }
        }
        return INSTANCE;
    }

    private PermissionUtils() {
    }

    public void applyAllPermissions(Context context) {
        AndPermission.with(context).runtime().permission(
                new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA
                })
                .onGranted(list -> {
                })
                .onDenied(list -> {
                })
                .start();
    }
}
