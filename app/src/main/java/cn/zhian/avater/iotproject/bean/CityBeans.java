package cn.zhian.avater.iotproject.bean;

import java.util.List;

/**
 * @Author: wangweida
 * @CreateDate: 2020-02-14 14:56
 * @Description:
 */
public class CityBeans {


    /**
     * name : 北京市
     * code : 110000
     * city : [{"name":"市辖区","code":"110100","area":[{"code":"110101"},{"name":"西城区","code":"110102"},{"name":"朝阳区","code":"110105"},{"name":"丰台区","code":"110106"},{"name":"石景山区","code":"110107"},{"name":"海淀区","code":"110108"},{"name":"门头沟区","code":"110109"},{"name":"房山区","code":"110111"},{"name":"通州区","code":"110112"},{"name":"顺义区","code":"110113"},{"name":"昌平区","code":"110114"},{"name":"大兴区","code":"110115"},{"name":"怀柔区","code":"110116"},{"name":"平谷区","code":"110117"},{"name":"密云区","code":"110118"},{"name":"延庆区","code":"110119"}]}]
     */

    private String name;
    private String code;
    private List<CityBean> city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<CityBean> getCity() {
        return city;
    }

    public void setCity(List<CityBean> city) {
        this.city = city;
    }

    public static class CityBean {
        /**
         * name : 市辖区
         * code : 110100
         * area : [{"code":"110101"},{"name":"西城区","code":"110102"},{"name":"朝阳区","code":"110105"},{"name":"丰台区","code":"110106"},{"name":"石景山区","code":"110107"},{"name":"海淀区","code":"110108"},{"name":"门头沟区","code":"110109"},{"name":"房山区","code":"110111"},{"name":"通州区","code":"110112"},{"name":"顺义区","code":"110113"},{"name":"昌平区","code":"110114"},{"name":"大兴区","code":"110115"},{"name":"怀柔区","code":"110116"},{"name":"平谷区","code":"110117"},{"name":"密云区","code":"110118"},{"name":"延庆区","code":"110119"}]
         */

        private String name;
        private String code;
        private List<AreaBean> area;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public List<AreaBean> getArea() {
            return area;
        }

        public void setArea(List<AreaBean> area) {
            this.area = area;
        }

        public static class AreaBean {
            /**
             * code : 110101
             * name : 西城区
             */

            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
