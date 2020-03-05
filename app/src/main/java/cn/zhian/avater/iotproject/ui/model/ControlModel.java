package cn.zhian.avater.iotproject.ui.model;

import java.util.ArrayList;
import java.util.List;

import cn.zhian.avater.databasemodule.MDB;
import cn.zhian.avater.databasemodule.tables.RoomDB;
import cn.zhian.avater.iotproject.base.BaseModel;
import cn.zhian.avater.netmodule.ServerRequest;
import cn.zhian.avater.netmodule.interfaces.NetResultCallBack;
import cn.zhian.avater.netmodule.mode.requestBean.GetAllRoomAndDevicesRequest;
import cn.zhian.avater.netmodule.mode.responseBean.GetAllRoomAndDevicesResponse;

/**
 * Date：2020/3/4
 * Author:Avater
 * Description:
 */
public class ControlModel implements BaseModel {


    public void getAllRoomAndDevice(String mobile, long accountId, CallBack callBack) {
        GetAllRoomAndDevicesRequest request = new GetAllRoomAndDevicesRequest(accountId);
        ServerRequest.INSTANCE.getAllRoomAndDevices(request, new NetResultCallBack<GetAllRoomAndDevicesResponse>() {
            @Override
            public void onSuccess(int responseCode, GetAllRoomAndDevicesResponse response) {
                List<GetAllRoomAndDevicesResponse.DataBean> data = response.getData();
                if (null != data && data.size() > 0) {
                    List<RoomDB> roomDBList = new ArrayList<>();
                    for (GetAllRoomAndDevicesResponse.DataBean db : data) {
                        long roomId = db.getRoomId();
                        String roomName = db.getName();
                        int deviceCount = db.getCount();
                        int localPicId = db.getChamIdentifier();
                        RoomDB cache = new RoomDB(mobile, accountId, roomName, deviceCount, localPicId, roomId);
                        roomDBList.add(cache);
                        if (null != db.getProList() && db.getProList().size() > 0) {
                            List<GetAllRoomAndDevicesResponse.DataBean.ProListBean> proList = db.getProList();
                            for (GetAllRoomAndDevicesResponse.DataBean.ProListBean device : proList) {
                                String deviceName = device.getName();
                                int cate_identifier = device.getCate_identifier();
                                switch (cate_identifier) {//1:”灯光控制”；2:”家电控制”; 3:”传感器”
                                    case 1://
                                        cache.setSensor(deviceName + "&1");
                                        break;
                                    case 2:
                                        cache.setElecttical(deviceName + "&2");
                                        break;
                                    case 3:
                                        cache.setSensor(deviceName + "&3");
                                        break;
                                }
                            }
                        }
                    }
                    if (roomDBList.size() > 0) {
                        MDB.INSTANCE.updateAll(roomDBList);
                    }
                    callBack.getRoomDBList(MDB.INSTANCE.getAllRoom(mobile, accountId));
                }
            }

            @Override
            public void onFail(int responseCode) {
                callBack.getRoomDBList(MDB.INSTANCE.getAllRoom(mobile, accountId));
            }
        });
    }

    public interface CallBack {
        void getRoomDBList(List<RoomDB> list);
    }

}
