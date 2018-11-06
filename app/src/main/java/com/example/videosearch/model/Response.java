package com.example.videosearch.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class  Response {

    @SerializedName("data") @Expose private List<SingleGif> gifList;

    public List<SingleGif> getGifList() {
        return gifList;
    }

    public void setGifList(List<SingleGif> gifList) {
        this.gifList = gifList;
    }
}
