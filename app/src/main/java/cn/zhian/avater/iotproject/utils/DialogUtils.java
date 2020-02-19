package cn.zhian.avater.iotproject.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

    public static AlertDialog getLogoutDialog(Context context, DialogInterface.OnClickListener okLis) {
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setMessage(R.string.logout)
                .setPositiveButton(android.R.string.ok, okLis)
                .setNegativeButton(android.R.string.cancel, null)
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        return alertDialog;
    }

    public static AlertDialog getDialog(Context context, int tittleIds, CallBackString callBackString) {
        View view = LayoutInflater.from(context).inflate(R.layout.add_host_dialog, null);
        TextView tv = view.findViewById(R.id.tittle);
        tv.setText(tittleIds);
        EditText editText = view.findViewById(R.id.input_content);
        view.findViewById(R.id.cancel).setOnClickListener(click -> {
            if (callBackString != null) {
                callBackString.cancel();
            }
        });
        view.findViewById(R.id.ok).setOnClickListener(click -> {
            if (callBackString != null) {
                callBackString.backString(editText.getText().toString());
            }
        });
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setView(view)
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        return alertDialog;
    }

    public static AlertDialog getConnectDialog(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.add_host_connect_dialog, null);
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setView(view)
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        return alertDialog;
    }

    public interface CallBackString {
        void cancel();

        void backString(String value);
    }
}
