package com.example.videosearch.model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;

public class Mapper implements Function<Response, List<String>> {

    @Inject
    public Mapper() {
    }

    @Override
    public List<String> apply(Response response) throws Exception {
        List<SingleGif> gifList = response.getGifList();
        List<String> urlsList = new ArrayList<>();
        List<String> urlsMp4List = new ArrayList<>();

        for (SingleGif gif : gifList) {
            if (gif.getImages() != null &&
                    gif.getImages().getPreviewUrl() != null &&
                    gif.getImages().getPreviewUrl().getGifUrl() != null) {

                urlsList.add(gif
                        .getImages()
                        .getPreviewUrl()
                        .getGifUrl()
                );

                urlsMp4List.add(gif
                        .getImages()
                        .getOriginalGif()
                        .getUrl());
            }
        }


        return urlsList;
    }

}