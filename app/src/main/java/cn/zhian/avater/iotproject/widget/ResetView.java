package cn.zhian.avater.iotproject.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.Applications;
import cn.zhian.avater.iotproject.R;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-20 10:20
 * @Description:
 */
public class ResetView implements View.OnClickListener {

    TextView resetTittle;
    EditText resetPassword;
    LinearLayout resetLlContent;
    TextView resetCancel;
    TextView resetOk;
    private AlertDialog alertDialog;
    private doSomeTing listener;


    public ResetView(Context context) {
        alertDialog = new AlertDialog.Builder(context).create();
        View view = LayoutInflater.from(context).inflate(R.layout.reset_dialog, null);
        init(view);
        alertDialog.setView(view);
        alertDialog.setCanceledOnTouchOutside(false);
    }

    private void init(View view) {
        resetTittle = view.findViewById(R.id.reset_tittle);
        resetPassword = view.findViewById(R.id.reset_password);
        resetLlContent = view.findViewById(R.id.reset_ll_content);
        resetCancel = view.findViewById(R.id.reset_cancel);
        resetOk = view.findViewById(R.id.reset_ok);
        resetCancel.setOnClickListener(this);
        resetOk.setOnClickListener(this);
    }

    public void show() {
        if (alertDialog != null) {
            alertDialog.show();
        }
    }

    public void dismiss() {
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void setListener(doSomeTing listener) {
        this.listener = listener;
    }

    public void showEdit() {
        resetLlContent.setVisibility(View.VISIBLE);
        resetTittle.setText(Applications.getPowerContext().getResources().getString(R.string.reset_password));
        resetCancel.setText(Applications.getPowerContext().getResources().getString(android.R.string.cancel));
        resetOk.setText(Applications.getPowerContext().getResources().getString(android.R.string.ok));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.reset_cancel:
                dismiss();
                break;
            case R.id.reset_ok:
                if (resetOk.getText().toString().equals(Applications.getPowerContext().getResources().getString(R.string.reset_ok))) {
                    showEdit();
                } else {
                    if (listener != null) {
                        listener.doIt();
                        dismiss();
                    }
                }
                break;
        }
    }

    public interface doSomeTing {
        void doIt();
    }
}
