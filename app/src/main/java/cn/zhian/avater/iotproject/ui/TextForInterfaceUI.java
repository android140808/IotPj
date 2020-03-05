package cn.zhian.avater.iotproject.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.databasemodule.MDB;
import cn.zhian.avater.databasemodule.tables.RoomDB;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.netmodule.ServerRequest;
import cn.zhian.avater.netmodule.interfaces.NetResultCallBack;
import cn.zhian.avater.netmodule.mode.base.BaseResponse;
import cn.zhian.avater.netmodule.mode.requestBean.AddDeviceRequest;
import cn.zhian.avater.netmodule.mode.requestBean.AddRoomRequest;
import cn.zhian.avater.netmodule.mode.requestBean.DelRoomOrDeviceRequest;
import cn.zhian.avater.netmodule.mode.requestBean.GetAllRoomAndDevicesRequest;
import cn.zhian.avater.netmodule.mode.requestBean.GetRoomDataRequest;
import cn.zhian.avater.netmodule.mode.requestBean.SearchDeviceRequest;
import cn.zhian.avater.netmodule.mode.responseBean.AllRoomAndDevicesResponse;
import cn.zhian.avater.netmodule.mode.responseBean.GetAllRoomAndDevicesResponse;
import cn.zhian.avater.netmodule.mode.responseBean.SearchDeviceResponse;

public class TextForInterfaceUI extends BaseUI {

    @BindView(R.id.result)
    TextView result;
    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.btn_4)
    Button btn4;
    @BindView(R.id.btn_5)
    Button btn5;
    @BindView(R.id.btn_6)
    Button btn6;
    @BindView(R.id.btn_7)
    Button btn7;
    @BindView(R.id.btn_8)
    Button btn8;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.text_for_interface_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {

    }

    private void showMsg(final String baseResponse) {
        runOnUiThread(() -> {
            result.setText("" + baseResponse);
        });
    }

    private NetResultCallBack<BaseResponse> callBack = new NetResultCallBack<BaseResponse>() {
        @Override
        public void onSuccess(int responseCode, BaseResponse baseResponse) {
            showMsg(baseResponse.toString());
        }

        @Override
        public void onFail(int responseCode) {
            showMsg("请求异常，请检查！");
        }
    };


    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_10})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                AddRoomRequest request = new AddRoomRequest("卫生间", accountDB.getAccountId(), 0);
                ServerRequest.INSTANCE.addRoom(request, null, callBack);
                break;
            case R.id.btn_2:
                GetAllRoomAndDevicesRequest getAllRoomAndDevicesRequest = new GetAllRoomAndDevicesRequest(accountDB.getAccountId());
                ServerRequest.INSTANCE.getAllRoomAndDevices(getAllRoomAndDevicesRequest, new NetResultCallBack<GetAllRoomAndDevicesResponse>() {
                    @Override
                    public void onSuccess(int responseCode, GetAllRoomAndDevicesResponse baseResponse) {
                        showMsg("请求成功");
                    }

                    @Override
                    public void onFail(int responseCode) {
                        showMsg("请求失败");
                    }
                });
                break;
            case R.id.btn_3:
                DelRoomOrDeviceRequest delRoomOrDeviceRequest = new DelRoomOrDeviceRequest(12);
                ServerRequest.INSTANCE.delRoom(delRoomOrDeviceRequest, callBack);
                break;
            case R.id.btn_4:
                AddDeviceRequest addDeviceRequest = new AddDeviceRequest(13, accountDB.getAccountId(), 1, "未知设备", 102);
                ServerRequest.INSTANCE.addDevice(addDeviceRequest, callBack);
                break;
            case R.id.btn_5:
                GetRoomDataRequest getRoomDataRequest = new GetRoomDataRequest(13);
                ServerRequest.INSTANCE.getRoomData(getRoomDataRequest, callBack);
                break;
            case R.id.btn_6:
                ServerRequest.INSTANCE.getAllRoomAndDevices(new NetResultCallBack<AllRoomAndDevicesResponse>() {
                    @Override
                    public void onSuccess(int responseCode, AllRoomAndDevicesResponse baseResponse) {

                    }

                    @Override
                    public void onFail(int responseCode) {

                    }
                });
                break;
            case R.id.btn_7:
                SearchDeviceRequest searchDeviceRequest = new SearchDeviceRequest("智能门锁");
                ServerRequest.INSTANCE.searchDeivce(searchDeviceRequest, new NetResultCallBack<SearchDeviceResponse>() {
                    @Override
                    public void onSuccess(int responseCode, SearchDeviceResponse baseResponse) {

                    }

                    @Override
                    public void onFail(int responseCode) {

                    }
                });
                break;
            case R.id.btn_8:
                DelRoomOrDeviceRequest delR = new DelRoomOrDeviceRequest(1);
                ServerRequest.INSTANCE.delDevice(delR, callBack);
                break;
            case R.id.btn_9:
                RoomDB r1 = new RoomDB("18378407970", 123456789, "卧室1", 1, 1, 1);
                r1.setSensor("传感器&3");
                RoomDB r2 = new RoomDB("18378407970", 123456789, "卧室2", 2, 2, 2);
                RoomDB r3 = new RoomDB("18378407970", 123456789, "卧室3", 3, 3, 3);
                RoomDB r4 = new RoomDB("18378407970", 123456789, "卧室4", 6, 2, 4);
                List<RoomDB> list = new ArrayList<>();
                list.add(r1);
                list.add(r2);
                list.add(r3);
                list.add(r4);
                MDB.INSTANCE.updateAll(list);
                break;
            case R.id.btn_10:
                MDB.INSTANCE.getAllRoom("18378407970", 123456789);
                break;
        }
    }
}
