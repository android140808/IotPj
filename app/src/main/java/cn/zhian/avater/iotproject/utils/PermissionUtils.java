package cn.zhian.avater.iotproject.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

import cn.zhian.avater.iotproject.R;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-19 10:37
 * @Description: 权限申请管理工具类
 */
public class PermissionUtils {

    private static PermissionUtils INSTANCE;
    private String ALL_PERMISSIONS[] = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_WIFI_STATE,
    };

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
        LogUtil.w("PermissionUtils", "申请权限");
        if (EasyPermissions.hasPermissions(context, ALL_PERMISSIONS)) {
            LogUtil.i("PermissionUtils", "权限已经全部申请过了");
            return;
        }
        LogUtil.e("PermissionUtils", "开始申请全部权限");
        EasyPermissions.requestPermissions((Activity) context, context.getResources().getString(R.string.permissions_tips), 100, ALL_PERMISSIONS);
    }
}
