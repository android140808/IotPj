package cn.zhian.avater.netmodule.mode.responseBean;


import java.util.List;

import cn.zhian.avater.netmodule.mode.base.BaseResponse;

/**
 * Date：2020/3/3
 * Author:Avater
 * Description:
 */
public class GetAllRoomAndDevicesResponse extends BaseResponse {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private long roomId;
        private String name;
        private String pictureUrl;
        private int count;
        private int chamIdentifier;//本地图片编号
        private List<ProListBean> cateList;

        public long getRoomId() {
            return roomId;
        }

        public void setRoomId(long roomId) {
            this.roomId = roomId;
        }

        public int getChamIdentifier() {
            return chamIdentifier;
        }

        public void setChamIdentifier(int chamIdentifier) {
            this.chamIdentifier = chamIdentifier;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPictureUrl() {
            return pictureUrl;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ProListBean> getProList() {
            return cateList;
        }

        public void setProList(List<ProListBean> proList) {
            this.cateList = proList;
        }

        public static class ProListBean {
            private int cate_identifier;//1:”灯光控制”；2:”家电控制”; 3:”传感器”
            private String name;

            public String getName() {
                return name;
            }

            public int getCate_identifier() {
                return cate_identifier;
            }

            public void setCate_identifier(int cate_identifier) {
                this.cate_identifier = cate_identifier;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
