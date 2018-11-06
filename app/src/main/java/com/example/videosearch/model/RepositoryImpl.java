package com.example.videosearch.model;

import com.example.videosearch.GifApplication;
import com.example.videosearch.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RepositoryImpl implements Repository {

    private final Mapper mapper;

    @Inject
    RepositoryImpl(Mapper mapper){
        this.mapper = mapper;
    }

    @Override public Observable<List<String>> searchGif(String query, int limit, int offset) {

        return GifApplication
                .getApi()
                .searchGiphy(query, limit, offset)
                .map(mapper)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
