package com.example.henry.itreview.myclass;

/**
 * Created by Henry on 2018/6/25.
 */

public class ForumList {
    private String name;
    private int imageId;
    public ForumList (String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName () {
        return name;
    }

    public int getImageId () {
        return imageId;
    }
}
