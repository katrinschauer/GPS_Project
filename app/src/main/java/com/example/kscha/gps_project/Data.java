package com.example.kscha.gps_project;

import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by kscha on 12.02.2018.
 */

public class Data implements Serializable {
    Double latitude;
    Double longitude;
    String myDate;

    public Data(Double latitude, Double longitude, String myDate) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.myDate = myDate;
    }

    public Data() {
    }

    @Override
    public String toString() {
        return "longitude="+longitude  + '\'' +
                "latitude=" + latitude + '\'' +
                "myDate=" + myDate + '\'';
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getMyDate() {
        return myDate;
    }
}
