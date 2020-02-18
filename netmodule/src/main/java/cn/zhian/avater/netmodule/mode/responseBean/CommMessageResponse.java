package cn.zhian.avater.netmodule.mode.responseBean;

import java.util.List;

import cn.zhian.avater.netmodule.mode.base.BaseResponse;

public class CommMessageResponse extends BaseResponse {

    /**
     * data : [{"id":1,"title":"我是测试","deviceName":"二开开关","pushType":1,"createDate":"2020.02.13 14:23:08","content":"已经开发3小时","isRead":"0"},{"id":2,"title":"我是测试2","deviceName":"一开开关","pushType":1,"createDate":"2020.02.13 14:22:30","content":"我已经开了8小时","isRead":"1"},{"id":3,"title":"我是测试3","deviceName":"二开开关","pushType":1,"createDate":"2020.02.13 15:34:47","content":"已经开发5小时","isRead":"1"}]
     * metadata : {"total":3,"currentPage":0,"pageSize":10}
     */

    private Metadata metadata;
    private List<Data> data;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public static class Metadata {
        /**
         * total : 3
         * currentPage : 0
         * pageSize : 10
         */

        private int total;
        private int currentPage;
        private int pageSize;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }
    }

    public static class Data {
        /**
         * id : 1
         * title : 我是测试
         * deviceName : 二开开关
         * pushType : 1
         * createDate : 2020.02.13 14:23:08
         * content : 已经开发3小时
         * isRead : 0
         */

        private int id;
        private String title;
        private String deviceName;
        private int pushType;
        private String createDate;
        private String content;
        private String isRead;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }

        public int getPushType() {
            return pushType;
        }

        public void setPushType(int pushType) {
            this.pushType = pushType;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getIsRead() {
            return isRead;
        }

        public void setIsRead(String isRead) {
            this.isRead = isRead;
        }
    }
}
