package com.example.weatherapi;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ForecastData implements Serializable {
    @SerializedName("list")
    ArrayList<Forecast> previsions;

    public ArrayList<Forecast> getPrevisions() {
        return previsions;
    }
}
