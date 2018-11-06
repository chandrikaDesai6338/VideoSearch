package com.example.videosearch.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingleGif {

    @SerializedName("images") @Expose private GifImages images;

    public GifImages getImages() {
        return images;
    }

    public void setImages(GifImages images) {
        this.images = images;
    }
}
