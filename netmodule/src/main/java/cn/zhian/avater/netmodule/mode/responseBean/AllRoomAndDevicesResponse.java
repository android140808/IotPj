package cn.zhian.avater.netmodule.mode.responseBean;

import java.util.List;

import cn.zhian.avater.netmodule.mode.base.BaseResponse;

/**
 * Date：2020/3/4
 * Author:Avater
 * Description:
 */
public class AllRoomAndDevicesResponse extends BaseResponse {

    /**
     * code : 0
     * success : success
     * data : [{"value":3,"label":"智能门锁","children":[{"value":7,"label":"T1","children":[{"value":1,"label":"智能门锁T1","pictureUrl":"/imgs\\20200302\\IMG_20200302105210.png"}]},{"value":8,"label":"Y1","children":[{"value":2,"label":"智能门锁Y1","pictureUrl":"/imgs\\20200302\\IMG_20200302105326.png"}]}]},{"value":5,"label":"智能遥控","children":[{"value":13,"label":"HP1红外遥控","children":[]}]},{"value":6,"label":"环境传感器","children":[{"value":14,"label":"ZG1环境监测器","children":[]}]},{"value":7,"label":"智能安防","children":[{"value":15,"label":"S1全景摄像机","children":[]},{"value":16,"label":"人体探测器","children":[]},{"value":17,"label":"门窗磁探测器","children":[]},{"value":18,"label":"燃气探测器","children":[]},{"value":19,"label":"烟雾探测器","children":[]}]},{"value":8,"label":"智能窗帘","children":[{"value":20,"label":"C1电动窗帘","children":[]}]},{"value":10,"label":"智能开关","children":[{"value":21,"label":"KX","children":[{"value":10,"label":"一开","pictureUrl":"/imgs\\20200302\\IMG_20200302172049.png"},{"value":11,"label":"二开","pictureUrl":"/imgs\\20200302\\IMG_20200302172052.png"},{"value":12,"label":"三开","pictureUrl":"/imgs\\20200302\\IMG_20200302172056.png"}]},{"value":22,"label":"KS","children":[{"value":7,"label":"一开","pictureUrl":"/imgs\\20200302\\IMG_20200302172030.png"},{"value":8,"label":"二开","pictureUrl":"/imgs\\20200302\\IMG_20200302172041.png"},{"value":9,"label":"三开","pictureUrl":"/imgs\\20200302\\IMG_20200302172046.png"}]}]}]
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * value : 3
         * label : 智能门锁
         * children : [{"value":7,"label":"T1","children":[{"value":1,"label":"智能门锁T1","pictureUrl":"/imgs\\20200302\\IMG_20200302105210.png"}]},{"value":8,"label":"Y1","children":[{"value":2,"label":"智能门锁Y1","pictureUrl":"/imgs\\20200302\\IMG_20200302105326.png"}]}]
         */

        private int value;
        private String label;
        private List<ChildrenBeanX> children;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public List<ChildrenBeanX> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBeanX> children) {
            this.children = children;
        }

        public static class ChildrenBeanX {
            /**
             * value : 7
             * label : T1
             * children : [{"value":1,"label":"智能门锁T1","pictureUrl":"/imgs\\20200302\\IMG_20200302105210.png"}]
             */

            private int value;
            private String label;
            private List<ChildrenBean> children;

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public List<ChildrenBean> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBean> children) {
                this.children = children;
            }

            public static class ChildrenBean {
                /**
                 * value : 1
                 * label : 智能门锁T1
                 * pictureUrl : /imgs\20200302\IMG_20200302105210.png
                 */

                private int value;
                private String label;
                private String pictureUrl;

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }

                public String getLabel() {
                    return label;
                }

                public void setLabel(String label) {
                    this.label = label;
                }

                public String getPictureUrl() {
                    return pictureUrl;
                }

                public void setPictureUrl(String pictureUrl) {
                    this.pictureUrl = pictureUrl;
                }
            }
        }
    }
}
