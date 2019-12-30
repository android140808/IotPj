package cn.zhian.avater.iotproject.bean;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-25 16:15
 * @Description:
 */
public class LeftBean {
    private boolean isSelect = false;
    private String type;

    public LeftBean(boolean isSelect, String type) {
        this.isSelect = isSelect;
        this.type = type;
    }

    public LeftBean() {
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "LeftBean{" +
                "isSelect=" + isSelect +
                ", type='" + type + '\'' +
                '}';
    }
}
