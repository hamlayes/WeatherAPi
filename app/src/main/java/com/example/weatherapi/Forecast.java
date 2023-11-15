package com.example.weatherapi;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Forecast implements Serializable {
    @SerializedName("main")
    Weather weather;
    @SerializedName("dt")
    private int datetime;

}
