package com.example.videosearch;

import java.util.List;

import io.reactivex.Observable;

public interface Repository {

    Observable<List<String>> searchGif(String query, int limit, int offset);

}
