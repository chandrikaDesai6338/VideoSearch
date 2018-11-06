package com.example.videosearch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Preview {
    @SerializedName("url")
    @Expose
    private String url;

    public String getGifUrl() {
        return url;
    }

    public void setGifUrl(String url) {
        this.url = url;
    }
}
