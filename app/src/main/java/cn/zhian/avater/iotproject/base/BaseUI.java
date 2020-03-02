package cn.zhian.avater.iotproject.base;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;


import butterknife.ButterKnife;
import cn.zhian.avater.databasemodule.MDB;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.utils.DialogUtils;
import cn.zhian.avater.iotproject.utils.UIManagerUtils;
import cn.zhian.avater.netmodule.ServerVal;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 9:41
 * @Description:
 */
public abstract class BaseUI<V extends BaseView, T extends BasePresenter<V>> extends AppCompatActivity implements BaseView {

    protected final String TAG = this.getClass().getSimpleName();
    protected Context mContext;
    protected T mPresenter;
    public TittleManager tittleManager;
    protected String mCurrentPhoneNumber;
    protected String accessToken;
    protected Dialog alertDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(getViewLayout());
        } catch (Exception e) {
        }
        ButterKnife.bind(this);
        mContext = this;
        Log.d(TAG, "当前UI:" + TAG);
        UIManagerUtils.getInstance().addActivity(this);
        mCurrentPhoneNumber = MDB.INSTANCE.getCurrentPhoneNumber();
        Log.d(TAG, "当前用户:" + mCurrentPhoneNumber);
        accessToken = MDB.INSTANCE.getToken();
        if (!TextUtils.isEmpty(accessToken)) {
            ServerVal.accessToken = accessToken;
        }
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
        findViewById();
        initData();
    }

    public abstract T createPresenter();

    public abstract int getViewLayout();

    public abstract void findViewById();

    public abstract void initData();

    /**
     * 隐藏软键盘
     */
    protected final void hideSoftInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null && null != imm) {
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    protected void showToast(final int resId) {
        try {
            runOnUiThread(() -> {
                if (mContext != null) {
                    Toast.makeText(mContext, getResources().getText(resId), Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void showToast(final String msg) {
        try {
            runOnUiThread(() -> {
                if (mContext != null) {
                    Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (tittleManager != null) {
            tittleManager = null;
        }
        onDestroyPresenter();
        UIManagerUtils.getInstance().removeActivity(this);
    }

    public void onDestroyPresenter() {
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }

    protected void changeUI(Context context, Class cla, Bundle... bundles) {
        Intent intent = new Intent(context, cla);
        if (bundles != null && bundles.length > 0) {
            intent.putExtras(bundles[0]);
        }
        startActivity(intent);
    }

    @Override
    public void showLoading() {
        alertDialog = DialogUtils.getLoadDialog(this);
        alertDialog.show();
    }

    protected void closeLoading() {
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    protected void closeUI() {
        if (alertDialog != null) {
            alertDialog.dismiss();
            alertDialog = null;
        }
        finish();
    }
}
