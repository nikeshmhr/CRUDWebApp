package com.crudwebapp.model;

/**
 *
 * @author nikesh.maharjan
 */
public class Album {

    private int id;
    private String albumTitle;
    private String band;
    private String year;
    private int noOfTracks;

    public Album() {
    }

    public Album(String title, String band, String year, int noOfTracks) {
        this.albumTitle = title;
        this.band = band;
        this.year = year;
        this.noOfTracks = noOfTracks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getNoOfTracks() {
        return noOfTracks;
    }

    public void setNoOfTracks(int noOfTracks) {
        this.noOfTracks = noOfTracks;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Title: " + albumTitle + ", Band: " + band + ", Year: " + year + ", No. of Tracks: " + noOfTracks;
    }

}
