package com.example.martin.resume2015;

/**
 * Created by Martin on 6/20/2015.
 */
public class Job {
    String title;
    String location;
    String dates;
    int photoId;

    Job(String title, String location, String dates, int photoId){
        this.title=title;
        this.location=location;
        this.dates=dates;
        this.photoId=photoId;
    }

    @Override
    public String toString(){
        return title + "|" + location + "|" + dates + "|" + photoId;
    }
}
