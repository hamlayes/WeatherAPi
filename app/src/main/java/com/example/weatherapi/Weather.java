package com.example.weatherapi;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Weather implements Serializable {
    @SerializedName("temp")
    private double temp;

    public double getTemp() {
        return temp;
    }

    @SerializedName("feels_like")
    private double feelsLike;
}
