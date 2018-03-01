package com.mg.axe.retrofit2_rxjava2.block;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author Zaifeng
 * @Create 2017/8/29 0029
 * @Description 我的车辆
 */

public class CarBean implements Parcelable {

    public static String AUTO_PAY = "0";
    public static String NOT_AUTO_PAY = "1";

    /**
     * carId : 1129050
     * pnumber : 测试12345
     * autoPay : 0
     */

    private String carId;
    private String pNumber;
    private String autoPay;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getPnumber() {
        return pNumber;
    }

    public void setPnumber(String pnumber) {
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
        dest.writeString(this.carId);
        dest.writeString(this.pNumber);
        dest.writeString(this.autoPay);
    }

    public CarBean() {
    }

    protected CarBean(Parcel in) {
        this.carId = in.readString();
        this.pNumber = in.readString();
        this.autoPay = in.readString();
    }

    public static final Parcelable.Creator<CarBean> CREATOR = new Parcelable.Creator<CarBean>() {
        @Override
        public CarBean createFromParcel(Parcel source) {
            return new CarBean(source);
        }

        @Override
        public CarBean[] newArray(int size) {
            return new CarBean[size];
        }
    };
}
