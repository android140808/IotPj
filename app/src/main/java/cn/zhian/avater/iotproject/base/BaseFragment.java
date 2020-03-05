package cn.zhian.avater.iotproject.base;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import cn.zhian.avater.databasemodule.MDB;
import cn.zhian.avater.databasemodule.tables.AccountDB;
import cn.zhian.avater.iotproject.ui.TittleManager;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 15:23
 * @Description:
 */
public abstract class BaseFragment<V extends BaseView, T extends BasePresenter<V>> extends Fragment implements BaseView {

    protected final String TAG = this.getClass().getSimpleName();
    protected View view;
    protected T mPresenter;
    public TittleManager tittleManager;
    protected AccountDB accountDB;
    protected String mCurrentPhoneNumber;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            view = inflater.inflate(getLayout(), container, false);
        } catch (Exception e) {
        }
        ButterKnife.bind(this, view);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
        return view;
    }

    public abstract int getLayout();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public abstract T createPresenter();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCurrentPhoneNumber = MDB.INSTANCE.getCurrentPhoneNumber();
        Log.d(TAG, "当前用户:" + mCurrentPhoneNumber);
        if (!TextUtils.isEmpty(mCurrentPhoneNumber)) {
            accountDB = MDB.INSTANCE.getAccount(mCurrentPhoneNumber);
        }
        initData();
    }

    public abstract void initData();

    protected void showToast(final int resId) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getActivity(), resId, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    protected void showToast(final String msg) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    protected void changUI(Class clas, Bundle... bundles) {
        Intent intent = new Intent(getActivity(), clas);
        if (bundles != null && bundles.length > 0) {
            intent.putExtras(bundles[0]);
        }
        getActivity().startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        if (tittleManager != null) {
            tittleManager = null;
        }
    }
}
