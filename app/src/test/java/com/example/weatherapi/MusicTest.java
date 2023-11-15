package com.example.weatherapi;

import junit.framework.TestCase;

public class MusicTest extends TestCase {

    public void testGetDegre() {
        Music music = new Music("Test Song", "Test Artist", 25);
        assertEquals(25, music.getDegre());
    }
}