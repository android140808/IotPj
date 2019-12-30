package cn.zhian.avater.iotproject.bean;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-26 11:55
 * @Description:
 */
public class AddHomeBean {
    private int iconId;
    private int name;
    private boolean isSelect = false;

    public AddHomeBean() {
    }

    public AddHomeBean(int iconId, int name) {
        this.iconId = iconId;
        this.name = name;
    }

    public AddHomeBean(int iconId, int name, boolean isSelect) {
        this.iconId = iconId;
        this.name = name;
        this.isSelect = isSelect;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public int getName() {
        return name;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public void setName(int name) {
        this.name = name;
    }

}
