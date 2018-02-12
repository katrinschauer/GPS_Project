package com.example.kscha.gps_project;

import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by kscha on 12.02.2018.
 */

public class Data implements Serializable {
    String latitude;
    String longitude;
    String myDate;

    public Data(String latitude, String longitude, String myDate) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.myDate = myDate;
    }

    @Override
    public String toString() {
        return "longitude="+longitude  + '\'' +
                "latitude=" + latitude + '\'' +
                "myDate=" + myDate + '\'';
    }
}
