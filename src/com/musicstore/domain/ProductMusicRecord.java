package com.musicstore.domain;
import com.musicstore.utils.RecordType;

import java.util.*;
public class ProductMusicRecord extends AbstractProduct {

    private RecordType type;
    private int duration; //seconds
    private ArrayList<String> tracks;

    public ProductMusicRecord(int productId, String productName, double productPrice, int productStock, RecordType type) {
        super(productId, productName, productPrice, productStock);

        this.type = type;

    }

    @Override
    public String toString() {
        return "ProductMusicRecord{" +
                "type=" + type +
                ", duration=" + duration +
                ", tracks=" + tracks +
                '}';
    }

    public RecordType getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public List<String> getTracks() {
        return tracks;
    }

    //method to add/edit tracks

    //ToDo: maybe use map for one or more tracks
    public void addTrack(String trackName, int trackDuration){

        if(this.tracks == null)
            this.tracks = new ArrayList<String>();

        this.duration += trackDuration;
        this.tracks.add(trackName);

    }

    //Todo: Exception if the track doesnt exist
    public void editTrack(String oldName, String newName){

        int index = tracks.indexOf(oldName);
        tracks.set(index, newName);

    }
    public void deleteTrack(String trackName){

        tracks.remove(trackName);

    }

    public void showAllTracks(){

        System.out.println(this.tracks);

    }

    public void showTotalDuration(){

        System.out.println(this.duration);

    }

}
