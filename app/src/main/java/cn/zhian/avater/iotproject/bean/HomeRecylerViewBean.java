package cn.zhian.avater.iotproject.bean;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-18 14:44
 * @Description:
 */
public class HomeRecylerViewBean {
    private int index;
    private String modeName;
    private int resId;

    public HomeRecylerViewBean(int index, String modeName, int resId) {
        this.index = index;
        this.modeName = modeName;
        this.resId = resId;
    }

    public HomeRecylerViewBean() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
