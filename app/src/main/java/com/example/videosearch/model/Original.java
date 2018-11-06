package com.example.videosearch.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Original {

    @SerializedName("mp4")
    @Expose
    private String mp4;

    public String getUrl() {
        return mp4;
    }

    public void setUrl(String url) {
        this.mp4 = mp4;
    }
}
