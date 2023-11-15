package com.example.weatherapi;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherServices {
    @GET("forecast?q=Annecy&appid=e075a0b59517e88cc46940bb262add13&units=metric")
    Call<ForecastData> getForcast();
    @GET("forecast")
    Call<ForecastData> getForecast(
            @Query("q") String location,
            @Query("appid") String apiKey,
            @Query("units") String unit
    );

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
