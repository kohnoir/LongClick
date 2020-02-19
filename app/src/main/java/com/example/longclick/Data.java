package com.example.longclick;

import android.graphics.drawable.Drawable;

public class Data {

    private Drawable image;
    private String title;
    private String subtitle;


    public Data(Drawable image, String title, String subtitle ) {
        this.image = image;
        this.title = title;
        this.subtitle = subtitle;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}