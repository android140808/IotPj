package cn.zhian.avater.iotproject.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;




import butterknife.ButterKnife;
import cn.zhian.avater.iotproject.utils.UIManagerUtils;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 9:41
 * @Description:
 */
public abstract class BaseUI<V extends BaseView, T extends BasePresenter<V>> extends AppCompatActivity implements BaseView {

    protected final String TAG = this.getClass().getSimpleName();
    protected Context mContext;
    protected T mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewLayout());
        ButterKnife.bind(this);
        mContext = this;
        UIManagerUtils.getInstance().addActivity(this);
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
        runOnUiThread(() -> {
            if (mContext != null) {
                Toast.makeText(mContext, getResources().getText(resId), Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void showToast(final String msg) {
        runOnUiThread(() -> {
            if (mContext != null) {
                Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDestoryData();
        UIManagerUtils.getInstance().removeActivity(this);
    }

    public void onDestoryData() {
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

    protected void closeUI() {
        finish();
    }
}
