package cn.zhian.avater.iotproject.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class CommMessageBean implements Parcelable {
    public int type;
    public boolean isRead;
    public String tittle;
    public String detail;
    public String date;

    public CommMessageBean() {
    }

    public CommMessageBean(int type, boolean isRead, String tittle, String detail, String date) {
        this.type = type;
        this.isRead = isRead;
        this.tittle = tittle;
        this.detail = detail;
        this.date = date;
    }

    protected CommMessageBean(Parcel in) {
        type = in.readInt();
        isRead = in.readByte() != 0;
        tittle = in.readString();
        detail = in.readString();
        date = in.readString();
    }

    public static final Creator<CommMessageBean> CREATOR = new Creator<CommMessageBean>() {
        @Override
        public CommMessageBean createFromParcel(Parcel in) {
            return new CommMessageBean(in);
        }

        @Override
        public CommMessageBean[] newArray(int size) {
            return new CommMessageBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(type);
        parcel.writeByte((byte) (isRead ? 1 : 0));
        parcel.writeString(tittle);
        parcel.writeString(detail);
        parcel.writeString(date);
    }
}
