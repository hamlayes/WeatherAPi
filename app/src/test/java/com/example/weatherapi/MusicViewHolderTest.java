package com.example.weatherapi;

import junit.framework.TestCase;

public class MusicViewHolderTest extends TestCase {

    public void testGetArtistTextView() {
        Music music = new Music("Bolide Allemand", "SDM", 22);


        assertEquals("SDM", music.getArtist());
    }
}