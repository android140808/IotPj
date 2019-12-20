package cn.zhian.avater.iotproject.base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import cn.zhian.avater.iotproject.utils.UIManagerUtils;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 9:41
 * @Description:
 */
public abstract class BaseUI extends AppCompatActivity {

    protected final String TAG = this.getClass().getSimpleName();
    protected Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideActionBar();
        setContentView(getViewLayout());
        ButterKnife.bind(this);
        mContext = this;
        UIManagerUtils.getInstance().addActivity(this);
        findViewById();
        initData();
    }

    private void hideActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            // 透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

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
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mContext != null) {
                    Toast.makeText(mContext, getResources().getText(resId), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void showToast(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mContext != null) {
                    Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UIManagerUtils.getInstance().removeActivity(this);
    }

    protected void changeUI(Context context, Class cla, Bundle... bundles) {
        Intent intent = new Intent(context, cla);
        if (bundles != null && bundles.length > 0) {
            intent.putExtras(bundles[0]);
        }
        startActivity(intent);
    }

    protected void closeUI() {
        finish();
    }
}
