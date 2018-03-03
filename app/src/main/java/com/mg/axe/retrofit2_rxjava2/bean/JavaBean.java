package com.mg.axe.retrofit2_rxjava2.bean;

import android.os.Parcel;
import android.os.Parcelable;


public class JavaBean implements Parcelable {

    private int carId;
    private int pNumber;
    private String autoPay;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getPnumber() {
        return pNumber;
    }

    public void setPnumber(int pnumber) {
        this.pNumber = pnumber;
    }

    public String getAutoPay() {
        return autoPay;
    }

    public void setAutoPay(String autoPay) {
        this.autoPay = autoPay;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.carId);
        dest.writeInt(this.pNumber);
        dest.writeString(this.autoPay);
    }

    public JavaBean() {
    }

    protected JavaBean(Parcel in) {
        this.carId = in.readInt();
        this.pNumber = in.readInt();
        this.autoPay = in.readString();
    }

    public static final Parcelable.Creator<JavaBean> CREATOR = new Parcelable.Creator<JavaBean>() {
        @Override
        public JavaBean createFromParcel(Parcel source) {
            return new JavaBean(source);
        }

        @Override
        public JavaBean[] newArray(int size) {
            return new JavaBean[size];
        }
    };
}
