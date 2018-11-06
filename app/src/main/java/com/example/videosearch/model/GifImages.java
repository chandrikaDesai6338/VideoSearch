package com.example.videosearch.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GifImages {

    @SerializedName("original") @Expose private Original originalGif;
    @SerializedName("preview_gif") @Expose private Preview previewUrl;
    public Original getOriginalGif() {
        return originalGif;
    }

    public Preview getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(Preview previewUrl) {
        this.previewUrl = previewUrl;
    }

    public void setOriginalGif(Original originalGif) {
        this.originalGif = originalGif;
    }
}
