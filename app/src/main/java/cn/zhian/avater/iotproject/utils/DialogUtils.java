package cn.zhian.avater.iotproject.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;

import cn.zhian.avater.iotproject.R;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-20 11:30
 * @Description:
 */
public class DialogUtils {

    /**
     * 正在加载中
     * 按返回键可取消
     *
     * @param context
     * @return
     */
    public static AlertDialog getLoadDialog(Context context) {
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setView(LayoutInflater.from(context).inflate(R.layout.progress_dalog, null))
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        return alertDialog;
    }

    public static AlertDialog getAgreeDialog(Context context, DialogInterface.OnClickListener unSelectLis) {
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setMessage(R.string.login_agree_alert)
                .setPositiveButton(android.R.string.ok, unSelectLis)
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        return alertDialog;
    }

    public static AlertDialog getAgreeTipDialog(Context context, DialogInterface.OnClickListener okLis, DialogInterface.OnClickListener cancelLis) {
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setMessage(R.string.login_tips_content)
                .setPositiveButton(android.R.string.ok, okLis)
                .setNegativeButton(android.R.string.cancel, cancelLis)
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        return alertDialog;
    }
}
