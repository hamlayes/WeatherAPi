package com.example.weatherapi;

import java.util.ArrayList;
import java.util.List;

public class Music {
    private String title;
    private String artist;
    private int degre;
    List<Music> musicList = new ArrayList<>();
    public Music(String title, String artist, int degre) {
        this.title = title;
        this.artist = artist;
        this.degre = degre;
    }

    public int getDegre() {
        return degre;
    }


    public String getArtist() {
        return artist;
    }


    public String getTitle() {
        return title;
    }


}
