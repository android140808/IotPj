package cn.zhian.avater.iotproject.ui.model;

import android.util.Log;

import java.util.List;

import cn.zhian.avater.iotproject.base.BaseModel;
import cn.zhian.avater.netmodule.ServerRequest;
import cn.zhian.avater.netmodule.interfaces.NetResultCallBack;
import cn.zhian.avater.netmodule.mode.base.BaseResponse;
import cn.zhian.avater.netmodule.mode.responseBean.CommMessageResponse;

public class MessageUIModel implements BaseModel {

    public void getMessageSecurity(int currentPage, int pageSize, CallBack callBack) {
        ServerRequest.INSTANCE.getMessageSecurity(currentPage, pageSize, new NetResultCallBack<CommMessageResponse>() {
            @Override
            public void onSuccess(int responseCode, CommMessageResponse response) {
                callBack.getList(response.getData());
            }

            @Override
            public void onFail(int responseCode) {
                callBack.getList(null);
            }
        });
    }

    public void setMessageSecurityState(int id, String action) {
        ServerRequest.INSTANCE.setMessageSecurityState(id, action, new NetResultCallBack<BaseResponse>() {
            @Override
            public void onSuccess(int responseCode, BaseResponse baseResponse) {

            }

            @Override
            public void onFail(int responseCode) {

            }
        });
    }

    public void getMessagePush(int currentPage, int pageSize, CallBack callBack) {
        ServerRequest.INSTANCE.getMessagePush(currentPage, pageSize, new NetResultCallBack<CommMessageResponse>() {
            @Override
            public void onSuccess(int responseCode, CommMessageResponse baseResponse) {
                callBack.getList(baseResponse.getData());
            }

            @Override
            public void onFail(int responseCode) {
                callBack.getList(null);
            }
        });
    }

    public void setMessagePushState(int id, String action) {
        ServerRequest.INSTANCE.setMessagePushState(id, action, new NetResultCallBack<BaseResponse>() {
            @Override
            public void onSuccess(int responseCode, BaseResponse baseResponse) {

            }

            @Override
            public void onFail(int responseCode) {

            }
        });
    }

    public void getMessageEnvironment(int currentPage, int pageSize, CallBack callBack) {
        ServerRequest.INSTANCE.getMessageEnvironment(currentPage, pageSize, new NetResultCallBack<CommMessageResponse>() {
            @Override
            public void onSuccess(int responseCode, CommMessageResponse baseResponse) {
                callBack.getList(baseResponse.getData());
            }

            @Override
            public void onFail(int responseCode) {
                callBack.getList(null);
            }
        });
    }

    public void setMessageEnvironmentState(int id, String action) {
        ServerRequest.INSTANCE.setMessageEnvironmentState(id, action, new NetResultCallBack<BaseResponse>() {
            @Override
            public void onSuccess(int responseCode, BaseResponse baseResponse) {

            }

            @Override
            public void onFail(int responseCode) {

            }
        });
    }

    public interface CallBack {
        void getList(List<CommMessageResponse.Data> data);
    }
}
