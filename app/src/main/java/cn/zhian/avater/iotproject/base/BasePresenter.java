package cn.zhian.avater.iotproject.base;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-20 12:20
 * @Description:
 */
public interface BasePresenter<V extends BaseView> {
    void onDestroy();

    void attachView(V view);
}
