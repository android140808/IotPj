package cn.zhian.avater.netmodule.mode.responseBean;

import java.util.List;

import cn.zhian.avater.netmodule.mode.base.BaseResponse;

/**
 * Date：2020/3/4
 * Author:Avater
 * Description:
 */
public class SearchDeviceResponse extends BaseResponse {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 5
         * name : 智能门锁T1
         * pictureUrl : /imgs\20200302\IMG_20200302105210.png
         * cateId : 3
         */

        private int id;
        private String name;
        private String pictureUrl;
        private int cateId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public int getCateId() {
            return cateId;
        }

        public void setCateId(int cateId) {
            this.cateId = cateId;
        }
    }
}
