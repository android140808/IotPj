package cn.zhian.avater.iotproject.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import cn.zhian.avater.iotproject.Applications;
import cn.zhian.avater.iotproject.R;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 15:23
 * @Description:
 */
public abstract class BaseFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public abstract int getLayout();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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

}
